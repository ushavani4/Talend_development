package com.aero.ic.batch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by nairr5 on 7/25/16.
 */

@Component
@ConfigurationProperties(prefix = "aero.batch.terminator")
public class EdifactTerminatorPolicy {

    private String segmentTerminator = "\\x1C";

    private String componentTerminator = "\\x1D";

    private String elementTerminator = "\\x1F";


    public String getSegmentTerminator() {
        return segmentTerminator;
    }

    public void setSegmentTerminator(String segmentTerminator) {
        this.segmentTerminator = segmentTerminator;
    }

    public String getComponentTerminator() {
        return componentTerminator;
    }

    public void setComponentTerminator(String componentTerminator) {
        this.componentTerminator = componentTerminator;
    }

    public String getElementTerminator() {
        return elementTerminator;
    }

    public void setElementTerminator(String elementTerminator) {
        this.elementTerminator = elementTerminator;
    }
}
