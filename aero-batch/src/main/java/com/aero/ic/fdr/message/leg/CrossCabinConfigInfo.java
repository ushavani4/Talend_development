package com.aero.ic.fdr.message.leg;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/20/16.
 */
public class CrossCabinConfigInfo extends EdiField {

    private String crossCabinConfiguration;

    private String crossCabinConfigList;

    public String getCrossCabinConfiguration() {
        return crossCabinConfiguration;
    }

    public void setCrossCabinConfiguration(String crossCabinConfiguration) {
        this.crossCabinConfiguration = crossCabinConfiguration;
    }

    public String getCrossCabinConfigList() {
        return crossCabinConfigList;
    }

    public void setCrossCabinConfigList(String crossCabinConfigList) {
        this.crossCabinConfigList = crossCabinConfigList;
    }
}
