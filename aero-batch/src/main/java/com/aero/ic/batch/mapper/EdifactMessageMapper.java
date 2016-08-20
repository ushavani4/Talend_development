package com.aero.ic.batch.mapper;

import com.aero.ic.batch.context.ParserContext;
import com.aero.ic.batch.context.SegmentToValue;
import com.aero.ic.batch.exception.BatchException;
import com.aero.ic.mapping.*;
import com.aero.ic.message.base.EdifactMessage;
import com.aero.ic.message.base.EdifactSegment;
import com.aero.ic.message.base.EdifactSegmentGroup;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    private ParserContext parserContext;


    public EdifactMessageMapper() {

    }

    public abstract ParserContext getParserContext();

    public EdifactMessage map(List<String> lines) throws Exception {

        if(CollectionUtils.isEmpty(lines)) {
            return null;
        }

        this.parserContext = getParserContext();

        Map<String, SegmentToValue> config = Maps.newHashMap();

        JXPathContext mappingContext = this.parserContext.getMappingContext();

        EdifactMessage container = this.parserContext.getContainer();
        EdiMapping mapping = this.parserContext.getEdiMapping();

        config.put(CONTAINER_PATH, new SegmentToValue(this.findNode(mappingContext, CONTAINER_PATH), container));

        SegmentGroupType segmentGroupType = mapping.getContainer().getSegmentGroup();

        EdifactSegmentGroup edifactSegmentGroup = this.getInstance(segmentGroupType);

        config.put(segmentGroupType.getPath() + "/segmentGroup[@id='" + segmentGroupType.getId() + "']", new SegmentToValue(segmentGroupType, edifactSegmentGroup));

        PropertyUtils.setProperty(container, segmentGroupType.getPropertyName(), edifactSegmentGroup);

        String segCode = null;
        SegmentToValue parent = config.get(CONTAINER_PATH);

        List<SegmentType> incomingSegments = Lists.newArrayList();

        for (String line : lines) {

            segCode = findSegCode(line);

            SegmentType segmentType = parserContext.ngram(segCode, parent.getNode(), incomingSegments, 1);

            if(segmentType != null) {
                incomingSegments.add(segmentType);
                this.parse(segmentType, segCode, line);
                Object value = this.getInstance(segmentType);
                String path = segmentType.getPath();
                parent = config.get(path);
                if(parent == null) {
                    //parent not found, this may be a segment group, if its a segment group then
                    //add it to the config map
                    Object o = findNode(mappingContext, path);
                    if(o instanceof SegmentGroupType) {
                        SegmentGroupType type = (SegmentGroupType) o;
                        EdifactSegmentGroup typeInstance = getInstance(type);
                        config.put(path, new SegmentToValue(type, typeInstance));
                        PropertyUtils.setProperty(config.get(type.getPath()).getInstance(), type.getPropertyName(), typeInstance);
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


    private EdifactSegment getInstance(SegmentType segmentType) throws Exception {
        EdifactSegment edifactSegment = (EdifactSegment) Class.forName(segmentType.getType()).newInstance();
        edifactSegment.setSegmentCode(segmentType.getCode());
        edifactSegment.setId(segmentType.getId());

        List<FieldType> fields = segmentType.getField();
        if(CollectionUtils.isNotEmpty(fields)) {
            for (FieldType fieldType : fields) {
                Object field = Class.forName(fieldType.getType()).newInstance();
                FieldType.Components components = fieldType.getComponents();
                if(components != null) {
                    List<ComponentType> componentTypes = components.getComponent();
                    if(componentTypes != null) {
                        for (ComponentType c : componentTypes) {
                            PropertyUtils.setProperty(field, c.getPropertyName(), c.getValue());
                        }
                    }
                } else if(field instanceof String) {
                    //this is simple field without sub components
                    field = fieldType.getValue();
                }
                PropertyUtils.setProperty(edifactSegment, fieldType.getPropertyName(), field);
            }
        }

        return edifactSegment;
    }

    private EdifactSegmentGroup getInstance(SegmentGroupType sgtype) {
        EdifactSegmentGroup esg = new EdifactSegmentGroup();
        esg.setId(sgtype.getId());
        return esg;
    }

    private String findSegCode(String l) {
        int segmentTerminatorIndex = l.indexOf("+");
        if(segmentTerminatorIndex >= 0) {
            return StringUtils.substring(l, 0, segmentTerminatorIndex);
        } else {
            return l;
        }
    }

    private void parse(SegmentType segmentType, String segCode, String line) throws Exception {
        this.toSegment(segmentType, line, segCode);
        this.parse(segmentType);
    }

    protected abstract void parse(SegmentType segmentType);

    private void toSegment(SegmentType segmentType, String s, String segCode) {
        try {
            log.debug("Parsing seg code [" + segCode + "]");
            String scopy = new String(s);

            //find starting segment code
            //find next terminiator + or :
            //if + then take as field
            //if : then add as component(s) till find another + or \n

            if (segmentType == null) {
                segmentType = new SegmentType();
            }
            if (s.startsWith(segCode)) {

                //mapping.setCode(segCode);

                s = StringUtils.removeStart(s, segCode);
                s = StringUtils.removeStart(s, "+");

                int elementTerminatorIdx = s.indexOf("+");
                int componentTerminatorIdx = s.indexOf(":");

                String value = null;
                FieldType lastField = null;
                int fieldIndex = 0;

                if (elementTerminatorIdx == -1 && componentTerminatorIdx == -1) {
                    //this is an empty segment, set the segcode and continue
                    if (StringUtils.isEmpty(s)) {
                        return;
                    } else {
                        //STX+ACT - in this case the index of + and : will be -1, but there is one element after segcode
                        if (segmentType.getField() != null) {
                            FieldType fieldType = segmentType.getField().get(fieldIndex);
                            if (fieldType != null && fieldType.getComponents() != null) {
                                fieldType.getComponents().getComponent().get(0).setValue(s);
                            }
                        }
                        return;
                    }
                }

                while (StringUtils.isNotEmpty(s)) {
                    if (elementTerminatorIdx != -1 && (elementTerminatorIdx < componentTerminatorIdx || componentTerminatorIdx == -1)) {
                        // contains fields
                        value = StringUtils.substring(s, 0, elementTerminatorIdx);
                        lastField = segmentType.getField().get(fieldIndex++);
                        if (lastField.getComponents() != null && lastField.getComponents().getComponent() != null) {
                            lastField.getComponents().getComponent().get(0).setValue(value);
                        } else {
                            lastField.setValue(value);
                        }
                        s = StringUtils.substring(s, elementTerminatorIdx + 1);
                    } else if (componentTerminatorIdx != -1 && (elementTerminatorIdx == -1 || componentTerminatorIdx < elementTerminatorIdx)) {
                        // contains subcomponents, add it to last field
                        //find any elementTerminator greater than componentTerminator to handle 0:0+0:0:0:0:0:0:0+L0+0:0:0
                        int nextElementTerminatorIndex = s.indexOf("+");
                        String componentString = null;

                        if (nextElementTerminatorIndex == -1) {
                            //that means no more + in this line. To split components, take the full string
                            componentString = new String(s);
                            s = "";
                        } else {
                            componentString = s.substring(0, nextElementTerminatorIndex);
                            s = StringUtils.substring(s, nextElementTerminatorIndex + 1, s.length());
                        }

                        String[] components = componentString.split(":");
                        if (segmentType.getField() != null && segmentType.getField().size() > fieldIndex) {
                            lastField = segmentType.getField().get(fieldIndex);
                        }
                        fieldIndex++;

                        int cindex = 0;
                        for (String c : components) {
                            lastField.getComponents().getComponent().get(cindex++).setValue(c);
                        }
                    } else {
                        //still contains an element after + or :, see whats the last terminator in the original line scopy
                        //if its + then add it as new element else add it as new component
                        if (StringUtils.isNotEmpty(s)) {
                            //in the scopy search from end and find the terminator before the current element
                            int lastTerminatorIdx = scopy.lastIndexOf(s) - 1;

                            if (lastTerminatorIdx >= 0 && scopy.toCharArray()[lastTerminatorIdx] == ':') {
                                //TODO: this is wrong, the fieldIndex is to traverse fields not component
                                //this is a last component, keep track of component index and set it
                                //or should we require this?, if it was not + as the last terminator we will not reach here
                                lastField.getComponents().getComponent().get(fieldIndex++).setValue(s);
                            } else if (lastTerminatorIdx >= 0) {
                                //this is next field
                                lastField = segmentType.getField().get(fieldIndex);
                                log.trace("Setting Field [" + lastField.getPropertyName() + "] under [" + segmentType.getCode() + "] fieldIndex [" + fieldIndex + "]");
                                fieldIndex++;
                                if (lastField.getComponents() != null && lastField.getComponents().getComponent() != null) {
                                    log.trace("Last field, setting it to first component [" + lastField.getComponents().getComponent().get(0).getPropertyName() + "]");
                                    lastField.getComponents().getComponent().get(0).setValue(s);
                                } else {
                                    log.trace("No components, setting it to field [" + lastField.getPropertyName() + "]");
                                    lastField.setValue(s);
                                }
                            }
                        }
                        s = "";
                    }

                    elementTerminatorIdx = s.indexOf("+");
                    componentTerminatorIdx = s.indexOf(":");
                }
            }
        } catch (Exception e) {
            log.error("Caught exception ", e);
        }
    }
}
