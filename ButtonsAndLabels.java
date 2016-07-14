package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ANTON on 07.07.2016.
 */
public class ButtonsAndLabels {

    static JButton newGameButton = new JButton();

    JButton addNewGameButton() {
        newGameButton = new JButton("New Game");
        newGameButton.setForeground(Color.WHITE);
        newGameButton.setBackground(Color.BLUE);
        return newGameButton;
    }

    static JButton buttonFinishGame = new JButton("Finish Game");
    static JLabel messageOnLabel = new JLabel("Your Turn!", SwingConstants.CENTER);

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
