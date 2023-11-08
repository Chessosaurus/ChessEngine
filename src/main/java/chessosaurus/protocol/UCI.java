package chessosaurus.protocol;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.control.BusinessController;
import chessosaurus.control.IController;
import chessosaurus.persistence.OpeninggameRestReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The class UCI is responsible for the implementation of the UCI protocol.
 * <p>
 * @version 1.0
 * @author Fabian Eilber
 * @author Fabian Unger
 */

public class UCI {

    static String ENGINENAME = "Chessosaurus";

    List<Move> moves      = new ArrayList<>();
    private final IController controller;
    private final IMoveParser moveParser;

    public UCI(IController controller,
               IMoveParser moveParser) {
        this.controller = controller;
        this.moveParser = moveParser;
    }

    /**
     * uciCommunication() is responsible for receiving UCI protocol commands from the UI and processing them according to the
     * Process them according to the specifications of the UCI protocol.
     * Can possibly be executed multithreaded, for the corresponding use case.
     */
    public void uciCommunication() {

    Scanner inputScanner = new Scanner(System.in);
        while (true) {

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
            else if (inputString.startsWith("go"))
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
        this.moves.clear();
        this.controller.initializeGame();
    }

    /**
     * inputPosition is used to get positions and moves in FEN notation and convert them into an internal
     * chessboard. This allows the engine to evaluate or recommend moves.
     * @param inputString Positions and moves in FEN notation
     */
    private void inputPosition(String inputString) {
        this.moves = new ArrayList<>();
        String input = inputString.substring(9).concat(" ");

        //Positions of the chess pieces on the field
        if(input.contains("startpos")){
                this.controller.getGame().getChessboard().importFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        }

        /*if (input.contains("fen")) {
            String fenString = input.substring(4);
            if(fenString.contains("moves")) {
                fenString = fenString.split("moves")[0].trim();
            }
            this.controller.getGame().getChessboard().importFen(fenString);
        }*/

        //Moves that have been made
        if (input.contains("moves")) {
            input = input.substring(input.indexOf("moves")+6);
            String[] moves = input.split(" ");
            ArrayList<String> movesToCheck = new ArrayList<>();
            for (String move : moves) {
                if (!move.isEmpty()) {
                    movesToCheck.add(move);
                }
            }


            if(this.controller.getGame().getEnemy().getColor() == null && movesToCheck.size() %2 !=0){
                this.controller.getGame().getEnemy().setColor(Color.BLACK);
            } else if(this.controller.getGame().getEnemy().getColor() == null) {
                this.controller.getGame().getEnemy().setColor(Color.WHITE);
            }

            if(movesToCheck.size()>0) {
                for (String moveInput : movesToCheck) {
                    this.moves.add(moveParser.fromStringToMove(moveInput, this.controller.getGame().getChessboard()));
                }
                this.controller.getGame().setMoves(this.moves);
                for (Move move : this.moves) {
                    this.controller.getGame().setChessboard(controller.reviewPlayerMove(move));
                }
            }

        }
    }

    /**
     * inputGo is used to tell the engine to determine the best move.
     */
    private void inputGo() {
        //@TODO
        //@TODO für Endspiel Datenbank => wenn auf dem feld max. 7 Figuren stehen bool setzen, sodass bei go Aufruf auf die Endspieldatenbank zugegriffen werden kann.
        // //@TODO durch den MINIMAX Algorithmus ersetzt werden
        Move bestMove = this.controller.calculateBestMove();
    }

    /**
     * inputPrint is used to output the playfield in the console.
     */
    private void inputPrint() {
        //Print the field
        this.controller.getGame().getChessboard().displayBoard();
    }
}
