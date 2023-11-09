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

    /**
     * Method which converts a string to a Move object.
     * @param moveInput Input as string
     * @param currentBoard The current chessboard
     * @return Move object
     */
    Move fromStringToMove(String moveInput, Board currentBoard);

    /**
     * Converts a Move object to string
     * @param move Move object
     * @return String
     */
    String fromMoveToString(Move move);
}
