package com.lp.drawingide.gui;

import lombok.Data;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

import java.awt.*;

@Data
public class MainPanel extends JXFrame {


    private static final String TITLE = "Draw it !";

    private com.lp.drawingide.gui.Canvas canvas;


    public MainPanel() {
        super();
        setTitle(TITLE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setContentPane(new JXPanel());
        getContentPane().setLayout(new MigLayout("wrap 1"));
        getContentPane().setSize(Toolkit.getDefaultToolkit().getScreenSize());
        canvas = new Canvas();
        canvas.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        getContentPane().add(canvas);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
