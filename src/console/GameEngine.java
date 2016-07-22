package console;

import java.io.IOException;

import static console.Constants.*;


/**
 * Created by ANTON on 06.07.2016.
 */
public class GameEngine {

    private int emptySquaresLeft;
    private GameField gameField;
    private WinnerSelector winnerSelector;
    private ComputerPlayer computer;
    private HumanPlayer humanPlayer;

    public GameEngine() {
        gameField = new GameField();
        winnerSelector = new WinnerSelector();
        computer = new ComputerPlayer();
        humanPlayer = new HumanPlayer();
        emptySquaresLeft = SIZE_OF_GAME_FIELD;
    }

    public void startGame() throws IOException {
        System.out.println(TIC_TAC_TOE_GAME);

        for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {
            GameField.squares[i] = "" + i;
        }

        while (!winnerSelector.isWinnerExist()) {

            gameField.showGameFieldMoves();
            System.out.println(LABEL_TEXT_MESSAGE_TURN);

            humanPlayer.makeHumanMove();

            for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {

                if (humanPlayer.humanMove.equals(GameField.squares[i])) {
                    GameField.squares[i] = HUMAN_SIGN_X;
                    emptySquaresLeft--;

                    if (emptySquaresLeft == 0) {
                        gameField.showGameFieldMoves();
                        System.out.println(LABEL_TEXT_MESSAGE_TIE);
                        return;
                    }

                    if (winnerSelector.isWinnerExist()) {
                        gameField.showGameFieldMoves();
                        System.out.println(LABEL_TEXT_MESSAGE_HUMAN_WON);
                        return;

                    } else {
                        computer.computerMove();
                        emptySquaresLeft--;
                        if (winnerSelector.isWinnerExist()) {
                            gameField.showGameFieldMoves();
                            System.out.println(LABEL_TEXT_MESSAGE_COMPUTER_WON);
                            return;
                        }
                    }
                }
            }
        }
    }
}


