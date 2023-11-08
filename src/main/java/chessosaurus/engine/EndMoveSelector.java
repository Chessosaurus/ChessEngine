package chessosaurus.engine;

import chessosaurus.base.Move;
import chessosaurus.persistence.IEndgameReader;

/**
 * Part of the strategy pattern for determining the best move, using access to an opening game database.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public class EndMoveSelector {

    private final IEndgameReader endgameReader;

    public EndMoveSelector(IEndgameReader endgameReader) {
        this.endgameReader = endgameReader;
    }

    public Move getBestMove() {
        return this.endgameReader.getMove();
    }
}
