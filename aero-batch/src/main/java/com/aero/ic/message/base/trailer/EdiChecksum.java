package com.aero.ic.message.base.trailer;

import com.aero.ic.message.base.EdiField;

/**
 * Created by nairr5 on 7/31/16.
 */
public class EdiChecksum extends EdiField {

    private String count;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
