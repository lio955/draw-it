package com.lp.drawingide.action;

import com.lp.drawingide.application.Application;
import com.lp.drawingide.model.Workbench;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionClear extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Workbench.getInstance().clear();
        Application.getInstance().getMainPanel().getCanvas().clear();
        Application.getInstance().getMainPanel().getConsoleOutput().getJxTextArea().setText("");
    }
}
