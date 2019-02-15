package com.lp.drawingide.model;

import lombok.Data;
import srl.core.sketch.Sketch;

import java.util.ArrayList;
import java.util.List;

@Data
public class Workbench {
    private List<AbstractShape> shapes;
    private AbstractShape lastShape;
    private AbstractShape selectedShape;
    private Sketch sketch;
    private UnknownGraph unknownGraph;
    private static Workbench instance;

    private Workbench() {
        shapes = new ArrayList<>();
        sketch = new Sketch();
        unknownGraph = new UnknownGraph();
    }

    public static Workbench getInstance() {
        if (instance == null) {
            instance = new Workbench();
        }
        return instance;
    }

    public void clear() {
        shapes.clear();
        lastShape = null;
        selectedShape = null;
        unknownGraph = null;
    }
}
