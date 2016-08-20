package com.aero.ic.fdr.message.eqi;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/19/16.
 */
public class EQI extends EdifactSegment {

    private FittedConfiguration fittedConfiguration;

    private String transportIdentification;

    private AcvDetails acvDetails;

    public String getTransportIdentification() {
        return transportIdentification;
    }

    public void setTransportIdentification(String transportIdentification) {
        this.transportIdentification = transportIdentification;
    }

    public FittedConfiguration getFittedConfiguration() {
        return fittedConfiguration;
    }

    public void setFittedConfiguration(FittedConfiguration fittedConfiguration) {
        this.fittedConfiguration = fittedConfiguration;
    }

    public AcvDetails getAcvDetails() {
        return acvDetails;
    }

    public void setAcvDetails(AcvDetails acvDetails) {
        this.acvDetails = acvDetails;
    }
}
