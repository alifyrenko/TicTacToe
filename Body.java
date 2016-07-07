package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ANTON on 06.07.2016.
 */
public class Body {

    GameField gameField = new GameField();
    ServiceButtonsAndLabels serviceButtonsAndLabels = new ServiceButtonsAndLabels();
    FrameTuner frameTuner = new FrameTuner();
    GameEngine gameEngine = new GameEngine();

    {
        JPanel windowContent = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        windowContent.setLayout(borderLayout);

        windowContent.add("North", serviceButtonsAndLabels.addNewGameButton());
        windowContent.add("Center", gameField.addGameField());
        windowContent.add("South", serviceButtonsAndLabels.addPanelGameFinishScore());

        frameTuner.tuneFrame(windowContent);

        serviceButtonsAndLabels.newGameButton.addActionListener(gameEngine);
        serviceButtonsAndLabels.finish.addActionListener(gameEngine);

        for (int i = 0; i < gameField.squares.length; i++) {
            gameField.squares[i].addActionListener(gameEngine);
        }
    }
}

