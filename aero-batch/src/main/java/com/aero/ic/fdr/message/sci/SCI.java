package com.aero.ic.fdr.message.sci;

import com.aero.ic.fdr.message.eqn.EQN98119;
import com.aero.ic.message.base.EdifactSegment;
import com.aero.ic.message.base.EdifactSegmentGroup;

/**
 * Created by nairr5 on 8/22/16.
 */
public class SCI extends EdifactSegment {

    private String cabinCode;

    private String waitListMax;

    private String upr;

    private String bookingsCounter;

    private String waitList;

    private String expectedToBoard;

    private String staffStandbyCounter;

    private String staffStandbyMax;

    private EQN98119 eqnSci;

    private EdifactSegmentGroup pdiGroup;

    public EdifactSegmentGroup getPdiGroup() {
        return pdiGroup;
    }

    public void setPdiGroup(EdifactSegmentGroup pdiGroup) {
        this.pdiGroup = pdiGroup;
    }

    public EQN98119 getEqnSci() {
        return eqnSci;
    }

    public void setEqnSci(EQN98119 eqnSci) {
        this.eqnSci = eqnSci;
    }

    public String getCabinCode() {
        return cabinCode;
    }

    public void setCabinCode(String cabinCode) {
        this.cabinCode = cabinCode;
    }

    public String getWaitListMax() {
        return waitListMax;
    }

    public void setWaitListMax(String waitListMax) {
        this.waitListMax = waitListMax;
    }

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

    public String getWaitList() {
        return waitList;
    }

    public void setWaitList(String waitList) {
        this.waitList = waitList;
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

    public String getStaffStandbyMax() {
        return staffStandbyMax;
    }

    public void setStaffStandbyMax(String staffStandbyMax) {
        this.staffStandbyMax = staffStandbyMax;
    }
}
