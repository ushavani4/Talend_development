package com.aero.ic.fdr.message.stx;

import com.aero.ic.fdr.message.StatusInformation;
import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/17/16.
 */
public class STX extends EdifactSegment {

    private StatusInformation statusInformation;

    public StatusInformation getStatusInformation() {
        return statusInformation;
    }

    public void setStatusInformation(StatusInformation statusInformation) {
        this.statusInformation = statusInformation;
    }
}
