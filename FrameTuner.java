package test;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by ANTON on 07.07.2016.
 */
public class FrameTuner {

    static JFrame frame = new JFrame("Game Tic Tac Toe");

    {
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    void tuneFrame(JPanel windowContent) {
        frame.setContentPane(windowContent);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}