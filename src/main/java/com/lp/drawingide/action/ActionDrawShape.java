package com.lp.drawingide.action;

import com.lp.drawingide.application.Application;
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


        IRecognitionResult result = recognizer.recognize(Workbench.getInstance().getSketch().getFirstStroke());

        if (result.getBestShape().getInterpretation().label.equalsIgnoreCase("circle"))
            Application.getInstance().getMainPanel().getConsoleOutput().addText("Correctly recognized as a circle");

    }
}
