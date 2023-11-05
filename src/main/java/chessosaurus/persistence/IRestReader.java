package chessosaurus.persistence;

import chessosaurus.base.Board;
import chessosaurus.base.Move;

/**
 * Interface for game opening
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */

public interface IRestReader {

    /**
     * Sends current board to get move from the api
     * @return best move
     */
    String getMove(Move currentMove);
}
