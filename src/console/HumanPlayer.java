package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by ANTON on 14.07.2016.
 */
public class HumanPlayer {

    private AvailableMoves availableMoves;
    String humanMove;

    public HumanPlayer() {
        availableMoves = new AvailableMoves();
    }

    void makeHumanMove() throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean isAvailableMovement = false;

        while (!isAvailableMovement) {
            humanMove = scanner.nextLine();
            isAvailableMovement = availableMoves.isAvailableMove(humanMove);
        }
    }
}
