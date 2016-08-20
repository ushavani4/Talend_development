package com.aero.ic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by nairr5 on 7/25/16.
 */

@Component
@ConfigurationProperties(prefix = "aero.batch")
public class AeroApplicationConfig {

    private String dropZone;

    private String fileNamePattern;

    private String outZone;

    private String fdrMappingFile;

    public String getFdrMappingFile() {
        return fdrMappingFile;
    }

    public void setFdrMappingFile(String fdrMappingFile) {
        this.fdrMappingFile = fdrMappingFile;
    }

    public String getDropZone() {
        return dropZone;
    }

    public void setDropZone(String dropZone) {
        this.dropZone = dropZone;
    }

    public String getFileNamePattern() {
        return fileNamePattern;
    }

    public void setFileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }

    public String getOutZone() {
        return outZone;
    }

    public void setOutZone(String outZone) {
        this.outZone = outZone;
    }
}
