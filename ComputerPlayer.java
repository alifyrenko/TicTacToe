
package test;

import java.util.ArrayList;
import java.util.List;

import static test.Constants.*;

/**
 * Class ComputerPlayer represents AI_player to play with.
 * @author Tramon on 08.07.2016.
 * @version 2016.07.15.
 *
 *  Additional info: Buttons in the game field and int field represent indexes in such way:
 *  0 1 2
 *  3 4 5
 *  6 7 8
 */
class ComputerPlayer {
    GameField gameField;
    private int[] intField = new int[sizeOfGameField];
    private WinCombinations winCombinations = new WinCombinations();
    private List<Integer> availableIndexList;
    private List<WeightList> weightList;


    /**
     * Method takes gameField of Strings of X, O, or empty strings parses and creates an Array of ints named intField.
     * Where: Empty cell = 0; O = 1; X = 2;
     */
    private void parseGameFieldToIntField() {
        for ( int i = 0; i < sizeOfGameField; i++ ) {
            if ( gameField.squares[ i ].getText().equals( EMPTY_STRING ) ) {
                intField[ i ] = EMPTY_CELL;
            }
            if ( gameField.squares[ i ].getText().equals( COMPUTER_SIGN_O ) ) {
                intField[ i ] = AI_PLAYER;
            }
            if ( gameField.squares[ i ].getText().equals( HUMAN_SIGN_X ) ) {
                intField[ i ] = HUMAN_PLAYER;
            }
        }
    }

    /**
     * Method loops through intField to find empty cells.
     * @return List of empty int indexes for possible move
     */
    private List<Integer> getAvailableIndexList() {
        availableIndexList = new ArrayList<>();
        for ( int i = 0; i < sizeOfGameField; i++ ) {
            if ( intField[ i ] == 0 ) {
                availableIndexList.add( i );
            }
        }
        return availableIndexList;
    }

    /**
     * Method checks if there is a winner in the game in intField Array
     * @param playerSide Takes input of AI_PLAYER = 1; or HUMAN_PLAYER = 2;
     * @return boolean: true - if there is a winner with such param. False if there is no winner.
     */
    boolean isWinner ( int playerSide ) {
        boolean result = false;
        List winingIndexCombinationList = winCombinations.listWinCombination;
        for ( int i = 0; i < winingIndexCombinationList.size(); i++ ) {
            int[] someWinCombination = (int[]) winingIndexCombinationList.get( i );

            if ( intField[ someWinCombination[0] ] == playerSide &&
                    intField[ someWinCombination[1] ] == playerSide &&
                    intField[ someWinCombination[2] ] == playerSide) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Method returns the best index for making a move taking into consideration the weight.
     * @return int Index to make best move.
     */
    int getBestIndexToMove() {
        int max = Integer.MIN_VALUE;
        int best = INITIAL_INDEX;

        for ( int i = 0; i < weightList.size(); i++ ) {
            if ( max < weightList.get(i).weight ) {
                max = weightList.get(i).weight;
                best = i;
            }
        }
        return weightList.get( best ).index;
    }

    /**
     * Method makes a move only in int field
     * @param index takes an index to make a move.
     * @param playerSide takes an int to set an "O" for AI_PLAYER - 1; or HUMAN_PLAYER = 2 to set a "X";
     */
    void makeMove( int index, int playerSide ) {
        intField[ index ] = playerSide;
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
        invokeMinimaxAlgorithm( INITIAL_DEPTH, AI_PLAYER );

        makeMove( getBestIndexToMove(), AI_PLAYER );

        gameField.squares[ getBestIndexToMove() ].setText( COMPUTER_SIGN_O );
        gameField.squares[ getBestIndexToMove() ].setEnabled( false );
    }

    /**
     * Gets the minimum index from the List.
     * @param list of integer weights that are calculated for each move.
     * @return index with the minimum value.
     */
    private int getMinIndex( List<Integer> list ) {
        int min = Integer.MAX_VALUE;
        int index = INITIAL_INDEX;
        for ( int i = 0; i < list.size(); i++ ) {
            if ( list.get(i) < min ) {
                min = list.get(i);
                index = i;
            }
        }
        return list.get( index );
    }

    /**
     * Gets the maximum index from the List.
     * @param list of integer weights that are calculated for each move.
     * @return index with the maximum value.
     */
    private int getMaxIndex( List<Integer> list ) {
        int max = Integer.MIN_VALUE;
        int index = INITIAL_INDEX;
        for ( int i = 0; i < list.size(); i++ ) {
            if ( list.get(i) > max ) {
                max = list.get(i);
                index = i;
            }
        }
        return list.get( index );
    }

    /**
     * The minimax algorithm method calculates all of the moves for each player; 
     * then sets for each index a value of the move -1 for loose variant, 0 for a draw and 1 for a possible win variant
     * @param depth of a move that is calculated forward. Initial depth is 0. and with each step forward it increases.
     * @param player side. 1 for the AI player and 2 for a human player.
     * @return index with the maximum value.
     */

    private int minimaxAlgorithm( int depth, int playerSide ) {
        List<Integer> indexesAvailable = getAvailableIndexList();
        List<Integer> weight = new ArrayList<>();
        final int INCREMENT_WEIGHT = +1;
        final int DECREMENT_WEIGHT = -1;
        final int TIE = 0;

        if ( isWinner( AI_PLAYER ) ) {
            return INCREMENT_WEIGHT;
        }
        if ( isWinner( HUMAN_PLAYER ) ) {
            return DECREMENT_WEIGHT;
        }
        if ( indexesAvailable.isEmpty() ) {
            return TIE;
        }

        for ( int i = 0; i < indexesAvailable.size(); i++ ) {
            int index = indexesAvailable.get(i);

            if ( playerSide == AI_PLAYER ) {
                makeMove( index, AI_PLAYER );
                int tempWeight = minimaxAlgorithm( depth + 1, HUMAN_PLAYER );
                weight.add( tempWeight );

                if ( depth == INITIAL_DEPTH ) {
                    weightList.add( new WeightList( index, tempWeight) );
                }

            } else if ( playerSide == HUMAN_PLAYER ) {
                makeMove( index, HUMAN_PLAYER );
                weight.add( minimaxAlgorithm( depth + 1, AI_PLAYER ) );
            }
            intField[ index ] = EMPTY_CELL;
        }

        int minimaxAlgorithmResult;
        if ( playerSide == AI_PLAYER ) {
            minimaxAlgorithmResult = getMaxIndex( weight );
        } else {
            minimaxAlgorithmResult = getMinIndex( weight );
        }
        return minimaxAlgorithmResult;
    }

    /**
     * Invokes the first ocurance of minimax algorithm with initial depth of zero and player side.
     * @param depth amount of moves that AI player calculates forward for chosen side.
     * @param playerSide The side (AI or Human player). AI_PLAYER - 1; HUMAN_PLAYER = 2;
     */
    void invokeMinimaxAlgorithm( int depth, int playerSide ){
        weightList = new ArrayList<>();
        minimaxAlgorithm( depth, playerSide );
    }

    /**
     * Nested class represents a list of indexes of intField and weights for each index.
     * @param index of a cell to write a weight
     * @param weight for the index that was given in a first param
     */
    private class WeightList {
        int index;
        int weight;

        WeightList( int index, int weight ) {
            this.index = index;
            this.weight = weight;
        }
    }
}
