package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ANTON on 06.07.2016.
 */
public class GameEngine implements ActionListener {

    GameField gameField;
    ServiceButtonsAndLabels serviceButtonsAndLabels;

    WinnerSelector winnerSelector = new WinnerSelector();
    ComputerPlayer computer = new ComputerPlayer();

    public void actionPerformed(ActionEvent e) {
        JButton theButton = (JButton) e.getSource();

        if (theButton == serviceButtonsAndLabels.newGameButton) {
            for (int i = 0; i < gameField.squares.length; i++) {
                gameField.squares[i].setEnabled(true);
                gameField.squares[i].setText("");
                gameField.squares[i].setBackground(Color.ORANGE);
            }
            winnerSelector.emptySquaresLeft = gameField.squares.length;
            serviceButtonsAndLabels.score.setText("Your turn!");
            return;
        }

        if (theButton == serviceButtonsAndLabels.finish) {
            System.exit(0);
        }

        String winner = "";
        for (int i = 0; i < gameField.squares.length; i++) {

            if (theButton == gameField.squares[i]) {
                gameField.squares[i].setText("X");
                gameField.squares[i].setEnabled(false);
                winner = winnerSelector.lookForWinner();
                if (!"".equals(winner)) {
                    endTheGame();

                } else {
                    computer.computerMove();
                    winner = winnerSelector.lookForWinner();
                    if (!"".equals(winner)) {
                        endTheGame();
                    }
                }
                break;
            }
        }

        if (winner.equals("X")) {
            serviceButtonsAndLabels.score.setText("You won!");
        } else if (winner.equals("O")) {
            serviceButtonsAndLabels.score.setText("You lost!");
        } else if (winner.equals("Tie")) {
            serviceButtonsAndLabels.score.setText("It's a tie!");
        }
    }

    void endTheGame() {
        for (int i = 0; i < gameField.squares.length; i++) {
            gameField.squares[i].setEnabled(false);
        }
    }
}


