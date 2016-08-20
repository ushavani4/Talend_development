package com.aero.ic.message.base;

/**
 * Created by nairr5 on 7/30/16.
 */

import com.google.common.collect.Lists;

import java.util.List;

public class EdifactSegmentGroup {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private List<EdifactSegment> segments = Lists.newArrayList();

    public List<EdifactSegment> getSegments() {
        return segments;
    }

    public void addSegment(EdifactSegment segment) {
        this.segments.add(segment);
    }
}
