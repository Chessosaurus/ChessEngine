package chessosaurus.control;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.players.Bot;
import chessosaurus.players.IPlayer;
import chessosaurus.players.Person;

import java.util.Random;

/**
 * Main class of the engine to receive the moves and actions from UCI class and forward them to specific classes.
 * @version 1.0
 * @author Fabian Unger
 */
public class Chessosaurus implements IChessEngine {
    private Game game;

    @Override
    public Board initializePlayerVsPlayerGame() {
        IPlayer whitePlayer = new Person(Color.WHITE);
        IPlayer blackPlayer = new Person(Color.BLACK);

        this.game = new Game(whitePlayer, blackPlayer);
        return this.game.getChessboard();
    }

    @Override
    public Board initializePlayerVsBotGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        IPlayer whitePlayer;
        IPlayer blackPlayer;
        if (randomNumber == 0) {
            whitePlayer = new Bot(Color.WHITE);
            blackPlayer = new Person(Color.BLACK);
        }
        else {
            whitePlayer = new Person(Color.WHITE);
            blackPlayer = new Bot(Color.BLACK);
        }

        this.game = new Game(whitePlayer, blackPlayer);
        return this.game.getChessboard();
    }

    @Override
    public Board executeMove(Move move) {
        game.executeMove(move);
        return this.game.getChessboard();
    }
}
