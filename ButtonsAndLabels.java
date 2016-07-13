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

    static JButton finish = new JButton("Finish Game");
    static JLabel score = new JLabel("Your Turn!", SwingConstants.CENTER);

    JPanel addPanelGameFinishScore() {

        int sizeBetweenButtonsHeight = 10;
        int sizeBetweenButtonsWidth = 10;

        JPanel panelGameFinishScore = new JPanel();

        panelGameFinishScore.add("South", score);

        GridLayout gridLayoutFinishScore = new GridLayout(2, 1, sizeBetweenButtonsHeight, sizeBetweenButtonsWidth);
        panelGameFinishScore.setLayout(gridLayoutFinishScore);

        finish.setForeground(Color.WHITE);
        finish.setBackground(Color.BLUE);
        panelGameFinishScore.add("South", finish);

        return panelGameFinishScore;
    }
}
