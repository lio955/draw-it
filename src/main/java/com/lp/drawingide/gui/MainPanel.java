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
    private ConsoleOutput consoleOutput;


    public MainPanel() {
        super();
        setTitle(TITLE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setContentPane(new JXPanel());
        getContentPane().setLayout(new MigLayout("wrap 1"));
        getContentPane().setSize(Toolkit.getDefaultToolkit().getScreenSize());

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screeHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        Dimension dimensionCanvas = new Dimension();
        dimensionCanvas.setSize(screenWidth, screeHeight * 0.8);
        canvas = new Canvas();
        canvas.setPreferredSize(dimensionCanvas);
        getContentPane().add(canvas);

        Dimension dimensionConsoleOutput = new Dimension();
        dimensionConsoleOutput.setSize(screenWidth, screeHeight * 0.2);
        consoleOutput = new ConsoleOutput();
        consoleOutput.getJScrollPane().setPreferredSize(dimensionConsoleOutput);
        getContentPane().add(consoleOutput.getJScrollPane());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
