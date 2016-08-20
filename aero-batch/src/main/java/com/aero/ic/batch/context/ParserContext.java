package com.aero.ic.batch.context;

import com.aero.ic.mapping.ContainerType;
import com.aero.ic.mapping.EdiMapping;
import com.aero.ic.mapping.SegmentGroupType;
import com.aero.ic.mapping.SegmentType;
import com.aero.ic.message.base.EdifactMessage;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * Created by nairr5 on 8/1/16.
 */
public class ParserContext {

    private Log log = LogFactory.getLog(ParserContext.class);

    private String ediMappingConfig;

    private EdiMapping ediMapping;

    private List<Object> contentSequence = Lists.newArrayList();

    private List<SegmentType> segmentSequence = Lists.newArrayList();

    private JXPathContext mappingContext;

    @PostConstruct
    public void postConstruct() throws Exception {
        Assert.notNull(ediMappingConfig);

        File mappingFile = new File(ediMappingConfig);
        JAXBContext context = JAXBContext.newInstance(EdiMapping.class);


        this.ediMapping = (EdiMapping) context.createUnmarshaller().unmarshal(mappingFile);
        this.mappingContext = JXPathContext.newContext(ediMapping);

        this.init(ediMappingConfig);
    }

    /**
     *
     * prepares a sequential representation xml, the method creates a List of segments and segmentGroups as it
     * appears in the configuration xml file
     *
     * eg:
     * [ST(UNH), SGT(sg1), ST(FDR), SGT(sg2), ST(DAT), ST(LTS), SGT(sg3), ST(EQI), ST(UNT)]
     *
     * This will be used to validate the branching logic appearing in the edifact file.
     *
     * @param mappingXmlFile
     * @throws Exception
     */
    public void init(String mappingXmlFile) throws Exception {
        File f = new File(mappingXmlFile);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(true);

        Document document = factory.newDocumentBuilder().parse(f);
        document.normalize();

        //Look for Xml element 'container' thats the start of our edifact file configuration
        NodeList containerNodeList = document.getElementsByTagName("container");

        if(containerNodeList != null) {
            //item(0) is the 'container' element, go throuh the children
            //of container element and populate Segment, SegmentGroup
            Node containerNode = containerNodeList.item(0);
            containerNode.normalize();

            NodeList children = containerNode.getChildNodes();
            if(children != null) {
                for (int i = 0; i < children.getLength(); i++) {
                    this.extract(children.item(i));
                }
            }
        }

        log.debug(this.contentSequence);
    }

    /**
     * extract the segment and segmentGroups from the node recursively. Populate the contentSequence List
     * as it appears in the xml. The list is a flattened representation of xml segment/segmentGroup nodes.
     *
     * We dont need the other nodes such as Field/Component etc, those can be fetched from EdiMapping instance
     *
     * @param node
     */
    private void extract(Node node) {
        if(node == null) { return; }

        if(Lists.newArrayList("headerSegment", "trailerSegment", "segment", "segmentGroup").contains(node.getNodeName())) {
            Object o = this.getNode(node);
            this.contentSequence.add(o);
            if(o instanceof SegmentType) {
                this.segmentSequence.add(((SegmentType) o));
            }
        }

        NodeList children = node.getChildNodes();
        for(int i = 0; i < children.getLength(); i++) {
            this.extract(children.item(i));
        }
    }

    private Object getNode(Node node) {
        Object type = null;
        NamedNodeMap nodeMap = node.getAttributes();

        if(nodeMap.getNamedItem("path") != null) {
            String path = nodeMap.getNamedItem("path").getNodeValue();
            path = StringUtils.remove(path, "/edi-mapping");
            path = path + "/" + node.getNodeName() + "[@id='" + nodeMap.getNamedItem("id").getNodeValue() + "']";
            type = mappingContext.getValue(path);
        }
        return type;
    }

    public JXPathContext getMappingContext() {
        return mappingContext;
    }

    public SegmentType findSegment(String segCode) {
        if(ediMapping != null && ediMapping.getContainer() != null) {
            SegmentType header = ediMapping.getContainer().getHeaderSegment();
            if(header != null && StringUtils.equalsIgnoreCase(segCode, header.getCode())) {
                return header;
            }

            SegmentType trailer = ediMapping.getContainer().getTrailerSegment();

            if(trailer != null && StringUtils.equalsIgnoreCase(segCode, trailer.getCode())) {
                return trailer;
            }

            if(ediMapping.getContainer().getSegmentGroup() != null) {
                List<SegmentType> segmentTypes = ediMapping.getContainer().getSegmentGroup().getSegment();
                for (SegmentType st : segmentTypes) {
                    if(StringUtils.equalsIgnoreCase(st.getCode(), segCode)) {
                        return st;
                    }
                }
            }
        }

        return null;
    }



    public SegmentType ngram(String code, Object parent, List<SegmentType> previous, int n) {
        SegmentType type = null;

        List<SegmentType> children = this.findSegments(code, parent);
        if(CollectionUtils.isEmpty(children)) {
            log.warn("Found no segments matching code [" + code + "] under parent [" + parent + "]");
            return null;
        }
        log.debug("Found [" + children.size() + "] segments matching code [" + code + "] under parent [" + parent + "]");

        if(CollectionUtils.isEmpty(previous)) {
            type = children.get(0);
        } else {
            log.debug("Found more than one segments matching code [" + code + "] under parent [" + parent + "]");

            SegmentType lastSegment = previous.get(previous.size() - 1);
            log.debug("Last segment was code [" + lastSegment.getCode() + "] id [" + lastSegment.getId() + "]");
            int previousSegmentIndex = this.segmentSequence.indexOf(lastSegment);
            int segmentLookupIndex = 0;
            for (SegmentType t : children) {
                segmentLookupIndex = this.segmentSequence.indexOf(t) - 1;
                if(previousSegmentIndex == segmentLookupIndex) {
                    log.debug("Selected segment [" + t.getCode() + "] id [" + t.getId() + "]");
                    type = t;
                    break;
                } else if(previousSegmentIndex < segmentLookupIndex) {
                    //There may be conditional segments mising in the file, go back to previous segment from index(t)
                    //and see whether there was any mandatory segment missing
                    int difference = segmentLookupIndex;
                    while(previousSegmentIndex <= difference) {
                        SegmentType previousSegment = this.segmentSequence.get(difference);
                        if(previousSegment.getMinOccurs() == 0) {
                            log.debug("Previous segment [" + previousSegment.getCode() + "] is not mandatory under parent [" + parent + "]");
                        } else if(previousSegment.getMinOccurs() >= 1) {
                            log.debug("Found a mandatory segment [" + previousSegment.getCode() + "] under parent [" + parent + "]");
                            if(lastSegment.equals(previousSegment)) {
                                type = t;
                            }
                        }
                        difference--;
                    }

                }
            }
        }
        return type;
    }

    public List<SegmentType> findSegments(String code, Object o) {
        if(o == null) {
            return Lists.newArrayList(findSegment(code));
        }

        List<SegmentType> segments = Lists.newArrayList();

        if(o instanceof SegmentType) {
            log.debug("Finding a segment [" + code + "] under parent [" + ((SegmentType) o).getId() + "]");
            List<SegmentType> types = ((SegmentType) o).getSegment();
            segments.addAll(types.stream().filter(t -> StringUtils.equalsIgnoreCase(t.getCode(), code)).collect(Collectors.toList()));
            List<SegmentGroupType> groups = ((SegmentType) o).getSegmentGroup();
            for (SegmentGroupType sgt : groups) {
                List<SegmentType> segTypes = sgt.getSegment();
                segments.addAll(segTypes.stream().filter(t -> StringUtils.equalsIgnoreCase(t.getCode(), code)).collect(Collectors.toList()));
            }
        } else if(o instanceof ContainerType) {
            log.debug("Finding segment [" + code + "] under container");
            if(StringUtils.equalsIgnoreCase(((ContainerType) o).getHeaderSegment().getCode(), code)) {
                segments.add(((ContainerType) o).getHeaderSegment());
            }
            if(StringUtils.equalsIgnoreCase(((ContainerType) o).getTrailerSegment().getCode(), code)) {
                segments.add(((ContainerType) o).getHeaderSegment());
            }
            SegmentGroupType segmentGroupType = ((ContainerType) o).getSegmentGroup();
            List<SegmentType> types = segmentGroupType.getSegment();
            segments.addAll(types.stream().filter(t -> StringUtils.equalsIgnoreCase(t.getCode(), code)).collect(Collectors.toList()));
        } else if(o instanceof SegmentGroupType) {
            log.debug("Finding a segment [" + code + "] under parent [" + ((SegmentGroupType) o).getId() + "]");
            List<SegmentType> types = ((SegmentGroupType) o).getSegment();
            segments.addAll(types.stream().filter(t -> StringUtils.equalsIgnoreCase(t.getCode(), code)).collect(Collectors.toList()));
            types.forEach(t -> t.getSegment().stream().filter(s -> StringUtils.equalsIgnoreCase(s.getCode(), code)).forEach(segments::add));
        }

        return segments;
    }


    public void setEdiMappingConfig(String ediMappingConfig) {
        this.ediMappingConfig = ediMappingConfig;
    }

    public String getEdiMappingConfig() {
        return ediMappingConfig;
    }

    public EdiMapping getEdiMapping() {
        return ediMapping;
    }

    public List<Object> getContentSequence() {
        return ImmutableList.copyOf(contentSequence);
    }

    public static boolean isSegmentGroupType(Object o) {
        return (o instanceof SegmentGroupType);
    }

    public static boolean isSegmentType(Object o) {
        return (o instanceof SegmentType);
    }

    public EdifactMessage getContainer() throws Exception {
        return (EdifactMessage) Class.forName(ediMapping.getContainer().getType()).newInstance();
    }
}
