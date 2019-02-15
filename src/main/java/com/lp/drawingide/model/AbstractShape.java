package com.lp.drawingide.model;

import lombok.Data;
import srl.core.sketch.Point;
import srl.core.sketch.Shape;

@Data
public class AbstractShape {
    protected Enclosing enclosing;
    protected Shape shape;

    public AbstractShape(final Shape shape) throws InvalidShapeException {
        this.shape = shape;
        enclosing = new Enclosing();
        if (shape.getPoints().size() > 0) {
            enclosing.setXMin(shape.getPoints().get(0).getX());
            enclosing.setYMin(shape.getPoints().get(0).getY());
            enclosing.setXMax(shape.getPoints().get(0).getX());
            enclosing.setYMax(shape.getPoints().get(0).getY());
            for (Point point : shape.getPoints()) {
                if (point.getX() > enclosing.getXMax()) {
                    enclosing.setXMax(point.getX());
                }
                if (point.getY() > enclosing.getYMax()) {
                    enclosing.setYMax(point.getY());
                }
                if (point.getX() < enclosing.getXMin()) {
                    enclosing.setXMin(point.getX());
                }
                if (point.getY() < enclosing.getYMin()) {
                    enclosing.setYMin(point.getY());
                }
            }
        } else {
            throw new InvalidShapeException();
        }
    }
}
