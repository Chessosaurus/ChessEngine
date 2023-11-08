package chessosaurus.protocol;

import chessosaurus.base.Board;
import chessosaurus.base.Move;

/**
 * Interface to parse any string to Move object.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public interface IMoveParser {

    Move fromStringToMove(String moveInput, Board currentBoard);
    String fromMoveToString(Move move);
}
