package com.lp.drawingide.model;

import lombok.Data;
import srl.core.sketch.Point;
import srl.core.sketch.Shape;

@Data
public class AbstractShape {
    private Enclosing enclosing;
    private Shape shape;
    private String text;


    public AbstractShape(final Shape shape) throws InvalidShapeException {
        this.shape = shape;
        this.enclosing = new Enclosing();
        this.text = "";
        if (shape.getPoints().size() > 0) {
            enclosing.setXMin((int) shape.getPoints().get(0).getX());
            enclosing.setYMin((int) shape.getPoints().get(0).getY());
            enclosing.setXMax((int) shape.getPoints().get(0).getX());
            enclosing.setYMax((int) shape.getPoints().get(0).getY());
            for (Point point : shape.getPoints()) {
                if (point.getX() > enclosing.getXMax()) {
                    enclosing.setXMax((int) point.getX());
                }
                if (point.getY() > enclosing.getYMax()) {
                    enclosing.setYMax((int) point.getY());
                }
                if (point.getX() < enclosing.getXMin()) {
                    enclosing.setXMin((int) point.getX());
                }
                if (point.getY() < enclosing.getYMin()) {
                    enclosing.setYMin((int) point.getY());
                }
            }
        } else {
            throw new InvalidShapeException();
        }
    }
}
