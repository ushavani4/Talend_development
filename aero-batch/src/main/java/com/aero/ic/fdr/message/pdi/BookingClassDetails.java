package com.aero.ic.fdr.message.pdi;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/22/16.
 */
public class BookingClassDetails extends EdiField {

    private String bookingClassDesignator;

    private String availabilityStatus;

    public String getBookingClassDesignator() {
        return bookingClassDesignator;
    }

    public void setBookingClassDesignator(String bookingClassDesignator) {
        this.bookingClassDesignator = bookingClassDesignator;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
