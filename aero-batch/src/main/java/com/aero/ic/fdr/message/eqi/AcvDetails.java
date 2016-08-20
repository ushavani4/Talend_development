package com.aero.ic.fdr.message.eqi;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/19/16.
 */
public class AcvDetails extends EdiField {

    private String airlineDetails;

    private String acvCode;

    public String getAirlineDetails() {
        return airlineDetails;
    }

    public void setAirlineDetails(String airlineDetails) {
        this.airlineDetails = airlineDetails;
    }

    public String getAcvCode() {
        return acvCode;
    }

    public void setAcvCode(String acvCode) {
        this.acvCode = acvCode;
    }
}
