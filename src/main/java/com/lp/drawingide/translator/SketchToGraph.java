package com.lp.drawingide.translator;

import com.lp.drawingide.model.AbstractShape;
import com.lp.drawingide.model.UnknownNode;
import com.lp.drawingide.model.UnknownRelationship;
import com.lp.drawingide.util.Util;

import java.util.List;

public class SketchToGraph {


    public static UnknownNode buildNode(final AbstractShape abstractShape) {
        UnknownNode unknownNode = null;

        if (!Util.LINE.equals(abstractShape.getShape().getInterpretation().label)
                && !Util.ARROW.equals(abstractShape.getShape().getInterpretation().label)) {
            unknownNode = new UnknownNode();
            unknownNode.setEnclosing(abstractShape.getEnclosing());
            unknownNode.setUnstructuredData(abstractShape.getText());

        }
        return unknownNode;
    }

    public static UnknownRelationship buildUnknownRelationship(final AbstractShape abstractShape, final List<UnknownNode> unknownNodes) {
        UnknownRelationship unknownRelationship = null;
        if (Util.LINE.equals(abstractShape.getShape().getInterpretation().label)
                || Util.ARROW.equals(abstractShape.getShape().getInterpretation().label)) {
            unknownRelationship = new UnknownRelationship();
            for (UnknownNode unknownNode : unknownNodes) {
                if (Util.isInsideEnclosing(unknownNode.getEnclosing(), abstractShape.getPointA().getX(), abstractShape.getPointA().getY())) {
                    unknownRelationship.setNodeA(unknownNode);
                }
                if (Util.isInsideEnclosing(unknownNode.getEnclosing(), abstractShape.getPointB().getX(), abstractShape.getPointB().getY())) {
                    unknownRelationship.setNodeB(unknownNode);
                }
            }

        }
        return unknownRelationship;
    }
}
