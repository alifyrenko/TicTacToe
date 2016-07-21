package console;

import static console.Constants.SIZE_OF_GAME_FIELD;

/**
 * Created by ANTON on 07.07.2016.
 */
public class GameField {

    static String [] squares = new String[SIZE_OF_GAME_FIELD];

    void showGameFieldMoves (){
        System.out.println(" ___ ___ ___");
        System.out.println("|_"+squares[0]+"_|_"+squares[1]+"_|_"+squares[2]+"_|");
        System.out.println("|_"+squares[3]+"_|_"+squares[4]+"_|_"+squares[5]+"_|");
        System.out.println("|_"+squares[6]+"_|_"+squares[7]+"_|_"+squares[8]+"_|");

    }

}
