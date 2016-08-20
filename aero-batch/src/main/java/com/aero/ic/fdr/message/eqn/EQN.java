package com.aero.ic.fdr.message.eqn;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/20/16.
 */
public class EQN extends EdifactSegment {

    private NumberOfUnitsDetails numberOfUnitsDetails;

    public NumberOfUnitsDetails getNumberOfUnitsDetails() {
        return numberOfUnitsDetails;
    }

    public void setNumberOfUnitsDetails(NumberOfUnitsDetails numberOfUnitsDetails) {
        this.numberOfUnitsDetails = numberOfUnitsDetails;
    }
}
