package com.aero.ic.message.base.header;

/**
 * Created by nairr5 on 7/28/16.
 */
public class MessageIdentifier {

    private String name;

    /** 0065 (M) Code identifying a type of message and assigned by its controlling agency.  **/
    private String messageType;

    /** 0052 (M) Version number of a message type. **/
    private String version;

    /** 0054 (M) Release number within the current message version number. **/
     private String release;

    /** 0051 (M) Code identifying a controlling agency. **/
    private String controllingAgency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getControllingAgency() {
        return controllingAgency;
    }

    public void setControllingAgency(String controllingAgency) {
        this.controllingAgency = controllingAgency;
    }

}
