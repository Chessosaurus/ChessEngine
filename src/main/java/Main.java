import chessosaurus.control.BusinessController;
import chessosaurus.engine.EnemyMoverContext;
import chessosaurus.engine.MoveFinder;
import chessosaurus.persistence.EndgameRestReader;
import chessosaurus.persistence.OpeninggameRestReader;
import chessosaurus.protocol.UCI;
import chessosaurus.protocol.UCIMoveParser;
import chessosaurus.review.ReviewerContext;

/**
 * This class starts the chessosaurus engine
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */
public class Main {
    public static void main(String[] args) {

        UCIMoveParser moveParser = new UCIMoveParser();

        ReviewerContext reviewerContext = new ReviewerContext();

        OpeninggameRestReader openinggameRestReader = new OpeninggameRestReader(moveParser, reviewerContext);
        EndgameRestReader endgameRestReader = new EndgameRestReader(moveParser, reviewerContext);

        MoveFinder moveFinder = new MoveFinder(reviewerContext);

        EnemyMoverContext enemyMoverContext = new EnemyMoverContext(openinggameRestReader, endgameRestReader, moveFinder);

        BusinessController controller = new BusinessController(enemyMoverContext, reviewerContext);

        //Instantiate object of class UCI to ensure communication
        UCI uci = new UCI(controller, moveParser);
        //Start the communication of the engine
        uci.uciCommunication();


        /*
         * Testing the Engine over the Terminal
         * 1. Input: ucinewgame (This initializes a new game)
         * 2. Input: position startpos moves e2e4 (this sets the board and converts moves)
         * 3. Input: print (This will give u feedback concerning the correct build of the board)
         * 4. Input: go (This will start the calculation for the best move)
         */
    }
}
