package com.aero.ic.fdr.message;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/17/16.
 */
public class StatusInformation extends EdiField {

    private String statusIndicator;

    private String actionRequest;

    private String type;

    private String freeText;

    public String getStatusIndicator() {
        return statusIndicator;
    }

    public void setStatusIndicator(String statusIndicator) {
        this.statusIndicator = statusIndicator;
    }

    public String getActionRequest() {
        return actionRequest;
    }

    public void setActionRequest(String actionRequest) {
        this.actionRequest = actionRequest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }
}
