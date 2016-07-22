package console;

import static console.Constants.SIZE_OF_GAME_FIELD;

/**
 * Created by ANTON on 07.07.2016.
 */
public class GameField {

    private StringBuilder builder ;

    public GameField() {
        builder = new StringBuilder();
    }

    static String [] squares = new String[SIZE_OF_GAME_FIELD];

    void showGameFieldMoves (){
        System.out.println(" ___ ___ ___");
        builder.append("|_").append(squares[0]).append("_|_").append(squares[1]).append("_|_").append(squares[2]).append("_|");
        builder.append("\n|_").append(squares[3]).append("_|_").append(squares[4]).append("_|_").append(squares[5]).append("_|");
        builder.append("\n|_").append(squares[6]).append("_|_").append(squares[7]).append("_|_").append(squares[8]).append("_|");
        System.out.println(builder);
        builder.setLength(0);
    }
}
