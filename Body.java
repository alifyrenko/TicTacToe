package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ANTON on 06.07.2016.
 */
public class Body {

    int sizeWindow = 9;
    JButton newGameButton;
    static JButton[] squares;
    JLabel score;

        public void runGame () {

            JPanel windowContent = new JPanel();
            BorderLayout borderLayout = new BorderLayout();
            windowContent.setLayout(borderLayout);

            newGameButton = new JButton("New Game");
            newGameButton.setForeground(Color.WHITE);
            newGameButton.setBackground(Color.BLUE);
            windowContent.add("North", newGameButton);

            Font buttonFont = new Font("Monospased",Font.BOLD, 40);

            JPanel p1 = new JPanel();
            GridLayout gridLayout = new GridLayout(3, 3, 2, 2);
            p1.setLayout(gridLayout);

            squares = new JButton[sizeWindow];

            for (int i = 0; i < sizeWindow; i++) {
                squares[i] = new JButton();
                squares[i].setBackground(Color.ORANGE);
                squares[i].setFont(buttonFont);
                p1.add(squares[i]);
            }

            windowContent.add("Center", p1);

            score = new JLabel("Your Turn!", SwingConstants.CENTER);
            windowContent.add("South", score);

            JFrame frame = new JFrame("Game Tic Tac Toe");
            frame.setContentPane(windowContent);

            frame.setSize(500, 500);
            frame.setVisible(true);

            GameEngine gameEngine = new GameEngine(this);

            newGameButton.addActionListener(gameEngine);

            for (int i = 0; i < sizeWindow; i++) {
                squares[i].addActionListener(gameEngine);
            }
        }
}

