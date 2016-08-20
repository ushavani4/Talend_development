package com.aero.ic.fdr.message.dat;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/19/16.
 */
public class DAT extends EdifactSegment {

    private DateAndTimeDetails dateAndTimeDetails;

    public DateAndTimeDetails getDateAndTimeDetails() {
        return dateAndTimeDetails;
    }

    public void setDateAndTimeDetails(DateAndTimeDetails dateAndTimeDetails) {
        this.dateAndTimeDetails = dateAndTimeDetails;
    }
}
