package com.lp.drawingide.action;

import com.lp.drawingide.application.Application;
import com.lp.drawingide.model.AbstractShape;
import com.lp.drawingide.model.Workbench;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionTypeText extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        KeyEvent keyEvent = (KeyEvent) actionEvent.getSource();
        AbstractShape abstractShape = Workbench.getInstance().getSelectedShape();
        if (abstractShape != null) {
            abstractShape.setText(abstractShape.getText() + keyEvent.getKeyChar());
            Application.getInstance().getMainPanel().getConsoleOutput().addText(renderText(abstractShape));
        }
    }

    private String renderText(final AbstractShape abstractShape) {
        return abstractShape.getShape().getInterpretation().label + " {" + abstractShape.getText() + "}";
    }
}
