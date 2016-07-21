package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ANTON on 06.07.2016.
 */
class Body {

    GameField gameField = new GameField();
    ButtonsAndLabels buttonsAndLabels = new ButtonsAndLabels();
    FrameTuner frameTuner = new FrameTuner();
    GameEngine gameEngine = new GameEngine();

    {
        JPanel windowContent = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        windowContent.setLayout(borderLayout);

        windowContent.add("North", buttonsAndLabels.addNewGameButton());
        windowContent.add("Center", gameField.addGameField());
        windowContent.add("South", buttonsAndLabels.addPanelGameFinishScore());

        frameTuner.tuneFrame(windowContent);

        buttonsAndLabels.newGameButton.addActionListener(gameEngine);
        buttonsAndLabels.buttonFinishGame.addActionListener(gameEngine);

        for (int i = 0; i < gameField.squares.length; i++) {
            gameField.squares[i].addActionListener(gameEngine);
        }
    }
}

