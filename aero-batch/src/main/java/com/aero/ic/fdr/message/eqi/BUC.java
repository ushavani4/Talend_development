package com.aero.ic.fdr.message.eqi;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/21/16.
 */
public class BUC extends EdifactSegment {

    private String yieldRangeUpperValue;

    private String availabilityConstraint;

    private String deltaSeatsEquivalent;

    private String  av1;

    private String av2;

    private String av3;

    private String yieldRangeLowerValue;

    private String subclassId;

    private String numberOfSeatsTaken;

    private String seatIndex;

    public String getYieldRangeUpperValue() {
        return yieldRangeUpperValue;
    }

    public void setYieldRangeUpperValue(String yieldRangeUpperValue) {
        this.yieldRangeUpperValue = yieldRangeUpperValue;
    }

    public String getAvailabilityConstraint() {
        return availabilityConstraint;
    }

    public void setAvailabilityConstraint(String availabilityConstraint) {
        this.availabilityConstraint = availabilityConstraint;
    }

    public String getDeltaSeatsEquivalent() {
        return deltaSeatsEquivalent;
    }

    public void setDeltaSeatsEquivalent(String deltaSeatsEquivalent) {
        this.deltaSeatsEquivalent = deltaSeatsEquivalent;
    }

    public String getAv1() {
        return av1;
    }

    public void setAv1(String av1) {
        this.av1 = av1;
    }

    public String getAv2() {
        return av2;
    }

    public void setAv2(String av2) {
        this.av2 = av2;
    }

    public String getAv3() {
        return av3;
    }

    public void setAv3(String av3) {
        this.av3 = av3;
    }

    public String getYieldRangeLowerValue() {
        return yieldRangeLowerValue;
    }

    public void setYieldRangeLowerValue(String yieldRangeLowerValue) {
        this.yieldRangeLowerValue = yieldRangeLowerValue;
    }

    public String getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(String subclassId) {
        this.subclassId = subclassId;
    }

    public String getNumberOfSeatsTaken() {
        return numberOfSeatsTaken;
    }

    public void setNumberOfSeatsTaken(String numberOfSeatsTaken) {
        this.numberOfSeatsTaken = numberOfSeatsTaken;
    }

    public String getSeatIndex() {
        return seatIndex;
    }

    public void setSeatIndex(String seatIndex) {
        this.seatIndex = seatIndex;
    }
}
