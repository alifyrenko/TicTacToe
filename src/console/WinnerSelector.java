package console;

import java.util.Arrays;

/**
 * Created by ANTON on 06.07.2016.
 */
public class WinnerSelector {

    public WinnerSelector() {
        new WinCombinations();
    }

    boolean isWinnerExist() {

        for (int i = 0; i < WinCombinations.listWinCombination.size(); i++) {
            int[] winCase = WinCombinations.listWinCombination.get(i);

            String[] gameFieldsWin = new String[winCase.length];

            for (int j = 0; j < gameFieldsWin.length; j++) {
                gameFieldsWin[j] = GameField.squares[winCase[j]];
            }

            Arrays.sort(gameFieldsWin);
            if (!gameFieldsWin[0].isEmpty() && gameFieldsWin[0].equals(gameFieldsWin[gameFieldsWin.length - 1])) {
                return true;
            }
        }
        return false;
    }
}