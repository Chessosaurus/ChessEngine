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

        //Testing => input thist fen-Notation in the console after run:  position fen rnbqkbnr/pppppppp/8/8/8/8/PPPPPPP/RNBQKBNR b KQkq - 0 1 moves e2e4 e7e5 g1f3
        //To display the Field enter "print"
    }
}
