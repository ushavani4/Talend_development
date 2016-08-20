package com.aero.ic.message.base.trailer;

import com.aero.ic.message.base.EdifactSegment;
import com.aero.ic.message.base.header.MessageReference;

/**
 * Created by nairr5 on 7/30/16.
 */
public class MessageTrailer extends EdifactSegment {

    /** 0074 Number of segments in a message **/
    private int totalSegments = 0;

    /** 0062 Unique message reference no **/
    private MessageReference messageReference;

    private EdiChecksum checksum;

    public int getTotalSegments() {
        return totalSegments;
    }

    public void setTotalSegments(int totalSegments) {
        this.totalSegments = totalSegments;
    }

    public MessageReference getMessageReference() {
        return messageReference;
    }

    public void setMessageReference(MessageReference messageReference) {
        this.messageReference = messageReference;
    }

    public EdiChecksum getChecksum() {
        return checksum;
    }

    public void setChecksum(EdiChecksum checksum) {
        this.checksum = checksum;
    }
}
