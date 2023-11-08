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

    @Override
    public Board initializeGame() {
        Color colorOfEnemy;

        Random random = new Random();
        if (random.nextInt(2) == 0) {
            colorOfEnemy = Color.WHITE;
        } else {
            colorOfEnemy = Color.BLACK;
        }

        this.game = new Game(colorOfEnemy, this.enemyMoverContext);
        return this.game.getChessboard();
    }

    @Override
    public Board reviewPlayerMove(Move move) {
        game.reviewPlayerMove(move);
        return this.game.getChessboard();
    }

    @Override
    public Move calculateBestMove() {
        return this.game.calculateBestEnemyMove();
    }

    @Override
    public Game getGame() {
        return game;
    }
}
