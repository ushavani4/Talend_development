package com.aero.ic.fdr.message.ssr;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/20/16.
 */
public class SSRDetails extends EdiField {

    private String ssrType;

    private String ssrThreshold;

    public String getSsrType() {
        return ssrType;
    }

    public void setSsrType(String ssrType) {
        this.ssrType = ssrType;
    }

    public String getSsrThreshold() {
        return ssrThreshold;
    }

    public void setSsrThreshold(String ssrThreshold) {
        this.ssrThreshold = ssrThreshold;
    }
}
