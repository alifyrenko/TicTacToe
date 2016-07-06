package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ANTON on 06.07.2016.
 */
public class GameEngine implements ActionListener {
    
    TicTacToe game;
    WinnerSelection winnerSelection = new WinnerSelection();
    ComputerPlayer computer = new ComputerPlayer();

    int emptySquaresLeft = 9;

    public GameEngine(TicTacToe game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        JButton theButton = (JButton) e.getSource();

        if (theButton == game.newGameButton) {
            for (int i = 0; i < 9; i++) {
                game.squares[i].setEnabled(true);
                game.squares[i].setText("");
                game.squares[i].setBackground(Color.ORANGE);
            }
            emptySquaresLeft = 9;
            game.score.setText("Your turn!");
            return;
        }

        String winner = "";

        for (int i = 0; i < 9; i++) {
            if (theButton == game.squares[i]) {
                game.squares[i].setText("X");
                //game.squares[i].setBackground(Color.WHITE);
                winner = winnerSelection.lookForWinner();
                if (!"".equals(winner)) {
                    endTheGame();
                } else {
                    computer.computerMove();
                    winner = winnerSelection.lookForWinner();
                    if (!"".equals(winner)) {
                        endTheGame();
                    }
                }
                break;
            }
        }

        if (winner.equals("X")) {
            game.score.setText("You won!");
        } else if (winner.equals("O")) {
            game.score.setText("You lost!");
        } else if (winner.equals("T")) {
            game.score.setText("It's a tie!");
        }
    }

    // Делаем недоступными клетки и доступной кнопку ”New Game”
    void endTheGame() {
        game.newGameButton.setEnabled(true);
        for (int i = 0; i < 9; i++) {
            game.squares[i].setEnabled(false);
        }
    }
}


