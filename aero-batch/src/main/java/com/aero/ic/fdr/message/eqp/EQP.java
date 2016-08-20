package com.aero.ic.fdr.message.eqp;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/19/16.
 */
public class EQP extends EdifactSegment {

    private ModeOfTransport modeOfTransport;

    private EquipmentIdentification equipmentIdentification;

    private CompanyDetails companyDetails;

    public ModeOfTransport getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(ModeOfTransport modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public EquipmentIdentification getEquipmentIdentification() {
        return equipmentIdentification;
    }

    public void setEquipmentIdentification(EquipmentIdentification equipmentIdentification) {
        this.equipmentIdentification = equipmentIdentification;
    }

    public CompanyDetails getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(CompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
    }
}
