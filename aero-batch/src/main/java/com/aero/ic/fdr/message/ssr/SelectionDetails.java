package com.aero.ic.fdr.message.ssr;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 8/20/16.
 */
public class SelectionDetails extends EdiField {

    private String optionCode;

    private String optionInformation;

    public String getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(String optionCode) {
        this.optionCode = optionCode;
    }

    public String getOptionInformation() {
        return optionInformation;
    }

    public void setOptionInformation(String optionInformation) {
        this.optionInformation = optionInformation;
    }
}
