package com.aero.ic.fdr.message.fdd;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/18/16.
 */
public class FlightCharacteristic extends EdiField {

    private String characteristic;

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
}
