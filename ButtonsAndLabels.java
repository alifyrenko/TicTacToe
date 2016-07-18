package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static test.Constants.*;

/**
 * Created by ANTON on 07.07.2016.
 */
class ButtonsAndLabels {

    static JButton newGameButton = new JButton();

    JButton addNewGameButton() {
        newGameButton = new JButton(START_NEW_MATCH);
        newGameButton.setForeground(Color.WHITE);
        newGameButton.setBackground(Color.BLUE);
        return newGameButton;
    }

    static JButton buttonFinishGame = new JButton(QUIT_GAME);
    static JLabel messageOnLabel = new JLabel(YOUR_TURN, SwingConstants.CENTER);

    JPanel addPanelGameFinishScore() {

        int sizeBetweenButtonsHeight = 10;
        int sizeBetweenButtonsWidth = 10;

        JPanel panelGameFinishScore = new JPanel();

        panelGameFinishScore.add("South", messageOnLabel);

        GridLayout gridLayoutFinishScore = new GridLayout(2, 1, sizeBetweenButtonsHeight, sizeBetweenButtonsWidth);
        panelGameFinishScore.setLayout(gridLayoutFinishScore);

        buttonFinishGame.setForeground(Color.WHITE);
        buttonFinishGame.setBackground(Color.BLUE);
        panelGameFinishScore.add("South", buttonFinishGame);


        return panelGameFinishScore;
    }
}
