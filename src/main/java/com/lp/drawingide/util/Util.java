package com.lp.drawingide.util;

import com.lp.drawingide.model.Enclosing;

public class Util {


    //TODO use enum !!
    public static final String LINE = "Line";
    public static final String ARROW = "Arrow";
    public static final String ELLIPSE = "Ellipse";
    public static final String CIRCLE = "Circle";
    public static final String RECTANGLE = "Rectangle";
    public static final String SQUARE = "Square";


    public static boolean isInsideEnclosing(final Enclosing enclosing, int x, int y) {
        return enclosing.getXMin() < x && x < enclosing.getXMax() && enclosing.getYMin() < y && y < enclosing.getYMax();
    }
}
