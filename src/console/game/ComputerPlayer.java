package console.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
public class ComputerPlayer {
    private int[] intField = new int[Constants.SIZE_OF_GAME_FIELD];
    private List<Integer> availableIndexList;
    private List<WeightList> weightList;


    /**
     * Method takes gameField of Strings of X, O, or empty strings parses and creates an Array of ints named intField.
     * Where: Empty cell = 0; O = 1; X = 2;
     */

    public void parseGameFieldToIntField() {
        for (int i = 0; i < Constants.SIZE_OF_GAME_FIELD; i++) {
            if (GameField.squares[i].equals(Constants.EMPTY_STRING)) {
                intField[i] = Constants.EMPTY_CELL;
            } else if (GameField.squares[i].equals(Constants.COMPUTER_SIGN_O)) {
                intField[i] = Constants.AI_PLAYER;
            } else if (GameField.squares[i].equals(Constants.HUMAN_SIGN_X)) {
                intField[i] = Constants.HUMAN_PLAYER;
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
        for (int i = 0; i < Constants.SIZE_OF_GAME_FIELD; i++) {
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
   public boolean isWinner(int playerSide) {
        boolean result = false;

        for (int i = 0; i < WinCombinations.getListWinCombination().size(); i++) {
            int[] someWinCombination = WinCombinations.getListWinCombination().get(i);
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
        int best = Constants.INITIAL_INDEX;

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
        invokeMinimaxAlgorithm(Constants.INITIAL_DEPTH, Constants.AI_PLAYER);

        makeMove(getBestIndexToMove(), Constants.AI_PLAYER);

        GameField.squares[getBestIndexToMove()] = (Constants.COMPUTER_SIGN_O);
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

        if (isWinner(Constants.AI_PLAYER)) {
            return INCREMENT_WEIGHT;
        } else if (isWinner(Constants.HUMAN_PLAYER)) {
            return DECREMENT_WEIGHT;
        } else if (indexesAvailable.isEmpty()) {
            return TIE;
        }

        for (int i = 0; i < indexesAvailable.size(); i++) {
            int index = indexesAvailable.get(i);

            if (playerSide == Constants.AI_PLAYER) {
                makeMove(index, Constants.AI_PLAYER);
                int tempWeight = minimaxAlgorithm(depth + 1, Constants.HUMAN_PLAYER);
                weight.add(tempWeight);

                if (depth == Constants.INITIAL_DEPTH) {
                    weightList.add(new WeightList(index, tempWeight));
                }

            } else if (playerSide == Constants.HUMAN_PLAYER) {
                makeMove(index, Constants.HUMAN_PLAYER);
                weight.add(minimaxAlgorithm(depth + 1, Constants.AI_PLAYER));
            }
            intField[index] = Constants.EMPTY_CELL;
        }

        int minimaxAlgorithmResult;
        if (playerSide == Constants.AI_PLAYER) {
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