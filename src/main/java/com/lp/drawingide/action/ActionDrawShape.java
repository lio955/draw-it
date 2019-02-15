package com.lp.drawingide.action;

import com.lp.drawingide.application.Application;
import com.lp.drawingide.model.AbstractShape;
import com.lp.drawingide.model.Workbench;
import srl.recognition.IRecognitionResult;
import srl.recognition.paleo.PaleoConfig;
import srl.recognition.paleo.PaleoSketchRecognizer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionDrawShape extends AbstractAction {
    private static PaleoSketchRecognizer recognizer = new PaleoSketchRecognizer(PaleoConfig.allOn());


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (Workbench.getInstance().getSketch().getStrokes().size() > 0) {
            try {
                IRecognitionResult result = recognizer.recognize(Workbench.getInstance().getSketch().getFirstStroke());
                Application.getInstance().getMainPanel().getConsoleOutput().addText("paleo says: " + result.getBestShape().getInterpretation().label);
                AbstractShape abstractShape = new AbstractShape(result.getBestShape());
                Workbench.getInstance().getShapes().add(abstractShape);
                Workbench.getInstance().setLastShape(abstractShape);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
