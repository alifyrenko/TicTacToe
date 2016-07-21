package console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static console.Constants.SIZE_OF_GAME_FIELD;
import static console.Constants.EMPTY_STRING;
import static console.Constants.EMPTY_CELL;
import static console.Constants.COMPUTER_SIGN_O;
import static console.Constants.HUMAN_SIGN_X;
import static console.Constants.AI_PLAYER;
import static console.Constants.HUMAN_PLAYER;
import static console.Constants.INITIAL_INDEX;
import static console.Constants.INITIAL_DEPTH;


/**
 * Class ComputerPlayer represents AI_player to play with.
 *
 * @author Tramon on 08.07.2016.
 * @version 2016.07.15.
 *          <p/>
 *          Additional info: Buttons in the game field and int field represent indexes in such way:
 *          0 1 2
 *          3 4 5
 *          6 7 8
 */
class ComputerPlayer {
    //GameField gameField;
    private int[] intField = new int[SIZE_OF_GAME_FIELD];
    private List<Integer> availableIndexList;
    private List<WeightList> weightList;


    /**
     * Method takes gameField of Strings of X, O, or empty strings parses and creates an Array of ints named intField.
     * Where: Empty cell = 0; O = 1; X = 2;
     */

    private void parseGameFieldToIntField() {
        for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {
            if (GameField.squares[i].equals(EMPTY_STRING)) {
                intField[i] = EMPTY_CELL;
            } else if (GameField.squares[i].equals(COMPUTER_SIGN_O)) {
                intField[i] = AI_PLAYER;
            } else if (GameField.squares[i].equals(HUMAN_SIGN_X)) {
                intField[i] = HUMAN_PLAYER;
            }
        }
    }

    /**
     * Method loops through intField to find empty cells.
     *
     * @return List of empty int indexes for possible move
     */
    private List<Integer> getAvailableIndexList() {
        availableIndexList = new ArrayList<>();
        for (int i = 0; i < SIZE_OF_GAME_FIELD; i++) {
            if (intField[i] == 0) {
                availableIndexList.add(i);
            }
        }
        return availableIndexList;
    }

    /**
     * Method checks if there is a winner in the game in intField Array
     *
     * @param playerSide Takes input of AI_PLAYER = 1; or HUMAN_PLAYER = 2;
     * @return boolean: true - if there is a winner with such param. False if there is no winner.
     */
    boolean isWinner(int playerSide) {
        boolean result = false;

        for (int i = 0; i < WinCombinations.listWinCombination.size(); i++) {
            int[] someWinCombination = WinCombinations.listWinCombination.get(i);
            if (intField[someWinCombination[0]] == playerSide &&
                    intField[someWinCombination[1]] == playerSide &&
                    intField[someWinCombination[2]] == playerSide) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Method returns the best index for making a move taking into consideration the weight.
     *
     * @return int Index to make best move.
     */
    int getBestIndexToMove() {

        int max = Integer.MIN_VALUE;
        int best = INITIAL_INDEX;

        for (int i = 0; i < weightList.size(); i++) {
            if (max < weightList.get(i).weight) {
                max = weightList.get(i).weight;
                best = i;
            }
        }
        return weightList.get(best).index;
    }

    /**
     * Method makes a move only in int field
     *
     * @param index      takes an index to make a move.
     * @param playerSide takes an int to set an "O" for AI_PLAYER - 1; or HUMAN_PLAYER = 2 to set a "X";
     */
    void makeMove(int index, int playerSide) {
        intField[index] = playerSide;
    }

    /**
     * Method makes a move according to the following sequence:
     * 1. Parses the GameField to IntField
     * 2. Invokes a minimax algorithm with INITIAL_DEPTH=0 for the AI_PLAYER=1;
     * 3. Makes a move for the  AI_PLAYER taking the best index
     * 4. Sets the gameField with THE_O;
     * 5. Disables the button in gameField were THE_O was set.
     */
    void computerMove() {
        parseGameFieldToIntField();
        invokeMinimaxAlgorithm(INITIAL_DEPTH, AI_PLAYER);

        makeMove(getBestIndexToMove(), AI_PLAYER);

        GameField.squares[getBestIndexToMove()] = (COMPUTER_SIGN_O);
    }

    /**
     * Gets the minimum index from the List.
     *
     * @param list of integer weights that are calculated for each move.
     * @return index with the minimum value.
     */
    private int getMinIndex(List<Integer> list) {
        int min = Collections.min(list);
        int index = list.indexOf(min);
        return list.get(index);
    }

    private int getMaxIndex(List<Integer> list) {
        int max = Collections.max(list);
        int index = list.indexOf(max);
        return list.get(index);
    }

    private int minimaxAlgorithm(int depth, int playerSide) {
        List<Integer> indexesAvailable = getAvailableIndexList();
        List<Integer> weight = new ArrayList<>();
        final int INCREMENT_WEIGHT = +1;
        final int DECREMENT_WEIGHT = -1;
        final int TIE = 0;

        if (isWinner(AI_PLAYER)) {
            return INCREMENT_WEIGHT;
        } else if (isWinner(HUMAN_PLAYER)) {
            return DECREMENT_WEIGHT;
        } else if (indexesAvailable.isEmpty()) {
            return TIE;
        }

        for (int i = 0; i < indexesAvailable.size(); i++) {
            int index = indexesAvailable.get(i);

            if (playerSide == AI_PLAYER) {
                makeMove(index, AI_PLAYER);
                int tempWeight = minimaxAlgorithm(depth + 1, HUMAN_PLAYER);
                weight.add(tempWeight);

                if (depth == INITIAL_DEPTH) {
                    weightList.add(new WeightList(index, tempWeight));
                }

            } else if (playerSide == HUMAN_PLAYER) {
                makeMove(index, HUMAN_PLAYER);
                weight.add(minimaxAlgorithm(depth + 1, AI_PLAYER));
            }
            intField[index] = EMPTY_CELL;
        }

        int minimaxAlgorithmResult;
        if (playerSide == AI_PLAYER) {
            minimaxAlgorithmResult = getMaxIndex(weight);
        } else {
            minimaxAlgorithmResult = getMinIndex(weight);
        }
        return minimaxAlgorithmResult;
    }

    /**
     * Invokes the minimax algorithm with initial depth and player side.
     *
     * @param depth      amount of moves that AI player calculates forward for chosen side.
     * @param playerSide The side (AI or Human player). AI_PLAYER - 1; HUMAN_PLAYER = 2;
     */
    void invokeMinimaxAlgorithm(int depth, int playerSide) {
        weightList = new ArrayList<>();
        minimaxAlgorithm(depth, playerSide);
    }

    /**
     * Nested class represents a list of indexes of intField and weights for each index.
     *
     * @author Tramon on 08.07.2016.
     */
    private class WeightList {
        int index;
        int weight;

        WeightList(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}