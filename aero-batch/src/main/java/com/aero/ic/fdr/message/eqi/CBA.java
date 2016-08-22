package com.aero.ic.fdr.message.eqi;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/21/16.
 */
public class CBA extends EdifactSegment {

    private String upr;

    private String bookingsCounter;

    private String netAvailability;

    private String grossAvailability;

    private String acp;

    private String expectedToBoard;

    private String staffStandbyCounter;

    private String waitlistBookingsCounter;

    private String groupBookingsCounter;

    public String getUpr() {
        return upr;
    }

    public void setUpr(String upr) {
        this.upr = upr;
    }

    public String getBookingsCounter() {
        return bookingsCounter;
    }

    public void setBookingsCounter(String bookingsCounter) {
        this.bookingsCounter = bookingsCounter;
    }

    public String getNetAvailability() {
        return netAvailability;
    }

    public void setNetAvailability(String netAvailability) {
        this.netAvailability = netAvailability;
    }

    public String getGrossAvailability() {
        return grossAvailability;
    }

    public void setGrossAvailability(String grossAvailability) {
        this.grossAvailability = grossAvailability;
    }

    public String getAcp() {
        return acp;
    }

    public void setAcp(String acp) {
        this.acp = acp;
    }

    public String getExpectedToBoard() {
        return expectedToBoard;
    }

    public void setExpectedToBoard(String expectedToBoard) {
        this.expectedToBoard = expectedToBoard;
    }

    public String getStaffStandbyCounter() {
        return staffStandbyCounter;
    }

    public void setStaffStandbyCounter(String staffStandbyCounter) {
        this.staffStandbyCounter = staffStandbyCounter;
    }

    public String getWaitlistBookingsCounter() {
        return waitlistBookingsCounter;
    }

    public void setWaitlistBookingsCounter(String waitlistBookingsCounter) {
        this.waitlistBookingsCounter = waitlistBookingsCounter;
    }

    public String getGroupBookingsCounter() {
        return groupBookingsCounter;
    }

    public void setGroupBookingsCounter(String groupBookingsCounter) {
        this.groupBookingsCounter = groupBookingsCounter;
    }
}
