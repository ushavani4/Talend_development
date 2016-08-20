package com.aero.ic.message.base;

/**
 * Created by nairr5 on 7/30/16.
 */
public abstract class EdifactSegment {

    private String id;

    private String segmentCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSegmentCode() {
        return this.segmentCode;
    }

    public void setSegmentCode(String code) {
        this.segmentCode = code;
    }

}
