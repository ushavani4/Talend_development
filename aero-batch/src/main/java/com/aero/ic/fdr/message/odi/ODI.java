package com.aero.ic.fdr.message.odi;

import com.aero.ic.fdr.message.dat.DatOdi;
import com.aero.ic.fdr.message.stx.StxOdi;
import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/21/16.
 */
public class ODI extends EdifactSegment {

    private String departureCityCode;

    private String arrivalCityCode;

    private DatOdi segmentTiming;

    private StxOdi segmentFlags;

    public DatOdi getSegmentTiming() {
        return segmentTiming;
    }

    public void setSegmentTiming(DatOdi segmentTiming) {
        this.segmentTiming = segmentTiming;
    }

    public StxOdi getSegmentFlags() {
        return segmentFlags;
    }

    public void setSegmentFlags(StxOdi segmentFlags) {
        this.segmentFlags = segmentFlags;
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode;
    }

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode;
    }
}
