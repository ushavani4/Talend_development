package com.aero.ic.fdr.message.ssr;

import com.aero.ic.message.base.EdifactSegment;

/**
 * Created by nairr5 on 8/20/16.
 */
public class SDT extends EdifactSegment {

    private SelectionDetails selectionDetails;

    public SelectionDetails getSelectionDetails() {
        return selectionDetails;
    }

    public void setSelectionDetails(SelectionDetails selectionDetails) {
        this.selectionDetails = selectionDetails;
    }
}
