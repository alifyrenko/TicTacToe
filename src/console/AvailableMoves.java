package console;

import java.util.ArrayList;
import java.util.List;

import static console.Constants.COMPUTER_SIGN_O;
import static console.Constants.HUMAN_SIGN_X;

/**
 * Created by ANTON on 21.07.2016.
 */
public class AvailableMoves {
    List<String> usedMoves = new ArrayList<>();

    boolean isAvailableMove(String humanMove) {
        int move;
        try {
            move = Integer.parseInt(humanMove);
            if (GameField.squares[move].equals(COMPUTER_SIGN_O) || GameField.squares[move].equals(HUMAN_SIGN_X)) {
                System.out.println("Field is already used!");
                return false;

            } else {
                usedMoves.add(humanMove);
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Pls, use only numbers you see on the table.");
            return false;
        } catch (NumberFormatException e){
            System.out.println("Pls, use only numbers");
            return false;
        }
    }
}