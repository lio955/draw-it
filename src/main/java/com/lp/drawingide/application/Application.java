package com.lp.drawingide.application;

import com.lp.drawingide.gui.MainPanel;
import lombok.Data;

import javax.swing.*;

@Data
public class Application {


    private MainPanel mainPanel;

    private static final Application instance= new Application();

    private Application() {
        mainPanel= new MainPanel();
    }

    public static Application getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Application.getInstance().getMainPanel().setVisible(true);
                Application.getInstance().getMainPanel().setExtendedState(JFrame.MAXIMIZED_BOTH);

            }
        });
    }
}
