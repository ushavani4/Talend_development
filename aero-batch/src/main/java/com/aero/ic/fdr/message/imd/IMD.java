package com.aero.ic.fdr.message.imd;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/20/16.
 */
public class IMD extends EdifactSegment {

    private String itemCharacteristic;

    public String getItemCharacteristic() {
        return itemCharacteristic;
    }

    public void setItemCharacteristic(String itemCharacteristic) {
        this.itemCharacteristic = itemCharacteristic;
    }
}
