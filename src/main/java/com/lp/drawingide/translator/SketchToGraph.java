package com.lp.drawingide.translator;

import com.lp.drawingide.model.AbstractShape;
import com.lp.drawingide.model.UnknownGraph;
import com.lp.drawingide.model.UnknownNode;
import com.lp.drawingide.model.UnknownRelationship;

public class SketchToGraph {

    private static final String LINE = "Line";
    private static final String ARROW = "Arrow";


    public static UnknownNode buildNode(final AbstractShape abstractShape) {
        UnknownNode unknownNode = null;

        if (!LINE.equals(abstractShape.getShape().getInterpretation().label)
                && ARROW.equals(abstractShape.getShape().getInterpretation().label)) {
            unknownNode = new UnknownNode();
            unknownNode.setUnstructuredData(abstractShape.getText());

        }
        return unknownNode;
    }

    private UnknownRelationship buildUnknownRelationship(final AbstractShape abstractShape, final UnknownGraph unknownGraph) {
        return null;
    }
}
