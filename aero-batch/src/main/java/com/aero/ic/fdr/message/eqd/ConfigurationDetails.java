package com.aero.ic.fdr.message.eqd;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/20/16.
 */
public class ConfigurationDetails extends EdiField {

    private String cabinCode;

    private String cabinCapacity;

    private String characteristic;

    public String getCabinCapacity() {
        return cabinCapacity;
    }

    public void setCabinCapacity(String cabinCapacity) {
        this.cabinCapacity = cabinCapacity;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getCabinCode() {
        return cabinCode;
    }

    public void setCabinCode(String cabinCode) {
        this.cabinCode = cabinCode;
    }
}
