package com.aero.ic.fdr.message;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/17/16.
 */
public class LTS extends EdifactSegment {
    private String longTextString;

    public String getLongTextString() {
        return longTextString;
    }

    public void setLongTextString(String longTextString) {
        this.longTextString = longTextString;
    }
}
