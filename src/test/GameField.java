package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ANTON on 07.07.2016.
 */
public class GameField {

    Body body;

    static JButton [] squares = new JButton[9];
    JPanel panelGameField = new JPanel();

    int sizeOfText = 50;
     Font buttonFont = new Font("Monospased", Font.BOLD, sizeOfText);

    int sizeBetweenButtonsHeight = 10;
    int sizeBetweenButtonsWidth = 10;
    GridLayout gridLayout = new GridLayout(3, 3, sizeBetweenButtonsHeight, sizeBetweenButtonsWidth);

    JPanel addGameField (){
    for (int i = 0; i < 9; i++) {
        squares[i] = new JButton();
        squares[i].setBackground(Color.ORANGE);
        squares[i].setFont(buttonFont);
        panelGameField.add(squares[i]);
    }
        panelGameField.setLayout(gridLayout);
        return panelGameField;
    }

}
