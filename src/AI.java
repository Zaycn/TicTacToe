import java.util.List;
import java.util.Random;

public class AI {
    private String choice;
    private String move;
    public AI(String choice){
        this.choice = choice;
    }

    public String getChoice(){
        return this.choice;
    }
    // AI picks a random move from the available moves
    public String generateMove(List<String> movesAvailable){
        Random rng = new Random();
        return movesAvailable.get(rng.nextInt(movesAvailable.size()));
    }
}
