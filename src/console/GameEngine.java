package console;

import java.io.IOException;
import static console.Constants.*;


/**
 * Created by ANTON on 06.07.2016.
 */
public class GameEngine {

    GameField gameField = new GameField();
    WinnerSelector winnerSelector = new WinnerSelector();
    ComputerPlayer computer = new ComputerPlayer();
    HumanPlayer humanPlayer = new HumanPlayer();

    private String winner = "";

    public void startGame() throws IOException {
        System.out.println(TIC_TAC_TOE_GAME);

        for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {
            GameField.squares[i] = "" + i;
        }

        while (winner.isEmpty()) {

            gameField.showGameFieldMoves();
            System.out.println(LABEL_TEXT_MESSAGE_TURN);

            humanPlayer.makeHumanMove();

            for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {

                if (humanPlayer.humanMove.equals(GameField.squares[i])) {
                    GameField.squares[i] = HUMAN_SIGN_X;
                    winner = winnerSelector.lookForWinner();

                    if (!winner.isEmpty()) {
                        gameField.showGameFieldMoves();
                        showResultOnLabel(winner);
                        return;
                    } else {
                        computer.computerMove();
                        winner = winnerSelector.lookForWinner();
                        if (!winner.isEmpty()) {
                            gameField.showGameFieldMoves();
                            showResultOnLabel(winner);
                            return;
                        }
                    }
                }
            }
        }
    }

    void showResultOnLabel(String winner) {
        if (winner.equals(HUMAN_SIGN_X)) {
            System.out.println(LABEL_TEXT_MESSAGE_HUMAN_WON);
        } else {
            if (winner.equals(COMPUTER_SIGN_O)) {
                System.out.println(LABEL_TEXT_MESSAGE_COMPUTER_WON);
            } else if (winner.equals(RESULT_OF_GAME_TIE)) {
                System.out.println(LABEL_TEXT_MESSAGE_TIE);
            }
        }
    }
}


