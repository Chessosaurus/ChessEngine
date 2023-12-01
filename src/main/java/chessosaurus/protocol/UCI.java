package chessosaurus.protocol;
import antlr.InputLexer;
import antlr.InputParser;
import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.control.BusinessController;
import chessosaurus.control.IController;
import chessosaurus.parser.Converter;
import chessosaurus.persistence.EndgameRestReader;
import chessosaurus.persistence.OpeninggameRestReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Future;

/**
 * The class UCI is responsible for the implementation of the UCI protocol.
 * <p>
 * @version 1.0
 * @author Fabian Eilber
 * @author Fabian Unger
 */

public class UCI {

    static String ENGINENAME = "Chessosaurus";
    Scanner inputScanner = new Scanner(System.in);
    private Thread goThread = null;
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
                if (goThread == null || !goThread.isAlive()) {
                    goThread = new Thread(this::inputGo);
                    goThread.start();
                } else {
                    System.out.println("Ein 'go'-Thread läuft bereits.");
                }
                //inputGo();
            }
            else if (inputString.startsWith("stop"))
            {
                if (goThread != null && goThread.isAlive()) {
                    goThread.interrupt();
                }
                System.out.println("bestmove none");
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
        InputLexer lexer = new InputLexer(CharStreams.fromString(inputString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InputParser parser = new InputParser(tokens);
        InputParser.StartContext stc = parser.start();
        Board board = new Converter().visitStart(stc);
        this.controller.getGame().setChessboard(board);
        this.controller.getGame().getEnemy().setColor(Color.BLACK);

//        this.moves = new ArrayList<>();
//        String input = inputString.substring(9).concat(" ");
//
//        //Positions of the chess pieces on the field
//        if(input.contains("startpos")){
//                this.controller.getGame().getChessboard().importFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
//                //this.controller.getGame().getChessboard().importFen("8/4k3/8/2p1P3/3Q4/8/2K5/8 w - - 0 1");
//        }
//
//        /*if (input.contains("fen")) {
//            String fenString = input.substring(4);
//            if(fenString.contains("moves")) {
//                fenString = fenString.split("moves")[0].trim();
//            }
//            this.controller.getGame().getChessboard().importFen(fenString);
//        }*/
//
//        //Moves that have been made
//        if (input.contains("moves")) {
//            input = input.substring(input.indexOf("moves")+6);
//            String[] moves = input.split(" ");
//            ArrayList<String> movesToCheck = new ArrayList<>();
//            for (String move : moves) {
//                if (!move.isEmpty()) {
//                    movesToCheck.add(move);
//                }
//            }
//
//
//            if(this.controller.getGame().getEnemy().getColor() == null && movesToCheck.size() %2 !=0){
//                this.controller.getGame().getEnemy().setColor(Color.BLACK);
//            } else if(this.controller.getGame().getEnemy().getColor() == null) {
//                this.controller.getGame().getEnemy().setColor(Color.WHITE);
//            }
//
//            if(movesToCheck.size()>0) {
//                for (String moveInput : movesToCheck) {
//                    Move move = moveParser.fromStringToMove(moveInput, this.controller.getGame().getChessboard());
//                    this.controller.getGame().setChessboard(controller.reviewPlayerMove(move));
//                    this.moves.add(move);
//                }
//                this.controller.getGame().setMoves(this.moves);
//
//            }
//        }
    }

    /**
     * inputGo is used to tell the engine to determine the best move.
     */
    private void inputGo() {
        // TODO durch den MINIMAX Algorithmus ersetzt werden.
        System.out.println("bestmove " + moveParser.fromMoveToString(this.controller.calculateBestMove()));
        goThread.interrupt();
    }

    /**
     * inputPrint is used to output the playfield in the console.
     */
    private void inputPrint() {
        //Print the field
        this.controller.getGame().getChessboard().displayBoard();
    }
}
