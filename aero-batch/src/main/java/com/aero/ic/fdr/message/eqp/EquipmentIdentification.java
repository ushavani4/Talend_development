package com.aero.ic.fdr.message.eqp;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/19/16.
 */
public class EquipmentIdentification extends EdiField {

    private String airCraftType;

    private String airlineInternalCode;

    private String eqtRegistrationNumber;

    public String getAirCraftType() {
        return airCraftType;
    }

    public void setAirCraftType(String airCraftType) {
        this.airCraftType = airCraftType;
    }

    public String getAirlineInternalCode() {
        return airlineInternalCode;
    }

    public void setAirlineInternalCode(String airlineInternalCode) {
        this.airlineInternalCode = airlineInternalCode;
    }

    public String getEqtRegistrationNumber() {
        return eqtRegistrationNumber;
    }

    public void setEqtRegistrationNumber(String eqtRegistrationNumber) {
        this.eqtRegistrationNumber = eqtRegistrationNumber;
    }
}
