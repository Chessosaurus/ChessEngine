package chessosaurus.persistence;

import chessosaurus.base.Board;
import chessosaurus.base.Move;

/**
 * EndgameRestReader calls closing database via Rest to get move.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */

public class EndgameRestReader implements IRestReader{

    /**
     * Sends current board to get move from the api
     * @return best move
     */
    @Override
    public String getMove(Move currentMove) {
        return null;
    }
}
