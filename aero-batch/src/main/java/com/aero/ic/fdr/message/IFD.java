package com.aero.ic.fdr.message;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/17/16.
 */
public class IFD extends EdifactSegment {

    private String reviewDate;

    private String reviewTime;

    private String controlType;

    private String currencyCode;

    private String isRevControlSetComplete;

    private String isUnderActiveRevControl;

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getIsRevControlSetComplete() {
        return isRevControlSetComplete;
    }

    public void setIsRevControlSetComplete(String isRevControlSetComplete) {
        this.isRevControlSetComplete = isRevControlSetComplete;
    }

    public String getIsUnderActiveRevControl() {
        return isUnderActiveRevControl;
    }

    public void setIsUnderActiveRevControl(String isUnderActiveRevControl) {
        this.isUnderActiveRevControl = isUnderActiveRevControl;
    }
}
