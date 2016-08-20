package com.aero.ic.fdr.message.apd;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/18/16.
 */
public class DepartureStationInfo extends EdiField {

    private String gateDescription;

    private String terminalDesignator1;

    private String terminalDesignator2;

    public String getGateDescription() {
        return gateDescription;
    }

    public void setGateDescription(String gateDescription) {
        this.gateDescription = gateDescription;
    }

    public String getTerminalDesignator1() {
        return terminalDesignator1;
    }

    public void setTerminalDesignator1(String terminalDesignator1) {
        this.terminalDesignator1 = terminalDesignator1;
    }

    public String getTerminalDesignator2() {
        return terminalDesignator2;
    }

    public void setTerminalDesignator2(String terminalDesignator2) {
        this.terminalDesignator2 = terminalDesignator2;
    }
}
