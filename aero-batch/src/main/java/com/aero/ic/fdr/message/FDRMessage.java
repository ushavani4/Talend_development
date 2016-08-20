package com.aero.ic.fdr.message;

import com.aero.ic.fdr.message.fdd.FDD;
import com.aero.ic.fdr.message.stx.STX;
import com.aero.ic.message.base.EdifactSegment;
import com.aero.ic.message.base.EdifactSegmentGroup;

/**
 * Created by nairr5 on 7/30/16.
 */
public class FDRMessage extends EdifactSegment {

    private OutBoundCarrier outBoundCarrier = new OutBoundCarrier();;

    private OutBoundFlight outBoundFlight = new OutBoundFlight();

    private DepartureDate departureDate = new DepartureDate();

    private FDD fdd;

    private REF ref;

    private STX stx;

    private LTS longTextString1;

    private IFD ifd;

    private LTS longTextString2;

    private EdifactSegmentGroup apdGroup;

    public EdifactSegmentGroup getApdGroup() {
        return apdGroup;
    }

    public void setApdGroup(EdifactSegmentGroup apdGroup) {
        this.apdGroup = apdGroup;
    }

    public LTS getLongTextString1() {
        return longTextString1;
    }

    public void setLongTextString1(LTS longTextString1) {
        this.longTextString1 = longTextString1;
    }

    public IFD getIfd() {
        return ifd;
    }

    public void setIfd(IFD ifd) {
        this.ifd = ifd;
    }

    public LTS getLongTextString2() {
        return longTextString2;
    }

    public void setLongTextString2(LTS longTextString2) {
        this.longTextString2 = longTextString2;
    }

    public STX getStx() {
        return stx;
    }

    public void setStx(STX stx) {
        this.stx = stx;
    }

    public REF getRef() {
        return ref;
    }

    public void setRef(REF ref) {
        this.ref = ref;
    }

    public FDD getFdd() {
        return fdd;
    }

    public void setFdd(FDD fdd) {
        this.fdd = fdd;
    }

    public OutBoundCarrier getOutBoundCarrier() {
        return outBoundCarrier;
    }

    public void setOutBoundCarrier(OutBoundCarrier outBoundCarrier) {
        this.outBoundCarrier = outBoundCarrier;
    }

    public OutBoundFlight getOutBoundFlight() {
        return outBoundFlight;
    }

    public void setOutBoundFlight(OutBoundFlight outBoundFlight) {
        this.outBoundFlight = outBoundFlight;
    }

    public DepartureDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(DepartureDate departureDate) {
        this.departureDate = departureDate;
    }

}
