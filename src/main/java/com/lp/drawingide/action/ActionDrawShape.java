package com.lp.drawingide.action;

import com.lp.drawingide.application.Application;
import com.lp.drawingide.model.AbstractShape;
import com.lp.drawingide.model.UnknownNode;
import com.lp.drawingide.model.UnknownRelationship;
import com.lp.drawingide.model.Workbench;
import com.lp.drawingide.translator.SketchToGraph;
import srl.recognition.IRecognitionResult;
import srl.recognition.paleo.PaleoConfig;
import srl.recognition.paleo.PaleoSketchRecognizer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionDrawShape extends AbstractAction {

    private static PaleoSketchRecognizer recognizer;
    private static PaleoConfig paleoConfig;

    public ActionDrawShape() {
        paleoConfig = new PaleoConfig(PaleoConfig.Option.Line, PaleoConfig.Option.Circle, PaleoConfig.Option.Arrow
                , PaleoConfig.Option.Ellipse, PaleoConfig.Option.Square, PaleoConfig.Option.Rectangle);
        recognizer = new PaleoSketchRecognizer(paleoConfig);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Workbench.getInstance().setLastShape(null);
        if (Workbench.getInstance().getSketch().getStrokes().size() > 0
                && Workbench.getInstance().getSketch().getFirstStroke().getPoints().size() > 0) {
            try {
                IRecognitionResult result = recognizer.recognize(Workbench.getInstance().getSketch().getFirstStroke());
                if (result.getBestShape()!=null) {
                    //Application.getInstance().getMainPanel().getConsoleOutput().addText("paleo says: " + result.getBestShape().getInterpretation().label);
                    AbstractShape abstractShape = new AbstractShape(result.getBestShape());
                    Workbench.getInstance().getShapes().add(abstractShape);
                    Workbench.getInstance().setLastShape(abstractShape);
                    Workbench.getInstance().setSelectedShape(abstractShape);
                    UnknownNode unknownNode = SketchToGraph.buildNode(abstractShape);
                    if (unknownNode != null) {
                        Workbench.getInstance().getUnknownGraph().getNodes().add(unknownNode);
                    }
                    UnknownRelationship unknownRelationship = SketchToGraph.buildUnknownRelationship(abstractShape, Workbench.getInstance().getUnknownGraph().getNodes());
                    if (unknownRelationship != null) {
                        Workbench.getInstance().getUnknownGraph().getRelationships().add(unknownRelationship);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
