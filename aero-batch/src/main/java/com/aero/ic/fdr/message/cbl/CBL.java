package com.aero.ic.fdr.message.cbl;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/20/16.
 */
public class CBL extends EdifactSegment {

    private String regradeAdjustment;

    private String maxiRegradeAdjustment;

    private String unbalancedAdjustment;

    private String groupsConstrainingYield;

    private String avsFlag;

    private String notificationLevel;

    private String avpoolOffset;

    private String avpool;

    private String maxiGroupProportion;

    private String regradeCounter;

    private Blockspace blockspace;

    public String getMaxiGroupProportion() {
        return maxiGroupProportion;
    }

    public void setMaxiGroupProportion(String maxiGroupProportion) {
        this.maxiGroupProportion = maxiGroupProportion;
    }

    public String getRegradeAdjustment() {
        return regradeAdjustment;
    }

    public void setRegradeAdjustment(String regradeAdjustment) {
        this.regradeAdjustment = regradeAdjustment;
    }

    public String getMaxiRegradeAdjustment() {
        return maxiRegradeAdjustment;
    }

    public void setMaxiRegradeAdjustment(String maxiRegradeAdjustment) {
        this.maxiRegradeAdjustment = maxiRegradeAdjustment;
    }

    public String getUnbalancedAdjustment() {
        return unbalancedAdjustment;
    }

    public void setUnbalancedAdjustment(String unbalancedAdjustment) {
        this.unbalancedAdjustment = unbalancedAdjustment;
    }

    public String getGroupsConstrainingYield() {
        return groupsConstrainingYield;
    }

    public void setGroupsConstrainingYield(String groupsConstrainingYield) {
        this.groupsConstrainingYield = groupsConstrainingYield;
    }

    public String getAvsFlag() {
        return avsFlag;
    }

    public void setAvsFlag(String avsFlag) {
        this.avsFlag = avsFlag;
    }

    public String getNotificationLevel() {
        return notificationLevel;
    }

    public void setNotificationLevel(String notificationLevel) {
        this.notificationLevel = notificationLevel;
    }

    public String getAvpoolOffset() {
        return avpoolOffset;
    }

    public void setAvpoolOffset(String avpoolOffset) {
        this.avpoolOffset = avpoolOffset;
    }

    public String getAvpool() {
        return avpool;
    }

    public void setAvpool(String avpool) {
        this.avpool = avpool;
    }

    public String getRegradeCounter() {
        return regradeCounter;
    }

    public void setRegradeCounter(String regradeCounter) {
        this.regradeCounter = regradeCounter;
    }

    public Blockspace getBlockspace() {
        return blockspace;
    }

    public void setBlockspace(Blockspace blockspace) {
        this.blockspace = blockspace;
    }
}
