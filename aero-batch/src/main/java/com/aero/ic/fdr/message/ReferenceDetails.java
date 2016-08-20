package com.aero.ic.fdr.message;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/17/16.
 */
public class ReferenceDetails extends EdiField {

    private String qualifier;

    private String refNo;

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }
}
