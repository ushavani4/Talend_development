package com.aero.ic.fdr.message;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 7/30/16.
 */
public class OutBoundFlight extends EdiField {

    private String flightNumber;

    private String operationalSuffix;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOperationalSuffix() {
        return operationalSuffix;
    }

    public void setOperationalSuffix(String operationalSuffix) {
        this.operationalSuffix = operationalSuffix;
    }

}
