package com.aero.ic.fdr.message.eqi;

import com.aero.ic.fdr.message.cbl.CBL;
import com.aero.ic.fdr.message.eqn.DcsCounters;
import com.aero.ic.fdr.message.eqn.EqnEqi;

/**
 * Created by nairr5 on 8/19/16.
 */
public class EQI00116 extends EQI {

    private CBL legCabinDetails;

    private EqnEqi legCabinCounters;

    private CBA cabinAvailabilities;

    private BUC revenueBucket;

    private DcsCounters dcsCounters;

    public DcsCounters getDcsCounters() {
        return dcsCounters;
    }

    public void setDcsCounters(DcsCounters dcsCounters) {
        this.dcsCounters = dcsCounters;
    }

    public BUC getRevenueBucket() {
        return revenueBucket;
    }

    public void setRevenueBucket(BUC revenueBucket) {
        this.revenueBucket = revenueBucket;
    }

    public CBA getCabinAvailabilities() {
        return cabinAvailabilities;
    }

    public void setCabinAvailabilities(CBA cabinAvailabilities) {
        this.cabinAvailabilities = cabinAvailabilities;
    }

    public EqnEqi getLegCabinCounters() {
        return legCabinCounters;
    }

    public void setLegCabinCounters(EqnEqi legCabinCounters) {
        this.legCabinCounters = legCabinCounters;
    }

    public CBL getLegCabinDetails() {
        return legCabinDetails;
    }

    public void setLegCabinDetails(CBL legCabinDetails) {
        this.legCabinDetails = legCabinDetails;
    }
}
