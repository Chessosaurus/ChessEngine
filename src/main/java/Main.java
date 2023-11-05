import chessosaurus.control.BusinessController;
import chessosaurus.protocol.UCI;

/**
 * This class starts the chessosaurus engine
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */
public class Main {
    public static void main(String[] args) {

        BusinessController controller = new BusinessController();

        //Instantiate object of class UCI to ensure communication
        UCI uci = new UCI(controller);
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
