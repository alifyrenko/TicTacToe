package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by ANTON on 06.07.2016.
 */
public class Body {

    GameField gameField = new GameField();
    ServiceButtonsAndLabels serviceButtonsAndLabels = new ServiceButtonsAndLabels();

    final int gameFieldSize = 9;
    JButton finish;
    JLabel score;
    JFrame frame;

    {

        JPanel windowContent = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        windowContent.setLayout(borderLayout);

        windowContent.add("North", serviceButtonsAndLabels.addNewGameButton());

        windowContent.add("Center", gameField.addGameField());

        windowContent.add("South", serviceButtonsAndLabels.addPanelGameFinishScore());

        frame = new JFrame("Game Tic Tac Toe");
        frame.setContentPane(windowContent);

        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        GameEngine gameEngine = new GameEngine(this);

        serviceButtonsAndLabels.newGameButton.addActionListener(gameEngine);
        serviceButtonsAndLabels.finish.addActionListener(gameEngine);

        for (int i = 0; i < gameFieldSize; i++) {
            gameField.squares[i].addActionListener(gameEngine);
        }

    }
}

