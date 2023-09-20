package gameMechanics;

import player.HumanPlayer;

import java.util.*;

/**
 * HumanGame class contains instance fields and methods only needed to play a 2 player game of Rock, Paper, Scissors.
 * Implements GamePlay features and extends the game class.
 */
public class HumanGame extends Game implements Gameplay{
    private final HumanPlayer player1;
    private final HumanPlayer player2;

    /**
     * HumanGame Constructor initializes instance fields.
     * @param scan The Scanner object inherited from the Game class.
     * @param player1 A Human Player
     * @param player2 A Human Player
     */
    public HumanGame(Scanner scan, HumanPlayer player1, HumanPlayer player2){
        super(scan);
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Overridden from the Gameplay interface. The HumanGame play method will get player names and moves from
     * the Scanner object.
     */
    @Override
    public void play() {
        System.out.print("Player 1 enter name: ");
        player1.setName((Optional.of(scan.nextLine())));
        System.out.print("Player 2 enter name: ");
        player2.setName(Optional.ofNullable(scan.nextLine()));
        System.out.println("Welcome " + player1.getName() + " and " + player2.getName() + "!");
        System.out.println("Type 'rock', 'paper' or 'scissors' to play.");
        // passes the validated move of both player 1 and player 2 into the displayWinner method
        displayWinner(player1.validateMove(player1.getMove()),player2.validateMove(player2.getMove()),player1, player2);
        playAgain();
    }
    /**
     * Overridden from the gameplay interface. The HumanGame playAgain method will ask the user if they
     * would like to play again and depending on their input resets the human game or returns the user to the main menu.
     */
    @Override
    public void playAgain(){
        while (true) {
            System.out.println("Want to play again? 'yes' or 'no'");
            String response = scan.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                System.out.println("Type 'rock', 'paper', or 'scissors' to play.");
                displayWinner(player1.validateMove(player1.getMove()), player2.validateMove(player2.getMove()),player1, player2);
            } else if (response.equals("no")) {
                displayMenu();
                break; // Exit the loop and return to the main menu
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
    }

}
