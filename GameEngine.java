package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static test.Constants.*;

/**
 * Created by ANTON on 06.07.2016.
 */
class GameEngine implements ActionListener {

    GameField gameField;
    ButtonsAndLabels buttonsAndLabels;
    WinnerSelector winnerSelector = new WinnerSelector();
    ComputerPlayer computer = new ComputerPlayer();

    private String winner = null;

    public void actionPerformed(ActionEvent e) {
        JButton theButton = (JButton) e.getSource();

        if (theButton == buttonsAndLabels.newGameButton) {
            for (int i = 0; i < gameField.squares.length; i++) {
                gameField.squares[i].setEnabled(true);
                gameField.squares[i].setText(EMPTY_STRING);
                gameField.squares[i].setBackground(Color.ORANGE);
            }
            winnerSelector.emptySquaresLeft = gameField.squares.length;
            buttonsAndLabels.messageOnLabel.setText(Constants.LABEL_TEXT_MESSAGE_TURN);
            return;
        }

        if (theButton == buttonsAndLabels.buttonFinishGame) {
            System.exit(0);
        }

        for (int i = 0; i < gameField.squares.length; i++) {

            if (theButton == gameField.squares[i]) {
                gameField.squares[i].setText(Constants.HUMAN_SIGN_X);
                gameField.squares[i].setEnabled(false);
                winner = winnerSelector.lookForWinner();
                if (!winner.isEmpty()) {
                    endTheGame();
                } else {
                    computer.computerMove();
                    winner = winnerSelector.lookForWinner();
                    if (!winner.isEmpty()) {
                        endTheGame();
                    }
                }
                break;
            }
        }
        showResultOnLabel(winner);
    }

    void showResultOnLabel (String winner) {
        if (winner.equals(Constants.HUMAN_SIGN_X)) {
            buttonsAndLabels.messageOnLabel.setText(Constants.LABEL_TEXT_MESSAGE_HUMAN_WON);
        } else if (winner.equals(Constants.COMPUTER_SIGN_O)) {
            buttonsAndLabels.messageOnLabel.setText(Constants.LABEL_TEXT_MESSAGE_COMPUTER_WON);
        } else if (winner.equals(Constants.RESULT_OF_GAME_TIE)) {
            buttonsAndLabels.messageOnLabel.setText(Constants.LABEL_TEXT_MESSAGE_TIE);
        }
    }

    void endTheGame() {
        for (int i = 0; i < gameField.squares.length; i++) {
            gameField.squares[i].setEnabled(false);
        }
    }
}