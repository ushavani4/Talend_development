package com.aero.ic.fdr.message.eqp;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/19/16.
 */
public class CompanyDetails extends EdiField {

    private String aircraftOwner;

    public String getAircraftOwner() {
        return aircraftOwner;
    }

    public void setAircraftOwner(String aircraftOwner) {
        this.aircraftOwner = aircraftOwner;
    }
}
