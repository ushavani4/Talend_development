package com.aero.ic.message.base;

import com.aero.ic.batch.exception.BatchException;
import com.aero.ic.batch.mapper.EdifactMessageMapper;
import com.aero.ic.mapping.ComponentType;
import com.aero.ic.mapping.FieldType;
import com.aero.ic.mapping.SegmentType;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by nairr5 on 7/30/16.
 */
public abstract class EdifactSegment {

    private Log log = LogFactory.getLog(EdifactMessageMapper.class);

    private String id;

    private String segmentCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSegmentCode() {
        return this.segmentCode;
    }

    public void setSegmentCode(String code) {
        this.segmentCode = code;
    }


    public void setFields(SegmentType segmentType) throws Exception {
        this.setSegmentCode(segmentType.getCode());
        this.setId(segmentType.getId());

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
                PropertyUtils.setProperty(this, fieldType.getPropertyName(), field);
            }
        }
    }

    public void parse(SegmentType segmentType, String segCode, String s) {
        try {
            log.debug("Parsing seg code [" + segCode + "]");
            String scopy = new String(s);

            //find starting segment code
            //find next terminiator + or :
            //if + then take as field
            //if : then add as component(s) till find another + or \n

            if (segmentType == null) {
                return;
            }
            if (s.startsWith(segCode)) {

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
                            componentString = s;
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
