package console.Tests;

import console.game.AvailableMoves;
import console.game.GameField;
import org.junit.Test;

import static console.game.Constants.*;
import static org.junit.Assert.*;

/**
 * Created by ANTON on 28.07.2016.
 */
public class AvailableMovesTest {

    private AvailableMoves availableMoves = new AvailableMoves();

    @Test(timeout = 100)
    public void test1IsAvailableMove() throws Exception {

        boolean testValue;
        for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {
            GameField.squares[i] = COMPUTER_SIGN_O;
            testValue = availableMoves.isAvailableMove(String.valueOf(i));
            assertEquals(false, testValue);
        }
    }

    @Test(timeout = 100)
    public void test2IsAvailableMove() throws Exception {
        boolean testValue;
        for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {
            GameField.squares[i] = HUMAN_SIGN_X;
            testValue = availableMoves.isAvailableMove(String.valueOf(i));
            assertEquals(false, testValue);
        }
    }

    @Test(timeout = 100)
    public void test3IsAvailableMove() throws Exception {
        boolean testValue;
        for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {
            GameField.squares[i] = String.valueOf(i);
            testValue = availableMoves.isAvailableMove(String.valueOf(i));
            assertEquals(true, testValue);
        }
    }

    @Test(timeout = 100)
    public void test4IsAvailableMove() throws Exception {
        final int i = 9;
        boolean testValue = availableMoves.isAvailableMove(String.valueOf(i));
        assertEquals(false, testValue);
    }

    @Test(timeout = 100)
    public void test5IsAvailableMove() throws Exception {
        final String i = "O";
        boolean testValue = availableMoves.isAvailableMove(i);
        assertEquals(false, testValue);
    }
}
