package com.aero.ic.fdr.message.cbl;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/20/16.
 */
public class Blockspace extends EdiField {

    private String blockSpaceType;

    private String marketingFlightDesignator;

    private String numberSeatsBlocked;

    public String getBlockSpaceType() {
        return blockSpaceType;
    }

    public void setBlockSpaceType(String blockSpaceType) {
        this.blockSpaceType = blockSpaceType;
    }

    public String getMarketingFlightDesignator() {
        return marketingFlightDesignator;
    }

    public void setMarketingFlightDesignator(String marketingFlightDesignator) {
        this.marketingFlightDesignator = marketingFlightDesignator;
    }

    public String getNumberSeatsBlocked() {
        return numberSeatsBlocked;
    }

    public void setNumberSeatsBlocked(String numberSeatsBlocked) {
        this.numberSeatsBlocked = numberSeatsBlocked;
    }
}
