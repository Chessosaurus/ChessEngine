package chessosaurus.protocol;
import chessosaurus.base.Board;
import chessosaurus.base.Square;

import java.util.Scanner;

/**
 * The class UCI is responsible for the implementation of the UCI protocol.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */

public class UCI {

    static String ENGINENAME = "Chessosaurus";
    Board board = new Board();

    /**
     * uciCommunication() is responsible for receiving UCI protocol commands from the UI and processing them according to the
     * Process them according to the specifications of the UCI protocol.
     * Can possibly be executed multithreaded, for the corresponding use case.
     */
    public void uciCommunication() {

        while (true) {

            Scanner inputScanner = new Scanner(System.in);
            String inputString = inputScanner.nextLine();

            if ("uci".equals(inputString))
            {
                inputUCI();
            }
            else if ("isready".equals(inputString))
            {
                inputIsReady();
            }
            else if (inputString.startsWith("setoption"))
            {
                inputSetOption(inputString);
            }
            else if ("ucinewgame".equals(inputString))
            {
                inputUCINewGame();
            }
            else if (inputString.startsWith("position"))
            {
                inputPosition(inputString);
            }
            else if ("go".equals(inputString))
            {
                inputGo();
            }
            else if ("print".equals(inputString))
            {
                inputPrint();
            }
        }
    }

    /**
     * inputUCI is responsible for the initial start of the engine. After the command "uci" is received, the * engine must identify itself.
     * the engine must identify itself. For this, the ID of the engine must be transmitted. Optionally, options of the
     * Engine and the ID Author can be transmitted.
     * Finally, uciok is transmitted to confirm the UCI mode.
     */
    private void inputUCI() {
        System.out.println("id name " + ENGINENAME);
        System.out.println("id author Chessosaurus Ltd.");
        //Weitere Einstellungen der Engine (optional)
        System.out.println("uciok");
    }

    /**
     * inputIsRead is intended for the synchronisation of the engine and the GUI. If the GUI has sent several commands
     * this command is used to wait for the engine until it is ready. The engine must always respond to this command
     * respond to this command with "readyok".
     */
    private void inputIsReady() {
        System.out.println("readyok");
    }

    /**
     * inputSetOption is used to change internal parameters of the engine.
     * @param inputString is the parameter that determines which change should be made.
     */
    private void inputSetOption(String inputString) {
        //Define settings
    }

    /**
     * inputUCINewGame is used when the next search is from another game. Say a new game,
     * which the engine should analyse.
     */
    private void inputUCINewGame() {
        //Start new game
    }

    /**
     * inputPosition is used to get positions and moves in FEN notation and convert them into an internal
     * chessboard. This allows the engine to evaluate or recommend moves.
     * @param inputString Positions and moves in FEN notation
     */
    private void inputPosition(String inputString) {

        String input = inputString.substring(9).concat(" ");

        Square[][] chessboard = new Square[8][8];

        //Positions of the chess pieces on the field
        if (input.contains("fen")) {
            String fenString = input.substring(4);
            if(fenString.contains("moves")) {
                fenString = fenString.split("moves")[0].trim();
            }
            chessboard = board.importFen(fenString);
        }
        //Moves that have been made
        if (input.contains("moves")) {
            input = input.substring(input.indexOf("moves")+6);
        }
    }

    /**
     * inputGo is used to tell the engine to determine the best move.
     */
    private void inputGo() {
        //Call to determine best move
    }

    /**
     * inputPrint is used to output the playfield in the console.
     */
    private void inputPrint() {
        //Print the field
        board.displayBoard();
    }
}
