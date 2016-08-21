package com.aero.ic.batch.mapper;

import com.aero.ic.batch.context.ParserContext;
import com.aero.ic.batch.context.SegmentToValue;
import com.aero.ic.batch.exception.BatchException;
import com.aero.ic.mapping.EdiMapping;
import com.aero.ic.mapping.SegmentGroupType;
import com.aero.ic.mapping.SegmentType;
import com.aero.ic.message.base.EdifactMessage;
import com.aero.ic.message.base.EdifactSegment;
import com.aero.ic.message.base.EdifactSegmentFactory;
import com.aero.ic.message.base.EdifactSegmentGroup;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by nairr5 on 7/25/16.
 */
public abstract class EdifactMessageMapper {

    private Log log = LogFactory.getLog(EdifactMessageMapper.class);

    private static final String CONTAINER_PATH = "/edi-mapping/container";

    private EdifactSegmentFactory edifactSegmentFactory = EdifactSegmentFactory.newInstance();


    public void setEdifactSegmentFactory(EdifactSegmentFactory edifactSegmentFactory) {
        this.edifactSegmentFactory = edifactSegmentFactory;
    }

    public abstract ParserContext getParserContext();

    public EdifactMessage map(List<String> lines) throws Exception {

        if(CollectionUtils.isEmpty(lines)) {
            return null;
        }

        ParserContext parserContext = getParserContext();

        Map<String, SegmentToValue> config = Maps.newHashMap();

        JXPathContext mappingContext = parserContext.getMappingContext();

        EdifactMessage container = parserContext.getContainer();

        EdiMapping mapping = parserContext.getEdiMapping();

        config.put(CONTAINER_PATH, new SegmentToValue(this.findNode(mappingContext, CONTAINER_PATH), container));

        SegmentGroupType firstGroup = mapping.getContainer().getSegmentGroup();

        EdifactSegmentGroup edifactSegmentGroup = this.getInstance(firstGroup);

        config.put(firstGroup.getPath() + "/segmentGroup[@id='" + firstGroup.getId() + "']", new SegmentToValue(firstGroup, edifactSegmentGroup));

        PropertyUtils.setProperty(container, firstGroup.getPropertyName(), edifactSegmentGroup);

        String segCode;
        SegmentToValue parent = config.get(CONTAINER_PATH);

        List<SegmentType> incomingSegments = Lists.newArrayList();
        Object value;
        EdifactSegmentGroup segmentGroupInstance;
        SegmentGroupType segmentGroupType;

        for (String line : lines) {

            segCode = this.findSegmentCode(line);
            SegmentType segmentType = parserContext.ngram(segCode, parent.getNode(), incomingSegments, 1);

            if(segmentType != null) {
                incomingSegments.add(segmentType);

                value = this.parse(segmentType, segCode, line);
                String path = segmentType.getPath();
                parent = config.get(path);
                if(parent == null) {
                    //parent not found, this may be a segment group, if its a segment group then
                    //add it to the config map
                    Object o = findNode(mappingContext, path);
                    if(o instanceof SegmentGroupType) {
                        segmentGroupType = (SegmentGroupType) o;
                        segmentGroupInstance = getInstance(segmentGroupType);
                        config.put(path, new SegmentToValue(segmentGroupType, segmentGroupInstance));
                        PropertyUtils.setProperty(config.get(segmentGroupType.getPath()).getInstance(), segmentGroupType.getPropertyName(), segmentGroupInstance);
                        parent = config.get(path);
                    } else {
                        throw new BatchException("Parent not found in the node mapping");
                    }
                }

                if(segmentType.isHeader()) {
                    config.put(path + "/headerSegment[@id='" + segmentType.getId() + "']", new SegmentToValue(segmentType, value));
                } else if(segmentType.isTrailer()) {
                    config.put(path + "/trailerSegment[@id='" + segmentType.getId() + "']", new SegmentToValue(segmentType, value));
                } else {
                    config.put(path + "/segment[@id='" + segmentType.getId() + "']", new SegmentToValue(segmentType, value));
                }


                if(parent.getInstance() instanceof EdifactSegmentGroup) {
                    ((EdifactSegmentGroup) parent.getInstance()).addSegment((EdifactSegment) value);
                } else if(parent.getInstance() instanceof EdifactSegment || parent.getInstance() instanceof EdifactMessage) {
                    PropertyUtils.setProperty(parent.getInstance(), segmentType.getPropertyName(), value);
                } else {
                    throw new BatchException("Parent not found for [" + segmentType.getCode() + "] path [" + segmentType.getPath() + "]");
                }
            }
        }
        return container;
    }

    private Object findNode(JXPathContext context, String path) {
        if(StringUtils.startsWithIgnoreCase(path, "/edi-mapping")) {
            path = StringUtils.remove(path, "/edi-mapping");
        }

        return context.getValue(path);
    }

    private EdifactSegmentGroup getInstance(SegmentGroupType sgtype) {
        EdifactSegmentGroup esg = new EdifactSegmentGroup();
        esg.setId(sgtype.getId());
        return esg;
    }

    private String findSegmentCode(String l) {
        int segmentTerminatorIndex = l.indexOf("+");
        if(segmentTerminatorIndex >= 0) {
            return StringUtils.substring(l, 0, segmentTerminatorIndex);
        } else {
            return l;
        }
    }

    private EdifactSegment parse(SegmentType segmentType, String segCode, String line) throws Exception {
       return this.edifactSegmentFactory.createSegment(segmentType, segCode, line);
    }
}
