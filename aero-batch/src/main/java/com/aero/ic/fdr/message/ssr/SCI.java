package com.aero.ic.fdr.message.ssr;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/20/16.
 */
public class SCI extends EdifactSegment {

    private String cabinCode;

    public String getCabinCode() {
        return cabinCode;
    }

    public void setCabinCode(String cabinCode) {
        this.cabinCode = cabinCode;
    }
}
