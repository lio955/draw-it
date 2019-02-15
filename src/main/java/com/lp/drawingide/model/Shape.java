package com.lp.drawingide.model;

import lombok.Data;
import org.openawt.Stroke;

@Data
public abstract class Shape {
    protected Enclosing enclosing;
    protected Stroke stroke;
}
