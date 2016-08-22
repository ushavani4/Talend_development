package com.aero.ic.fdr.message.cla;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/22/16.
 */
public class CLA extends EdifactSegment {

    private String receivedAvsStatus;

    private String flags;

    public String getReceivedAvsStatus() {
        return receivedAvsStatus;
    }

    public void setReceivedAvsStatus(String receivedAvsStatus) {
        this.receivedAvsStatus = receivedAvsStatus;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }
}
