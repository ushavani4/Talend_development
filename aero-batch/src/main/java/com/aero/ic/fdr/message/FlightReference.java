package com.aero.ic.fdr.message;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/17/16.
 */
public class FlightReference extends EdiField {

    private String flightNo;

    private String operationalSuffix;


    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getOperationalSuffix() {
        return operationalSuffix;
    }

    public void setOperationalSuffix(String operationalSuffix) {
        this.operationalSuffix = operationalSuffix;
    }
}
