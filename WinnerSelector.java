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
            return "Tie";
        }

        for (int i = 0; i < winComb.listWinCombination.size(); i++) {
            int[] winCase = winComb.listWinCombination.get(i);

            if (!checkWinner(winCase).equals("")) {
                theWinner = checkWinner(winCase);
                highlightWinner(winCase);
            }
        }
        return theWinner;
    }

    String checkWinner(int[] winCombination) {

        String winner = "";
        String gameFieldWin1 = gameField.squares[winCombination[0]].getText();
        String gameFieldWin2 = gameField.squares[winCombination[1]].getText();
        String gameFieldWin3 = gameField.squares[winCombination[2]].getText();

        if (!gameFieldWin1.equals("")) {
            if (gameFieldWin1.equals(gameFieldWin2) &&
                    gameFieldWin1.equals(gameFieldWin3)) {
                winner = gameFieldWin1;
                return winner;
            }
        }
        return winner;
    }

    void highlightWinner(int[] winCombination) {

        gameField.squares[winCombination[0]].setBackground(Color.CYAN);
        gameField.squares[winCombination[1]].setBackground(Color.CYAN);
        gameField.squares[winCombination[2]].setBackground(Color.CYAN);
    }

}
