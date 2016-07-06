package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ANTON on 06.07.2016.
 */
public class GameEngine implements ActionListener{

    TicTacToe game;

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
            game.emptySquaresLeft = 9;
            game.score.setText("Your turn!");
            return;
        }

        String winner = "";

        for (int i = 0; i < 9; i++) {
            if (theButton == game.squares[i]) {
                game.squares[i].setText("X");
                game.squares[i].setBackground(Color.WHITE);
                // ЛОГИКА ИГРЫ
            }
        }
    }
}
