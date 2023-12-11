package chessosaurus.control;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.engine.IEnemyMoverContext;
import chessosaurus.review.IReviewerContext;

/**
 * Main class of the engine to receive the moves and actions from UCI class and forward them to specific classes.
 * @version 1.0
 * @author Fabian Unger
 */
public class BusinessController implements IController {
    private Game game;


    private final IEnemyMoverContext enemyMoverContext;
    private final IReviewerContext reviewerContext;
    public BusinessController(IEnemyMoverContext enemyMoverContext, IReviewerContext reviewerContext) {
        this.enemyMoverContext = enemyMoverContext;
        this.reviewerContext = reviewerContext;
    }

    public BusinessController(IEnemyMoverContext enemyMoverContext, Game game, IReviewerContext reviewerContext) {
        this.enemyMoverContext = enemyMoverContext;
        this.game = game;
        this.reviewerContext = reviewerContext;
    }

    /**
     * Initialization of the game
     * @return new chessboard
     */
    @Override
    public Board initializeGame() {
        this.game = new Game(null, this.enemyMoverContext, this.reviewerContext);
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
