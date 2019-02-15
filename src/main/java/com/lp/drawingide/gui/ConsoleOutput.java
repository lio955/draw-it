package com.lp.drawingide.gui;

import lombok.Data;
import org.jdesktop.swingx.JXTextArea;

import javax.swing.*;

@Data
public class ConsoleOutput {
    private JScrollPane jScrollPane;
    private JXTextArea jxTextArea;

    public ConsoleOutput() {
        jxTextArea = new JXTextArea();
        jxTextArea.setEditable(false);

        jScrollPane = new JScrollPane(jxTextArea);

        jScrollPane.setVisible(true);
        jScrollPane.setAutoscrolls(true);
    }

    public void addText (final String text) {
        jxTextArea.setText(jxTextArea.getText()+"\n"+text);
    }
}
