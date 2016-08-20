package com.aero.ic.message.base;

/**
 * Created by nairr5 on 7/31/16.
 */
public class EdiDateField {

    private String date;

    private String format = "ddmmyy";

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
