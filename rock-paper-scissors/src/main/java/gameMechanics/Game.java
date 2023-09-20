package gameMechanics;

import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Game class is used as a blueprint for the HumanGame and ComputerGame classes to inherit from
 */
public class Game{
    private static final List<String> gameHistory = new ArrayList<>();
    private static final List<String> VALID_USER_INPUT = Arrays.asList("2 players","vs. computer","history","clear","quit");
    protected Scanner scan;
    private static final Map<String, String> WINNING_MOVES = Map.of("rock", "scissors", "paper", "rock", "scissors", "paper");
    /**
     * Game constructor takes a Scanner object
     * @param scan The Scanner object
     */
    public Game(Scanner scan){
        this.scan = scan;
    }

    public void displayMenu() {
        System.out.println("""
            Welcome to Rock Paper Scissors!
            
            ---------------------MAIN MENU---------------------
            1. Type '2 players' to play against a human player.
            2. Type 'vs. computer' to play against a computer player.
            3. Type 'history' to view your game history.
            4. Type 'clear' to clear game history.
            5. Type 'quit' to exit the game.
                """);

        checkInput();
    }

    /**
     * Method used to check initial player input.
     * Depending on the input either a new human game is created, a new computer game is created,
     * game history is printed to the console, or the player is returned to the main menu.
     */
    private void checkInput(){
        String input = scan.nextLine().trim().toLowerCase();
        while(!VALID_USER_INPUT.contains(input)){
            System.out.println("Invalid input, try again.");
            input = scan.nextLine().trim().toLowerCase();
        }
        switch (input) {
            case "2 players" -> startHumanGame();
            case "vs. computer" -> startComputerGame();
            case "history" -> printHistory();
            case "clear" -> clearHistory();
            case "quit" -> exitGame();
        }
    }

    /**
     * User notified that they chose to play 2 player game mode.
     * Two HumanPlayer instances are initialized.
     * A new HumanGame is created.
     * Play method called to ask for player names and moves.
     */
    private void startHumanGame(){
        System.out.println("-----------------------PLAY------------------------");
        System.out.println("You chose 2 player game mode.");
        HumanPlayer player1 = new HumanPlayer();
        HumanPlayer player2 = new HumanPlayer();
        HumanGame humanGame = new HumanGame(scan, player1, player2);
        humanGame.play();

    }

    /**
     * User notified that they chose to play computer game mode.
     * One HumanPlayer instance and one ComputerPlayer instance are initialized.
     * A new computer game is created.
     * Play method called to ask for human player name and make player moves.
     */
    private void startComputerGame(){
        System.out.println("-----------------------PLAY------------------------");
        System.out.println("You chose to play computer game mode.");
        HumanPlayer player1 = new HumanPlayer();
        ComputerPlayer computer = new ComputerPlayer();
        ComputerGame computerGame = new ComputerGame(scan, player1, computer);
        computerGame.play();
    }
    public void printHistory(){
        System.out.println("----------------------HISTORY----------------------");
        if(gameHistory.isEmpty()){
            System.out.println("There is no game history at this time.");
        } else {
            for (String s : gameHistory) {
                System.out.println(s);
            }
        }
        checkInput();
    }
    private void exitGame(){
        System.out.println("Exiting the game.");
        System.exit(0);
    }
    /**
     * Add date and time move was made to history to game history list
     * Add player name and move made to the game history list
     * Add current win counts of each player to game history list
     */
    public void addToHistory(String move1, String move2, Player player1, Player player2){
        LocalDateTime now = LocalDateTime.now(); // get the current date and time
        // format the date and time as a string
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String formattedDateTime = now.format(format);
        gameHistory.add(formattedDateTime + " - " +
                player1.getName() + " played " + move1 + ", " +
                player2.getName() + " played " + move2);
        gameHistory.add(player1.getPoints()+ ", " + player2.getPoints());
    }

    private void clearHistory(){
        System.out.println("History cleared.");
        gameHistory.clear();
        checkInput();
    }

    /**
     * Display the winner of the round by comparing each players moves to the winning moves in the
     * winningMoves HashMap.
     * Add both player's stats to the history array, and ask to play again.
     * @param move1 Player one's move
     * @param move2 Player two's move
     */
    public void displayWinner(String move1, String move2, Player player1, Player player2){
        if(WINNING_MOVES.containsKey(move1) && WINNING_MOVES.get(move1).equals(move2)){
            printWinner(move1 + " beats " + move2 + "! " + player1.getName() + " wins!");
            player1.addPoints();
        } else if(WINNING_MOVES.containsKey(move2) && WINNING_MOVES.get(move2).equals(move1)){
            printWinner(move2 + " beats " + move1 + "! " + player2.getName() + " wins!");
            player2.addPoints();
        } else {
            printWinner("It's a tie!");
        }
        addToHistory(move1, move2, player1, player2);
    }

    private void printWinner(String str){
        System.out.println("----------------------RESULTS----------------------");
        System.out.println(str);
        System.out.println("---------------------------------------------------");
    }
}
