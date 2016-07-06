package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ANTON on 06.07.2016.
 */
public class GameEngine implements ActionListener {
    
    Body body;
    WinnerSelector winnerSelector = new WinnerSelector();
    ComputerPlayer computer = new ComputerPlayer();

    public GameEngine(Body body) {
        this.body = body;
    }

    public void actionPerformed(ActionEvent e) {
        JButton theButton = (JButton) e.getSource();

        if (theButton == body.newGameButton) {
            for (int i = 0; i < 9; i++) {
                body.squares[i].setEnabled(true);
                body.squares[i].setText("");
                body.squares[i].setBackground(Color.ORANGE);
            }
            winnerSelector.emptySquaresLeft = 9;
            body.score.setText("Your turn!");

            return;
        }

        String winner = "";

        for (int i = 0; i < 9; i++) {
            if (theButton == body.squares[i]) {
                body.squares[i].setText("X");
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
            body.score.setText("You won!");
        } else if (winner.equals("O")) {
            body.score.setText("You lost!");
        } else if (winner.equals("T")) {
            body.score.setText("It's a tie!");
        }
    }

    // Делаем недоступными клетки и доступной кнопку ”New Game”
    void endTheGame() {
        body.newGameButton.setEnabled(true);
        for (int i = 0; i < 9; i++) {
            body.squares[i].setEnabled(false);
        }
    }
}


