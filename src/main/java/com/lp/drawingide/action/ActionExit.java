package com.lp.drawingide.action;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionExit extends AbstractAction {

    public ActionExit() {
        super("Quit");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }
}
