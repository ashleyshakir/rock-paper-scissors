package gameMechanics;

import player.ComputerPlayer;
import player.HumanPlayer;

import java.util.Optional;
import java.util.Scanner;

/**
 * ComputerGame class contains instance fields and methods only needed to play a game of Rock, Paper, Scissors
 * against the computer. Implements GamePlay features and extends the game class.
 */
public class ComputerGame extends Game implements Gameplay{
    private final HumanPlayer player1;
    private final ComputerPlayer computer;

    /**
     * ComputerGame constructor initializes instance fields.
     * @param scan The Scanner object inherited from the Game class.
     * @param player1 The Human Player.
     * @param computer The Computer Player.
     */
    public ComputerGame(Scanner scan, HumanPlayer player1, ComputerPlayer computer){
        super(scan);
        this.player1 = player1;
        this.computer = computer;
    }

    /**
     * Overridden from the Gameplay interface. The ComputerGame play method will get a human player
     * name and both human player and computer player moves.
     */
    @Override
    public void play() {
        System.out.print("Player 1 enter name: ");
        player1.setName(Optional.of(scan.nextLine()));
        System.out.println("Welcome " + player1.getName() + "! You will be playing against the computer.");
        System.out.println("Type 'rock', 'paper' or 'scissors' to play.");
        displayWinner(player1.validateMove(player1.getMove()),computer.getMove(),player1, computer);
        playAgain();
    }

    /**
     * Overridden from the gameplay interface. The ComputerGame playAgain method will ask the user if they
     * would like to play again and depending on their input resets the computer game or returns the user to the main menu.
     */
    @Override
    public void playAgain(){
        while (true) {
            System.out.println("Want to play again? 'yes' or 'no'");
            String response = scan.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                System.out.println("Type 'rock', 'paper', or 'scissors' to play.");
                displayWinner(player1.validateMove(player1.getMove()), computer.getMove(),player1, computer);
            } else if (response.equals("no")) {
                displayMenu();
                break; // Exit the loop and return to the main menu
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
    }
}
