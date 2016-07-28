package console.Tests;

import org.junit.Test;

/**
 * Created by ANTON on 28.07.2016.
 */
public class RunAllTests {

    private AvailableMovesTest availableMovesTest = new AvailableMovesTest();
    private ComputerPlayerTest computerPlayerTest = new ComputerPlayerTest();
    private WinnerSelectorTest winnerSelectorTest = new WinnerSelectorTest();

    @Test(timeout = 100)
    public void RunAllTests() throws Exception {
        availableMovesTest.test1IsAvailableMove();
        availableMovesTest.test2IsAvailableMove();
        availableMovesTest.test3IsAvailableMove();
        availableMovesTest.test4IsAvailableMove();
        availableMovesTest.test5IsAvailableMove();
        computerPlayerTest.testIsWinner();
        winnerSelectorTest.testIsWinnerExist();
    }
}
