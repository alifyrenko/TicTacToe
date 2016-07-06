import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ANTON on 05.07.2016.
 */

public class TicTacToe extends Applet implements ActionListener {

    Button[] squares;
    Button newGameButton;
    Label score;
    int emptySquaresLeft;

    //   * Метод init – это конструктор апплета

    public void init() {

        //Устанавливаем менеджер расположения апплета, шрифт и цвет
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLUE);

        // Изменяем шрифт апплета так, чтобы он был жирным
        // и имел размер 20

        Font appletFont = new Font("Monospased", Font.BOLD, 30);
        this.setFont(appletFont);

        // Создаем кнопку “New Game” и регистрируем в ней
        // слушатель действия

        newGameButton = new Button("New Game");
        newGameButton.addActionListener(this);

        Panel topPanel = new Panel();
        topPanel.add(newGameButton);
        this.add(topPanel, "North");
        Panel centerPanel = new Panel();
        centerPanel.setLayout(new GridLayout(9, 9));
        this.add(centerPanel, "Center");
        score = new Label("Your turn");
        this.add(score, "South");

        squares = new Button[81];

        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Button();
            squares[i].addActionListener(this);
            squares[i].setBackground(Color.ORANGE);
            centerPanel.add(squares[i]);
        }

    }

    public void actionPerformed(ActionEvent e) {}

    }