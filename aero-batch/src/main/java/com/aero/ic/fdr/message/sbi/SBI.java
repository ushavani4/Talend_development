package com.aero.ic.fdr.message.sbi;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/22/16.
 */
public class SBI extends EdifactSegment {

    private String subclassId;

    public String getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(String subclassId) {
        this.subclassId = subclassId;
    }
}
