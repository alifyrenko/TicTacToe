package console;

import java.util.ArrayList;
import java.util.List;

import static console.Constants.COMPUTER_SIGN_O;

/**
 * Created by ANTON on 21.07.2016.
 */
public class AvailableMoves {
    static List<String> usedMoves = new ArrayList<>();

    boolean isAvailableMove(String humanMove) {
        int move;
        try {
            move = Integer.parseInt(humanMove);
        } catch (NumberFormatException e) {
            System.out.println("Pls, use only numbers you see on the table.");
            return false;
        }

        if (GameField.squares[move].equals(COMPUTER_SIGN_O)){
            System.out.println("Field is already used by computer!");
            return false;
        } else if (move > 8 || move < 0) {
            System.out.println("Pls, use only numbers you see on the table.");
            return false;
        } else if (usedMoves.contains(humanMove)) {
            System.out.println("You've already used the move '" + humanMove + "'");
            System.out.println("Pls, use only numbers you see on the table.");
            return false;
        } else {
            usedMoves.add(humanMove);
            return true;
        }
    }
}
