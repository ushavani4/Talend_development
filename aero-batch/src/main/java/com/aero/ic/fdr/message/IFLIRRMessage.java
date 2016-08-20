package com.aero.ic.fdr.message;

import com.aero.ic.message.base.EdifactMessage;
import com.aero.ic.message.base.EdifactSegmentGroup;
import com.aero.ic.message.base.header.MessageHeader;
import com.aero.ic.message.base.trailer.MessageTrailer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by nairr5 on 7/25/16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class IFLIRRMessage implements EdifactMessage {

    private MessageHeader messageHeader;

    private EdifactSegmentGroup segmentGroup;

    private MessageTrailer messageTrailer;

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public EdifactSegmentGroup getSegmentGroup() {
        return segmentGroup;
    }

    public void setSegmentGroup(EdifactSegmentGroup segmentGroup) {
        this.segmentGroup = segmentGroup;
    }

    public MessageTrailer getMessageTrailer() {
        return messageTrailer;
    }

    public void setMessageTrailer(MessageTrailer messageTrailer) {
        this.messageTrailer = messageTrailer;
    }
}
