package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;

import java.util.List;

/**
 * Interface to find all legal moves based on the given chessboard and current color.
 * @version 1.0
 * @author Fabian Unger
 */
public interface IMoveFinder {

    /**
     * Calculates all legal moves.
     * @param board Given chessboard
     * @param currentColor Color for the moves to find
     * @return All legal moves
     */
    List<Move> getLegalMoves(Board board, Color currentColor);

}
