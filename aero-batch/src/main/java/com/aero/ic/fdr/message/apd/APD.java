package com.aero.ic.fdr.message.apd;

import com.aero.ic.fdr.message.dat.DAT;
import com.aero.ic.fdr.message.eqd.EQD;
import com.aero.ic.fdr.message.eqi.EQI;
import com.aero.ic.fdr.message.eqp.EQP;
import com.aero.ic.fdr.message.imd.IMD;
import com.aero.ic.fdr.message.leg.LEG;
import com.aero.ic.fdr.message.stx.STX;
import com.aero.ic.message.base.EdifactSegment;
import com.aero.ic.message.base.EdifactSegmentGroup;

/**
 * Created by nairr5 on 8/18/16.
 */
public class APD extends EdifactSegment {

    private LegDetails legDetails;

    private DepartureStationInfo departureStationInfo;

    private ArrivalStationInfo arrivalStationInfo;

    private DAT scheduledTiming;

    private STX dcsInformation;

    private EQP eqp;

    private EQI eqi;

    private EQD eqd;

    private IMD flixType;

    private DAT flixTiming;

    private EdifactSegmentGroup ssrGroup;

    private LEG legData;

    private EdifactSegmentGroup eqiGroup;



    public LEG getLegData() {
        return legData;
    }

    public void setLegData(LEG legData) {
        this.legData = legData;
    }

    public EdifactSegmentGroup getSsrGroup() {
        return ssrGroup;
    }

    public void setSsrGroup(EdifactSegmentGroup ssrGroup) {
        this.ssrGroup = ssrGroup;
    }

    public DAT getFlixTiming() {
        return flixTiming;
    }

    public void setFlixTiming(DAT flixTiming) {
        this.flixTiming = flixTiming;
    }

    public EQD getEqd() {
        return eqd;
    }

    public void setEqd(EQD eqd) {
        this.eqd = eqd;
    }

    public IMD getFlixType() {
        return flixType;
    }

    public void setFlixType(IMD flixType) {
        this.flixType = flixType;
    }

    public EQI getEqi() {
        return eqi;
    }

    public void setEqi(EQI eqi) {
        this.eqi = eqi;
    }

    public EQP getEqp() {
        return eqp;
    }

    public void setEqp(EQP eqp) {
        this.eqp = eqp;
    }

    public STX getDcsInformation() {
        return dcsInformation;
    }

    public void setDcsInformation(STX dcsInformation) {
        this.dcsInformation = dcsInformation;
    }

    public EdifactSegmentGroup getEqiGroup() {
        return eqiGroup;
    }

    public void setEqiGroup(EdifactSegmentGroup eqiGroup) {
        this.eqiGroup = eqiGroup;
    }

    public DAT getScheduledTiming() {
        return scheduledTiming;
    }

    public void setScheduledTiming(DAT scheduledTiming) {
        this.scheduledTiming = scheduledTiming;
    }

    public LegDetails getLegDetails() {
        return legDetails;
    }

    public void setLegDetails(LegDetails legDetails) {
        this.legDetails = legDetails;
    }

    public DepartureStationInfo getDepartureStationInfo() {
        return departureStationInfo;
    }

    public void setDepartureStationInfo(DepartureStationInfo departureStationInfo) {
        this.departureStationInfo = departureStationInfo;
    }

    public ArrivalStationInfo getArrivalStationInfo() {
        return arrivalStationInfo;
    }

    public void setArrivalStationInfo(ArrivalStationInfo arrivalStationInfo) {
        this.arrivalStationInfo = arrivalStationInfo;
    }
}
