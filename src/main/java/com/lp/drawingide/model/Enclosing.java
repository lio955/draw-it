package com.lp.drawingide.model;

import lombok.Setter;

@Setter
public class Enclosing {
    private static final int EPSILON = 20;

    private int xMin;
    private int yMin;

    private int xMax;
    private int yMax;

    public int getXMin() {
        return xMin - EPSILON;
    }

    public int getYMin() {
        return yMin - EPSILON;
    }

    public int getXMax() {
        return xMax + EPSILON;
    }

    public int getYMax() {
        return yMax + EPSILON;
    }
}
