package test;

import java.awt.*;

/**
 * Created by ANTON on 06.07.2016.
 */
public class WinnerSelector {
    GameField gameField;
    WinCombinations winComb = new WinCombinations();
    int emptySquaresLeft = gameField.squares.length;

    String lookForWinner() {

        String theWinner = "";
        emptySquaresLeft--;
        if (emptySquaresLeft == 0) {
            return GameEngine.RESULT_OF_GAME_TIE;
        }

        for (int i = 0; i < winComb.listWinCombination.size(); i++) {
            int[] winCase = winComb.listWinCombination.get(i);

            if (!checkWinner(winCase).isEmpty()) {
                theWinner = checkWinner(winCase);
                highlightWinner(winCase);
            }
        }
        return theWinner;
    }

    String checkWinner(int[] winCombination) {

        String winner = "";
        String [] gameFieldWin = new String [winCombination.length];

        for (int i = 0; i < gameFieldWin.length; i++) {
            gameFieldWin[i] = gameField.squares[winCombination[i]].getText();
        }

        if (!gameFieldWin[0].isEmpty()) {
            if (gameFieldWin[0].equals(gameFieldWin[1]) &&
                    gameFieldWin[0].equals(gameFieldWin[2])) {
                winner = gameFieldWin[0];
                return winner;
            }
        }
        return winner;
    }

    void highlightWinner(int[] winCombination) {

        for (int i = 0; i < winCombination.length; i++) {
            gameField.squares[winCombination[i]].setBackground(Color.CYAN);
        }
    }

}
