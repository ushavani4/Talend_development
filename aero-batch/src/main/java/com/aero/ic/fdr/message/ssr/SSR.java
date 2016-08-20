package com.aero.ic.fdr.message.ssr;

import com.aero.ic.fdr.message.eqn.EQN;
import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/20/16.
 */
public class SSR extends EdifactSegment {

    private SSRDetails ssrDetails;

    private EQN ssrCounter;

    private SCI cabinCode;

    private SDT selectionDetails;

    public SDT getSelectionDetails() {
        return selectionDetails;
    }

    public void setSelectionDetails(SDT selectionDetails) {
        this.selectionDetails = selectionDetails;
    }

    public SCI getCabinCode() {
        return cabinCode;
    }

    public void setCabinCode(SCI cabinCode) {
        this.cabinCode = cabinCode;
    }

    public EQN getSsrCounter() {
        return ssrCounter;
    }

    public void setSsrCounter(EQN ssrCounter) {
        this.ssrCounter = ssrCounter;
    }

    public SSRDetails getSsrDetails() {
        return ssrDetails;
    }

    public void setSsrDetails(SSRDetails ssrDetails) {
        this.ssrDetails = ssrDetails;
    }
}
