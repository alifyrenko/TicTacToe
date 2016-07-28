package console.Tests;

import console.game.GameField;
import console.game.WinCombinations;
import console.game.WinnerSelector;
import org.junit.Test;
import static console.game.Constants.*;
import static org.junit.Assert.*;

/**
 * Created by ANTON on 28.07.2016.
 */
public class WinnerSelectorTest {

    private boolean tempValue;
    private WinnerSelector winnerSelector = new WinnerSelector();

    @Test
    public void testIsWinnerExist() throws Exception {

        for (int i = 0; i < WinCombinations.getListWinCombination().size(); i++) {
            for (int j = 0; j < WinCombinations.getListWinCombination().get(j).length; j++) {
                GameField.squares[j] = COMPUTER_SIGN_O;
            }
            tempValue = winnerSelector.isWinnerExist();
            assertEquals(true, tempValue);
        }
    }
}
