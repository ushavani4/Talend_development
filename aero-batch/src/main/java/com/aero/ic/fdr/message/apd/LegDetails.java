package com.aero.ic.fdr.message.apd;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/18/16.
 */
public class LegDetails extends EdiField {

    private String transportId;

    private String noOfStops;

    private String legDuration;

    private String percentage;

    private String daysOfOperation;

    private String dateTimePeriod;

    private String complexingFlightIndicator;

    private String boardPoint;

    private String offPoint;

    private String locationIdentification;

    public String getLocationIdentification() {
        return locationIdentification;
    }

    public void setLocationIdentification(String locationIdentification) {
        this.locationIdentification = locationIdentification;
    }

    public String getBoardPoint() {
        return boardPoint;
    }

    public void setBoardPoint(String boardPoint) {
        this.boardPoint = boardPoint;
    }

    public String getOffPoint() {
        return offPoint;
    }

    public void setOffPoint(String offPoint) {
        this.offPoint = offPoint;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getNoOfStops() {
        return noOfStops;
    }

    public void setNoOfStops(String noOfStops) {
        this.noOfStops = noOfStops;
    }

    public String getLegDuration() {
        return legDuration;
    }

    public void setLegDuration(String legDuration) {
        this.legDuration = legDuration;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getDaysOfOperation() {
        return daysOfOperation;
    }

    public void setDaysOfOperation(String daysOfOperation) {
        this.daysOfOperation = daysOfOperation;
    }

    public String getDateTimePeriod() {
        return dateTimePeriod;
    }

    public void setDateTimePeriod(String dateTimePeriod) {
        this.dateTimePeriod = dateTimePeriod;
    }

    public String getComplexingFlightIndicator() {
        return complexingFlightIndicator;
    }

    public void setComplexingFlightIndicator(String complexingFlightIndicator) {
        this.complexingFlightIndicator = complexingFlightIndicator;
    }
}
