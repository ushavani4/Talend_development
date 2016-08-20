package com.aero.ic.fdr.message.leg;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/20/16.
 */
public class LEG extends EdifactSegment {

    private CrossCabinConfigInfo crossCabinConfigInfo;

    private String crossCabinControls;

    public CrossCabinConfigInfo getCrossCabinConfigInfo() {
        return crossCabinConfigInfo;
    }

    public void setCrossCabinConfigInfo(CrossCabinConfigInfo crossCabinConfigInfo) {
        this.crossCabinConfigInfo = crossCabinConfigInfo;
    }

    public String getCrossCabinControls() {
        return crossCabinControls;
    }

    public void setCrossCabinControls(String crossCabinControls) {
        this.crossCabinControls = crossCabinControls;
    }
}
