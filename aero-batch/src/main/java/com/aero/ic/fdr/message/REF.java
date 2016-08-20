package com.aero.ic.fdr.message;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/17/16.
 */
public class REF extends EdifactSegment {

    private ReferenceDetails referenceDetails;

    public ReferenceDetails getReferenceDetails() {
        return referenceDetails;
    }

    public void setReferenceDetails(ReferenceDetails referenceDetails) {
        this.referenceDetails = referenceDetails;
    }
}
