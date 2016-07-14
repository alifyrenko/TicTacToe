package test;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by ANTON on 06.07.2016.
 */
public class WinnerSelector {
    GameField gameField;
    WinCombinations winComb = new WinCombinations();
    int emptySquaresLeft = gameField.squares.length;

    String lookForWinner() {
        String winner = "";
        emptySquaresLeft--;
        if (emptySquaresLeft == 0) {
            return Constants.RESULT_OF_GAME_TIE;
        }

        for (int i = 0; i < winComb.listWinCombination.size(); i++) {
            int[] winCase = winComb.listWinCombination.get(i);

            if (!checkWinner(winCase).isEmpty()) {
                winner = checkWinner(winCase);
                highlightWinnerFields(winCase);
            }
        }
        return winner;
    }

    String checkWinner(int[] winCombination) {

        String winner = "";
        String [] gameFieldWin = new String [winCombination.length];

        for (int i = 0; i < gameFieldWin.length; i++) {
            gameFieldWin[i] = gameField.squares[winCombination[i]].getText();
        }

        Arrays.sort(gameFieldWin);
        if(!gameFieldWin[0].isEmpty() && gameFieldWin[0] == gameFieldWin[gameFieldWin.length-1]){
            winner = gameFieldWin[0];
            return winner;
        }
        return winner;
    }

    void highlightWinnerFields(int[] winCombination) {

        for (int i = 0; i < winCombination.length; i++) {
            gameField.squares[winCombination[i]].setBackground(Color.CYAN);
        }
    }


}
