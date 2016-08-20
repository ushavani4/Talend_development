package com.aero.ic.fdr.message.dat;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/19/16.
 */
public class DateAndTimeDetails extends EdiField {

    private String qualifier;

    private String date;

    private String time;

    private String delayInformation;

    private String timeOffset;

    private String delayReason;

    private String involvedLocation;

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDelayInformation() {
        return delayInformation;
    }

    public void setDelayInformation(String delayInformation) {
        this.delayInformation = delayInformation;
    }

    public String getTimeOffset() {
        return timeOffset;
    }

    public void setTimeOffset(String timeOffset) {
        this.timeOffset = timeOffset;
    }

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }

    public String getInvolvedLocation() {
        return involvedLocation;
    }

    public void setInvolvedLocation(String involvedLocation) {
        this.involvedLocation = involvedLocation;
    }
}
