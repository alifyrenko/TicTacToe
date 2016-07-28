package console.Tests;

import console.game.ComputerPlayer;
import console.game.GameField;
import console.game.WinCombinations;
import static console.game.Constants.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ANTON on 28.07.2016.
 */
public class ComputerPlayerTest {
    private ComputerPlayer computerPlayer = new ComputerPlayer();
    private boolean tempValue;

    @Test
    public void testIsWinner() throws Exception {

        for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {
            GameField.squares[i] = String.valueOf(i);
        }
        tempValue = computerPlayer.isWinner(EMPTY_CELL);
        assertEquals(true, tempValue);

        for (int i = 0; i < WinCombinations.getListWinCombination().size(); i++) {
            for (int j = 0; j < WinCombinations.getListWinCombination().get(j).length; j++) {
                GameField.squares[j] = HUMAN_SIGN_X;
            }
            computerPlayer.parseGameFieldToIntField();
            tempValue = computerPlayer.isWinner(HUMAN_PLAYER);
            assertEquals(true, tempValue);
        }

        for (int i = 0; i < WinCombinations.getListWinCombination().size(); i++) {
            for (int j = 0; j < WinCombinations.getListWinCombination().get(j).length; j++) {
                GameField.squares[j] = COMPUTER_SIGN_O;
            }
            computerPlayer.parseGameFieldToIntField();
            tempValue = computerPlayer.isWinner(AI_PLAYER);
            assertEquals(true, tempValue);
        }
    }
}
