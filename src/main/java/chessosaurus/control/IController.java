package chessosaurus.control;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;

/**
 * Interface of the main engine so that protocol can access over that the engine.
 * @version 1.0
 * @author Fabian Unger
 */
public interface IController {

    /**
     * Initialization of the game
     * @return new chessboard
     */
    Board initializeGame();

    /**
     * Checks the player's move
     * @param move player's move
     * @return updated chessboard
     */
    Board reviewPlayerMove(Move move);

    /**
     * Returns the game with all information
     * @return Game object
     */
    Game getGame();

    /**
     * Calculates the best move possible for the enemy.
     * @return best move
     */
    Move calculateBestMove();
}
