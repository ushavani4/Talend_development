package com.aero.ic.fdr.message.fdd;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/17/16.
 */
public class FDD extends EdifactSegment {

    private FlightStatus flightStatus;

    private String flightCharacteristics1;

    private String flightCharacteristics2;

    private String flightCharacteristics3;

    private String flightCharacteristics4;

    private String flightCharacteristics5;


    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getFlightCharacteristics1() {
        return flightCharacteristics1;
    }

    public void setFlightCharacteristics1(String flightCharacteristics1) {
        this.flightCharacteristics1 = flightCharacteristics1;
    }

    public String getFlightCharacteristics2() {
        return flightCharacteristics2;
    }

    public void setFlightCharacteristics2(String flightCharacteristics2) {
        this.flightCharacteristics2 = flightCharacteristics2;
    }

    public String getFlightCharacteristics3() {
        return flightCharacteristics3;
    }

    public void setFlightCharacteristics3(String flightCharacteristics3) {
        this.flightCharacteristics3 = flightCharacteristics3;
    }

    public String getFlightCharacteristics4() {
        return flightCharacteristics4;
    }

    public void setFlightCharacteristics4(String flightCharacteristics4) {
        this.flightCharacteristics4 = flightCharacteristics4;
    }

    public String getFlightCharacteristics5() {
        return flightCharacteristics5;
    }

    public void setFlightCharacteristics5(String flightCharacteristics5) {
        this.flightCharacteristics5 = flightCharacteristics5;
    }
}
