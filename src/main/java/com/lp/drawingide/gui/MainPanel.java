package com.lp.drawingide.gui;

import com.lp.drawingide.action.ActionClear;
import com.lp.drawingide.action.ActionExit;
import com.lp.drawingide.action.ActionTypeText;
import lombok.Data;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Data
public class MainPanel extends JXFrame {


    private static final String TITLE = "Draw it !";

    private com.lp.drawingide.gui.Canvas canvas;
    private ConsoleOutput consoleOutput;

    private ActionTypeText actionTypeText;
    private ActionClear actionClear;

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
        actionTypeText = new ActionTypeText();
        setFocusable(true);
        actionClear = new ActionClear();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

                actionTypeText.actionPerformed(new ActionEvent(keyEvent, 1, null));
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == keyEvent.VK_Q
                        && keyEvent.isControlDown()) {
                    (new ActionExit()).actionPerformed(null);

                }
                if (keyEvent.getKeyCode() == keyEvent.VK_N
                        && keyEvent.isControlDown()) {
                     actionClear.actionPerformed(null);

                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

    }
}
