package com.aero.ic.fdr.message.pdi;

import com.aero.ic.fdr.message.cla.CLA;
import com.aero.ic.fdr.message.eqn.EqnPdi;
import com.aero.ic.message.base.EdifactSegment;
import com.aero.ic.message.base.EdifactSegmentGroup;

/**
 * Created by nairr5 on 8/22/16.
 */
public class PDI extends EdifactSegment {

    private String productDetails;

    private BookingClassDetails bookingClassDetails;

    private CLA bkgClassDetails;

    private EqnPdi boardingFiguresDcs;

    private EdifactSegmentGroup sbiGroup;

    public EdifactSegmentGroup getSbiGroup() {
        return sbiGroup;
    }

    public void setSbiGroup(EdifactSegmentGroup sbiGroup) {
        this.sbiGroup = sbiGroup;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public BookingClassDetails getBookingClassDetails() {
        return bookingClassDetails;
    }

    public void setBookingClassDetails(BookingClassDetails bookingClassDetails) {
        this.bookingClassDetails = bookingClassDetails;
    }

    public CLA getBkgClassDetails() {
        return bkgClassDetails;
    }

    public void setBkgClassDetails(CLA bkgClassDetails) {
        this.bkgClassDetails = bkgClassDetails;
    }

    public EqnPdi getBoardingFiguresDcs() {
        return boardingFiguresDcs;
    }

    public void setBoardingFiguresDcs(EqnPdi boardingFiguresDcs) {
        this.boardingFiguresDcs = boardingFiguresDcs;
    }
}
