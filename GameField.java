package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ANTON on 07.07.2016.
 */
public class GameField {

    private static int sizeOfGameField = 9;
    static JButton[] squares = new JButton[sizeOfGameField];
    private JPanel panelGameField = new JPanel();

    private int sizeOfText = 50;
    private Font buttonFont = new Font("Monospased", Font.BOLD, sizeOfText);

    private int sizeBetweenButtonsHeight = 10;
    private int sizeBetweenButtonsWidth = 10;
    private GridLayout gridLayout = new GridLayout(3, 3, sizeBetweenButtonsHeight, sizeBetweenButtonsWidth);

    JPanel addGameField() {
        for (int i = 0; i < sizeOfGameField; i++) {
            squares[i] = new JButton();
            squares[i].setBackground(Color.ORANGE);
            squares[i].setFont(buttonFont);
            panelGameField.add(squares[i]);
        }
        panelGameField.setLayout(gridLayout);
        return panelGameField;
    }
}
