package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ANTON on 14.07.2016.
 */
public class HumanPlayer {

    AvailableMoves availableMoves = new AvailableMoves();
    String humanMove;

    void makeHumanMove() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isAvailableMovement = false;

        while (!isAvailableMovement) {
            humanMove = reader.readLine();
            isAvailableMovement = availableMoves.isAvailableMove(humanMove);
        }
    }
}
