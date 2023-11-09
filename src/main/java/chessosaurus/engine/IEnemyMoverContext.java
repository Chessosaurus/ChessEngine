package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;

import java.util.List;

/**
 * Interface for Game to access the strategy pattern to get the best move.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public interface IEnemyMoverContext {

    /**
     * Method to provide the best current move.
     * @param allMoves All previous moves
     * @param currentBoard The current chessboard
     * @param currentColor The color of the enemy
     * @return Best move
     */
    Move getBestMove(List<Move> allMoves, Board currentBoard, Color currentColor);

}
