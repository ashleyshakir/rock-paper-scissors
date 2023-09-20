import gameMechanics.Game;

import java.util.Scanner;

/**
 * Driver class for creating and running the game.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game game = new Game(scan);
        game.displayMenu();
    }
}
