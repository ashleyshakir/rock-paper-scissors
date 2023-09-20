package player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Human Player Class contains instance fields and methods only used by Human Players.
 */
public class HumanPlayer extends Player{
    private static final Scanner scan = new Scanner(System.in);
    private static final List<String> VALID_GAME_INPUT_LIST = Arrays.asList("quit", "rock", "paper", "scissors");

    /**
     * @return Return the move retrieved from the players input
     */
    @Override
    public String getMove() {
        return scan.nextLine().trim().toLowerCase();
    }

    /**
     * Validate the players move returned from the getMove() method by checking if the validGameInputList
     * contains the move.
     * @param move The players move.
     */
    public String validateMove(String move){
        while(!VALID_GAME_INPUT_LIST.contains(move)){
            System.out.println("Invalid input, try again.");
            move = scan.nextLine().trim().toLowerCase();
        }
        if(move.equals("quit")){
            System.out.println("Exiting the game.");
            scan.close();
            System.exit(0);
        }else{
            printChosenMove(move);
        }
        return move;
    }
}
