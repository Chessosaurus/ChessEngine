package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;

/**
 * Interface to get the best move by current board and playing color.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public interface IEnemyMover {
    Move getBestMove(Board currentBoard, Color currentColor);
}
