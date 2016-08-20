package com.aero.ic.fdr.message.eqd;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/20/16.
 */
public class EQD extends EdifactSegment {

    private ConfigurationDetails configurationDetails;

    private String configurationCode;

    private String cabinVersion;

    private String configurationDescription;

    public ConfigurationDetails getConfigurationDetails() {
        return configurationDetails;
    }

    public void setConfigurationDetails(ConfigurationDetails configurationDetails) {
        this.configurationDetails = configurationDetails;
    }

    public String getConfigurationCode() {
        return configurationCode;
    }

    public void setConfigurationCode(String configurationCode) {
        this.configurationCode = configurationCode;
    }

    public String getCabinVersion() {
        return cabinVersion;
    }

    public void setCabinVersion(String cabinVersion) {
        this.cabinVersion = cabinVersion;
    }

    public String getConfigurationDescription() {
        return configurationDescription;
    }

    public void setConfigurationDescription(String configurationDescription) {
        this.configurationDescription = configurationDescription;
    }
}
