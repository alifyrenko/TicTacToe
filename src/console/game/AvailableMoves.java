package console.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 21.07.2016.
 */
public class AvailableMoves {

    public boolean isAvailableMove(String humanMove) {
        List<String> usedMoves = new ArrayList<>();

        int move;
        try {
            move = Integer.parseInt(humanMove);
            if (GameField.squares[move].equals(Constants.COMPUTER_SIGN_O) || GameField.squares[move].equals(Constants.HUMAN_SIGN_X)) {
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