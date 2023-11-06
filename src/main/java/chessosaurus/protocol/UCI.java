package chessosaurus.protocol;
import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.control.BusinessController;
import chessosaurus.control.IController;
import chessosaurus.persistence.OpeninggameRestReader;
import chessosaurus.players.Bot;
import chessosaurus.players.Person;

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
    MoveParser moveParser = new MoveParser();
    List<Move> moves      = new ArrayList<>();
    private final BusinessController controller;

    public UCI(BusinessController controller) {
        this.controller = controller;
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
        this.controller.initializePlayerVsPlayerGame();
        //this.controller.initializePlayerVsBotGame();
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

            /*needed for bot vs. player to decide what color the bot is
            if(this.controller.getGame().getBlackPlayer() != null && this.controller.getGame().getWhitePlayer() != null && movesToCheck.size() %2 !=0){
                this.controller.getGame().setWhitePlayer(new Bot(Color.WHITE));
                this.controller.getGame().setBlackPlayer(new Person(Color.BLACK));
            } else if(this.controller.getGame().getBlackPlayer() != null && this.controller.getGame().getWhitePlayer() != null) {
                this.controller.getGame().setWhitePlayer(new Person(Color.WHITE));
                this.controller.getGame().setBlackPlayer(new Bot(Color.BLACK));
            }*/

            if(movesToCheck.size()>0) {
                for (String moveInput : movesToCheck) {
                    this.moves.add(moveParser.fromUCIToMove(moveInput, this.controller.getGame().getChessboard()));
                }
                for (Move move : this.moves) {
                    this.controller.getGame().setChessboard(controller.executeMove(move));
                }
                //@TODO für Endspiel Datenbank => wenn auf dem feld max. 7 Figuren stehen bool setzen, sodass bei go Aufruf auf die Endspieldatenbank zugegriffen werden kann.
            }

        }
    }

    /**
     * inputGo is used to tell the engine to determine the best move.
     */
    private void inputGo() {
        //@TODO Aufruf der API muss noch nach Klassendiagramm erfolgen. Hier nur Testweise
        OpeninggameRestReader opening = new OpeninggameRestReader();
        if(this.moves.isEmpty()){
            System.out.println("bestmove" + opening.getMove(null));
        } else if (this.moves.size() == 1) {
            System.out.println("bestmove" + opening.getMove(this.moves.get(0)));
        } else {
            //@TODO durch den MINIMAX Algorithmus ersetzt werden
            System.out.println("minimax");
        }
    }

    /**
     * inputPrint is used to output the playfield in the console.
     */
    private void inputPrint() {
        //Print the field
        this.controller.getGame().getChessboard().displayBoard();
    }
}
