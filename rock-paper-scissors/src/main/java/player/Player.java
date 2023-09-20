package player;

import java.util.Optional;

/**
 * Abstract Player class used as a blueprint for the HumanPlayer and ComputerPlayer classes to inherit from
 */
public abstract class Player {
    private String name;
    private int points;

    /**
     * Player Constructor sets default values for Player name and points.
     */
    public Player(){
        this.name = "Computer"; // set to 'computer' by default
        this.points = 0;
    }

    /**
     * @return Return player name
     */
    public String getName(){
        return name;
    }

    /**
     * Accept an optional string name to account for an empty or null value
     * @param name The optional string name
     */
    public void setName(Optional<String> name) {
        this.name = name.filter(s -> !s.isEmpty()).orElse("Player");
    }

    /**
     * @return Return player points
     */
    public String getPoints(){
        return name + " Wins: " + points;
    }

    /**
     * Accept a number of points to set points equal too
     * @param points The number of points
     */
    public void setPoints(int points){
        this.points = points;
    }

    /**
     * Increase points counter
     */
    public void addPoints(){
        points++;
    }

    /**
     * Will retrieve Human Player moves differently than Computer Player moves
     * @return Return the players move
     */
    public abstract String getMove();

    public void printChosenMove(String move){
        System.out.println(name + " chose " + move);
    }

}
