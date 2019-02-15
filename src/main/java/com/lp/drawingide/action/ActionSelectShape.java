package com.lp.drawingide.action;

import com.lp.drawingide.application.Application;
import com.lp.drawingide.model.AbstractShape;
import com.lp.drawingide.model.Workbench;
import com.lp.drawingide.util.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class ActionSelectShape extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MouseEvent mouseEvent = (MouseEvent) actionEvent.getSource();
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        AbstractShape selectedShape = null;
        int i = 0;
        while (selectedShape == null && i < Workbench.getInstance().getShapes().size()) {
            if (Util.isInsideEnclosing(Workbench.getInstance().getShapes().get(i).getEnclosing(), x, y)) {
                selectedShape = Workbench.getInstance().getShapes().get(i);
            }
            i++;
        }
        Workbench.getInstance().setSelectedShape(selectedShape);
        if (selectedShape!= null) {
            Application.getInstance().getMainPanel().getConsoleOutput().addText("Select "+ selectedShape.getShape().getInterpretation().label);
        }

    }


}
