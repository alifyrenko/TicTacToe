package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ANTON on 06.07.2016.
 */
public class WinnerSelector {

    int emptySquaresLeft = 9;
    Body body;

    String lookForWinner() {
        String theWinner = "";
        emptySquaresLeft--;
        if (emptySquaresLeft == 0) {
            return "T";  // это ничья. T от английского слова tie
        }

        // Проверяем ряд 1 – элементы массива 0,1,2
        if (!body.squares[0].getText().equals("") &&
                body.squares[0].getText().equals(body.squares[1].getText()) &&
                body.squares[0].getText().equals(body.squares[2].getText())) {
            theWinner = body.squares[0].getText();
            highlightWinner(0, 1, 2);

            // Проверяем ряд 2 – элементы массива 3,4,5
        } else if (!body.squares[3].getText().equals("") &&
                body.squares[3].getText().equals(body.squares[4].getText()) &&
                body.squares[3].getText().equals(body.squares[5].getText())) {
            theWinner = body.squares[3].getText();
            highlightWinner(3, 4, 5);

            // Проверяем ряд 3 – элементы массива 6,7,8
        } else if (!body.squares[6].getText().equals("") &&
                body.squares[6].getText().equals(body.squares[7].getText()) &&
                body.squares[6].getText().equals(body.squares[8].getText())) {
            theWinner = body.squares[6].getText();
            highlightWinner(6, 7, 8);

            // Проверяем колонку 1 – элементы массива 0,3,6
        } else if (!body.squares[0].getText().equals("") &&
                body.squares[0].getText().equals(body.squares[3].getText()) &&
                body.squares[0].getText().equals(body.squares[6].getText())) {
            theWinner = body.squares[0].getText();
            highlightWinner(0, 3, 6);

            // Проверяем колонку 2 – элементы массива 1,4,7
        } else if (!body.squares[1].getText().equals("") &&
                body.squares[1].getText().equals(body.squares[4].getText()) &&
                body.squares[1].getText().equals(body.squares[7].getText())) {
            theWinner = body.squares[1].getText();
            highlightWinner(1, 4, 7);

            // Проверяем колонку 3 – элементы массива 2,5,8
        } else if (!body.squares[2].getText().equals("") &&
                body.squares[2].getText().equals(body.squares[5].getText()) &&
                body.squares[2].getText().equals(body.squares[8].getText())) {
            theWinner = body.squares[2].getText();
            highlightWinner(2, 5, 8);

            // Проверяем первую диагональ – элементы массива 0,4,8
        } else if (!body.squares[0].getText().equals("") &&
                body.squares[0].getText().equals(body.squares[4].getText()) &&
                body.squares[0].getText().equals(body.squares[8].getText())) {
            theWinner = body.squares[0].getText();
            highlightWinner(0, 4, 8);

            // Проверяем вторую диагональ – элементы массива 2,4,6
        } else if (!body.squares[2].getText().equals("") &&
                body.squares[2].getText().equals(body.squares[4].getText()) &&
                body.squares[2].getText().equals(body.squares[6].getText())) {
            theWinner = body.squares[2].getText();
            highlightWinner(2, 4, 6);
        }

        return theWinner;
    }

    void highlightWinner(int win1, int win2, int win3) {
        body.squares[win1].setBackground(Color.CYAN);
        body.squares[win2].setBackground(Color.CYAN);
        body.squares[win3].setBackground(Color.CYAN);
    }

}
