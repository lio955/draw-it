package com.lp.drawingide.model;

import lombok.Data;
import srl.core.sketch.Sketch;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Workbench {
    private List<AbstractShape> shapes;
    private AbstractShape lastShape;
    private Sketch sketch;
    private static Workbench instance;

    private Workbench() {
        shapes = new ArrayList<>();
        sketch = new Sketch();
    }

    public static Workbench getInstance() {
        if (instance == null) {
            instance = new Workbench();
        }
        return instance;
    }
}
