package com.aero.ic.message.base;

import com.aero.ic.mapping.SegmentType;

/**
 * Created by nairr5 on 8/21/16.
 */
public class EdifactSegmentFactory {

    public static EdifactSegmentFactory newInstance() {
        return new EdifactSegmentFactory();
    }

    public EdifactSegment createSegment(SegmentType type, String segCode, String line) throws Exception {
        EdifactSegment edifactSegment = (EdifactSegment) Class.forName(type.getType()).newInstance();
        edifactSegment.parse(type, segCode, line);
        edifactSegment.setFields(type);
        return edifactSegment;
    }
}
