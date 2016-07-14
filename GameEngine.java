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
    ButtonsAndLabels buttonsAndLabels;

    private String winner = null;

    public static final String HUMAN_SIGN_X = "X";
    public static final String COMPUTER_SIGN_O = "O";
    public static final String LABEL_TEXT_MESSAGE_TURN = "Your turn!";
    public static final String LABEL_TEXT_MESSAGE_HUMAN_WON = "You won!";
    public static final String LABEL_TEXT_MESSAGE_COMPUTER_WON = "You lost!";
    public static final String LABEL_TEXT_MESSAGE_TIE = "It's a tie!";
    public static final String RESULT_OF_GAME_TIE = "Tie";

    WinnerSelector winnerSelector = new WinnerSelector();
    ComputerPlayer computer = new ComputerPlayer();

    public void actionPerformed(ActionEvent e) {
        JButton theButton = (JButton) e.getSource();

        if (theButton == buttonsAndLabels.newGameButton) {
            for (int i = 0; i < gameField.squares.length; i++) {
                gameField.squares[i].setEnabled(true);
                gameField.squares[i].setText("");
                gameField.squares[i].setBackground(Color.ORANGE);
            }
            winnerSelector.emptySquaresLeft = gameField.squares.length;
            buttonsAndLabels.messageOnLabel.setText(LABEL_TEXT_MESSAGE_TURN);
            return;
        }

        if (theButton == buttonsAndLabels.buttonFinishGame) {
            System.exit(0);
        }

        for (int i = 0; i < gameField.squares.length; i++) {

            if (theButton == gameField.squares[i]) {
                gameField.squares[i].setText(HUMAN_SIGN_X);
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
        if (winner.equals(HUMAN_SIGN_X)) {
            buttonsAndLabels.messageOnLabel.setText(LABEL_TEXT_MESSAGE_HUMAN_WON);
        } else if (winner.equals(COMPUTER_SIGN_O)) {
            buttonsAndLabels.messageOnLabel.setText(LABEL_TEXT_MESSAGE_COMPUTER_WON);
        } else if (winner.equals(RESULT_OF_GAME_TIE)) {
            buttonsAndLabels.messageOnLabel.setText(LABEL_TEXT_MESSAGE_TIE);
        }
    }

    void endTheGame() {
        for (int i = 0; i < gameField.squares.length; i++) {
            gameField.squares[i].setEnabled(false);
        }
    }
}


