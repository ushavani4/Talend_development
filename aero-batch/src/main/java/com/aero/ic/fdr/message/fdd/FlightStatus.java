package com.aero.ic.fdr.message.fdd;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/18/16.
 */
public class FlightStatus extends EdiField {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
