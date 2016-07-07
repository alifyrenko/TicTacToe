package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by ANTON on 06.07.2016.
 */
public class Body {

    int gameFieldSize = 9;
    static JButton[] squares;
    JButton newGameButton;
    JButton finish;
    JLabel score;
    JFrame frame;

    public void runGame() {

        JPanel windowContent = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        windowContent.setLayout(borderLayout);

        //JPanel panelNewGameButton = new JPanel();

        newGameButton = new JButton("New Game");
        newGameButton.setForeground(Color.WHITE);
        newGameButton.setBackground(Color.BLUE);
        windowContent.add("North", newGameButton);

        int sizeOfText = 50;
        Font buttonFont = new Font("Monospased", Font.BOLD, sizeOfText);

        int sizeBetweenButtonsHeight = 10;
        int sizeBetweenButtonsWidth = 10;
        JPanel panelGameField = new JPanel();
        GridLayout gridLayout = new GridLayout(3, 3, sizeBetweenButtonsHeight, sizeBetweenButtonsWidth);
        panelGameField.setLayout(gridLayout);

        squares = new JButton[gameFieldSize];

        for (int i = 0; i < gameFieldSize; i++) {
            squares[i] = new JButton();
            squares[i].setBackground(Color.ORANGE);
            squares[i].setFont(buttonFont);
            panelGameField.add(squares[i]);
        }

        windowContent.add("Center", panelGameField);

        JPanel panelGameFinishScore = new JPanel();
        GridLayout gridLayoutFinishScore = new GridLayout(2, 1, sizeBetweenButtonsHeight, sizeBetweenButtonsWidth);
        panelGameFinishScore.setLayout(gridLayoutFinishScore);

        score = new JLabel("Your Turn!", SwingConstants.CENTER);
        panelGameFinishScore.add("South", score);

        finish = new JButton("Finish Game");
        finish.setForeground(Color.WHITE);
        finish.setBackground(Color.BLUE);
        panelGameFinishScore.add("South", finish);


        windowContent.add("South", panelGameFinishScore);


        frame = new JFrame("Game Tic Tac Toe");
        frame.setContentPane(windowContent);

        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        GameEngine gameEngine = new GameEngine(this);

        newGameButton.addActionListener(gameEngine);
        finish.addActionListener(gameEngine);

        for (int i = 0; i < gameFieldSize; i++) {
            squares[i].addActionListener(gameEngine);
        }


    }
}

