package com.edi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by nairr5 on 7/6/16.
 */
@Component
@ConfigurationProperties(prefix = "edifact.parser")
public class ApplicationConfiguration {

    private String dropLocation;

    private String outputLocation;

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getOutputLocation() {
        return outputLocation;
    }

    public void setOutputLocation(String outputLocation) {
        this.outputLocation = outputLocation;
    }
}
