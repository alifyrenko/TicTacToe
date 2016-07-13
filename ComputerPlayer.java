package test;

import java.util.List;

/**
 * Created by ANTON on 06.07.2016.
 */
public class ComputerPlayer {



    public static final int COMP_FIELD = -1;
    public static final int HUMAN_FIELD = 1;
    public static final int EMPTY_FIELD = 0;

    public static final int TWO_HUMAN_FIELDS_TOGETHER = 2;
    public static final int TWO_COMP_FIELDS_TOGETHER = -2;


    GameField gameField;
    WinCombinations winCombinations;

    List<int[]> winComb = winCombinations.listWinCombination;

    void computerMove() {


        int selectedSquare;

        selectedSquare = findEmptyNearTwoEqualSquares("O");

        if (selectedSquare == -1) {
            selectedSquare = findEmptyNearTwoEqualSquares("X");
        }

        // если selectedSquare все еще равен -1, то
        // попытается занять центральную клетку

        if ((selectedSquare == -1) && (gameField.squares[4].getText().equals(""))) {
            selectedSquare = 4;
        }

        // не повезло с центральной клеткой...
        // занимаем угловую

        /*if (selectedSquare == -1) {
            selectedSquare = getCornerSquare();
        }*/

        if (selectedSquare == -1) {
            selectedSquare = getRandomSquare();
        }
        gameField.squares[selectedSquare].setText("O");
        gameField.squares[selectedSquare].setEnabled(false);
    }

    int findEmptyNearTwoEqualSquares(String player) {

        int currentPlayField[] = new int[gameField.squares.length];

        for (int i = 0; i < gameField.squares.length; i++) {
            if (gameField.squares[i].getText().equals("O")) {
                currentPlayField[i] = COMP_FIELD;
            } else if (gameField.squares[i].getText().equals("X")) {
                currentPlayField[i] = HUMAN_FIELD;
            }
            else {
                currentPlayField[i] = EMPTY_FIELD;
            }
        }
        int twoWeights = player.equals("O") ? TWO_COMP_FIELDS_TOGETHER : TWO_HUMAN_FIELDS_TOGETHER;

        for (int i = 0; i < winComb.size(); i++) {

            int winCell1 = winComb.get(i)[0];
            int winCell2 = winComb.get(i)[1];
            int winCell3 = winComb.get(i)[2];

            if (twoWeights == currentPlayField[winCell1] + currentPlayField[winCell2] + currentPlayField[winCell3]) {
                for (int j = 0; j < winComb.get(i).length; j++) {
                    if (currentPlayField[winCell1] == EMPTY_FIELD) {
                        return winCell1;

                    } else if (currentPlayField[winCell2] == EMPTY_FIELD) {
                        return winCell2;

                    } else if (currentPlayField[winCell3] == EMPTY_FIELD) {
                        return winCell3;
                    }
                }
            }
        }
        return -1;
    }


 /*   int getCornerSquare() {
        int selectedSquare = -1;
        int [] corners = {0,2,6,8};

        for (int i = 0; i < corners.length; i++) {

            double check = Math.random()* corners.length;
            selectedSquare = corners[(int)Math.random()* corners.length];////////////////////////////////!!!!!!!!!!!!!!!!!!!!!!!
            if (gameField.squares[selectedSquare].getText().equals("")){
                return selectedSquare;
            }
        }
        return selectedSquare;
    }
*/

    int getRandomSquare() {
        boolean gotEmptySquare = false;
        int selectedSquare = -1;
        do {
            selectedSquare = (int) (Math.random() * gameField.squares.length);
            if (gameField.squares[selectedSquare].getText().equals("")) {
                gotEmptySquare = true; // чтобы закончить цикл
            }
        } while (!gotEmptySquare);
        return selectedSquare;
    }
}
