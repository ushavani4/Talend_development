package com.aero.ic.fdr.message.eqp;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/19/16.
 */
public class ModeOfTransport extends EdiField {

    private String serviceType;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
