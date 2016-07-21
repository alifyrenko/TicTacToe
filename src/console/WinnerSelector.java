package console;

import java.util.Arrays;

import static console.Constants.RESULT_OF_GAME_TIE;
import static console.Constants.SIZE_OF_GAME_FIELD;

/**
 * Created by ANTON on 06.07.2016.
 */
public class WinnerSelector {

    public WinnerSelector() {
        new WinCombinations();
    }

    int emptySquaresLeft = SIZE_OF_GAME_FIELD;

    String lookForWinner() {
        String winner = "";
        emptySquaresLeft--;
        if (emptySquaresLeft == 0) {
            return RESULT_OF_GAME_TIE;
        }

        for (int i = 0; i < WinCombinations.listWinCombination.size(); i++) {
            int[] winCase = WinCombinations.listWinCombination.get(i);

            if (!checkWinner(winCase).isEmpty()) {
                winner = checkWinner(winCase);
            }
        }
        return winner;
    }

    String checkWinner(int[] winCombination) {

        String winner = "";
        String[] gameFieldsWin = new String[winCombination.length];

        for (int i = 0; i < gameFieldsWin.length; i++) {
            gameFieldsWin[i] = GameField.squares[winCombination[i]];
        }

        Arrays.sort(gameFieldsWin);
        if (!gameFieldsWin[0].isEmpty() && gameFieldsWin[0].equals(gameFieldsWin[gameFieldsWin.length - 1])) {
            winner = gameFieldsWin[0];
            return winner;
        }
        return winner;
    }

}
