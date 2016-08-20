package com.aero.ic.batch.context;

/**
 * Created by nairr5 on 8/19/16.
 */
public class SegmentToValue {
    private Object node;
    private Object instance;

    public SegmentToValue(Object node, Object instance) {
        this.node = node;
        this.instance = instance;
    }

    public Object getNode() {
        return node;
    }

    public void setNode(Object node) {
        this.node = node;
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

}
