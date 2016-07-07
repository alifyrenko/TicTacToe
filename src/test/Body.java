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
    FrameTuner frameTuner = new FrameTuner();
    final int gameFieldSize = 9;

    {
        JPanel windowContent = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        windowContent.setLayout(borderLayout);

        windowContent.add("North", serviceButtonsAndLabels.addNewGameButton());
        windowContent.add("Center", gameField.addGameField());
        windowContent.add("South", serviceButtonsAndLabels.addPanelGameFinishScore());

        frameTuner.tuneFrame(windowContent);

        GameEngine gameEngine = new GameEngine(this);

        serviceButtonsAndLabels.newGameButton.addActionListener(gameEngine);
        serviceButtonsAndLabels.finish.addActionListener(gameEngine);

        for (int i = 0; i < gameFieldSize; i++) {
            gameField.squares[i].addActionListener(gameEngine);
        }

    }
}

