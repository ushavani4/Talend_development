package com.aero.ic.fdr.message.eqi;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/19/16.
 */
public class FittedConfiguration extends EdiField {

    private String cabinCode;

    private String cabinCapacity;

    private String qualifier;

    public String getCabinCode() {
        return cabinCode;
    }

    public void setCabinCode(String cabinCode) {
        this.cabinCode = cabinCode;
    }

    public String getCabinCapacity() {
        return cabinCapacity;
    }

    public void setCabinCapacity(String cabinCapacity) {
        this.cabinCapacity = cabinCapacity;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

}
