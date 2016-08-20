package com.aero.ic.fdr.message.eqn;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/20/16.
 */
public class NumberOfUnitsDetails extends EdiField {

    private String numberOfUnits;

    private String numberOfUnitsQualifier;

    public String getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(String numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public String getNumberOfUnitsQualifier() {
        return numberOfUnitsQualifier;
    }

    public void setNumberOfUnitsQualifier(String numberOfUnitsQualifier) {
        this.numberOfUnitsQualifier = numberOfUnitsQualifier;
    }
}
