package com.aero.ic.fdr.message;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 7/30/16.
 */
public class OutBoundCarrier extends EdiField {

    private String airlineCode;

    private String carrierId;

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

}
