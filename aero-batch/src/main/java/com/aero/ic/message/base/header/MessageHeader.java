package com.aero.ic.message.base.header;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 7/28/16.
 */
public class MessageHeader extends EdifactSegment {

    /** 0062 (M) Unique message reference assigned by the sender. **/
    private MessageReference messageReference;

    /** S009 (M) Identification of the type, version, etc. of the message being interchanged. **/
    private MessageIdentifier messageIdentifier;

    public MessageReference getMessageReference() {
        return messageReference;
    }

    public void setMessageReference(MessageReference messageReference) {
        this.messageReference = messageReference;
    }

    public MessageIdentifier getMessageIdentifier() {
        return messageIdentifier;
    }

    public void setMessageIdentifier(MessageIdentifier messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
    }

}
