package com.demo.guidepagedemo.custominflater;

import java.io.Serializable;

/**
 * Created by SuperD on 2017/9/6.
 */

public class AttrTagBean implements Serializable {

    public int index;
    public float xIn;
    public float xOut;
    public float yIn;
    public float yOut;
    protected float alphaIn;
    protected float alphaOut;

    @Override
    public String toString() {
        return "ParallaxViewTag{" +
                "index=" + index +
                ", xIn=" + xIn +
                ", xOut=" + xOut +
                ", yIn=" + yIn +
                ", yOut=" + yOut +
                '}';
    }
}
