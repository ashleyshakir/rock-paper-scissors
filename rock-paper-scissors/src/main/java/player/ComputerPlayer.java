package player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Computer Player class contains instance fields and methods only used by Computer Players
 */
public class ComputerPlayer extends Player{
    private static final List<String> MOVES_LIST = Arrays.asList("rock","paper","scissors");
    private static final Random random = new Random();

    /**
     * @return Return a random move from the 'movesList' array list
     */
    @Override
    public String getMove() {
        int randomIndex = random.nextInt(MOVES_LIST.size());
        String randomMove = MOVES_LIST.get(randomIndex);
        printChosenMove(randomMove);
        return randomMove;
    }

}
