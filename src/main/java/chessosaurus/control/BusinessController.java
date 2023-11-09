package chessosaurus.control;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.engine.IEnemyMoverContext;

import java.util.Random;

/**
 * Main class of the engine to receive the moves and actions from UCI class and forward them to specific classes.
 * @version 1.0
 * @author Fabian Unger
 */
public class BusinessController implements IController {
    private Game game;


    private final IEnemyMoverContext enemyMoverContext;
    public BusinessController(IEnemyMoverContext enemyMoverContext) {
        this.enemyMoverContext = enemyMoverContext;
    }

    /**
     * Initialization of the game
     * @return new chessboard
     */
    @Override
    public Board initializeGame() {
        /*
        Color colorOfEnemy;

        Random random = new Random();
        if (random.nextInt(2) == 0) {
            colorOfEnemy = Color.WHITE;
        } else {
            colorOfEnemy = Color.BLACK;
        }

        this.game = new Game(colorOfEnemy, this.enemyMoverContext);
         */
        this.game = new Game(null, this.enemyMoverContext);
        return this.game.getChessboard();
    }

    /**
     * Checks the player's move
     * @param move player's move
     * @return updated chessboard
     */
    @Override
    public Board reviewPlayerMove(Move move) {
        game.reviewPlayerMove(move);
        return this.game.getChessboard();
    }

    /**
     * Calculates the best move possible for the enemy.
     * @return best move
     */
    @Override
    public Move calculateBestMove() {
        return this.game.calculateBestEnemyMove();
    }

    /**
     * Returns the game with all information
     * @return Game object
     */
    @Override
    public Game getGame() {
        return game;
    }
}
