package com.aero.ic.fdr.message.eqi;

import com.aero.ic.fdr.message.cbl.CBL;

/**
 * Created by nairr5 on 8/19/16.
 */
public class EQI00116 extends EQI {

    private CBL legCabinDetails;

    public CBL getLegCabinDetails() {
        return legCabinDetails;
    }

    public void setLegCabinDetails(CBL legCabinDetails) {
        this.legCabinDetails = legCabinDetails;
    }
}
