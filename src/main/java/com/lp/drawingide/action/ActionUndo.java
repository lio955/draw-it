package com.lp.drawingide.action;

import com.lp.drawingide.model.Workbench;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionUndo extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (Workbench.getInstance().getLastShape() != null) {
            Workbench.getInstance().setLastShape(null);
            Workbench.getInstance().getShapes().remove((Workbench.getInstance().getShapes().size() - 1));
        }
    }
}
