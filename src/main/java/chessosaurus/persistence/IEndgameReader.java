package chessosaurus.persistence;

import chessosaurus.base.Move;

/**
 * Interface to get the best move in the endgame from a database or something else.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public interface IEndgameReader {

    /**
     * Sends current board to get move from the api
     * @return best move
     */
    Move getMove();

}
