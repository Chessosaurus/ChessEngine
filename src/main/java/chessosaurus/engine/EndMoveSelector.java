package chessosaurus.engine;

import chessosaurus.base.Board;
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

    /**
     * Accesses the interface for finding the best move in the endgame to get it.
     * @return Best move in the endgame.
     */
    public Move getBestMove(String currentBoardAsFen, Board currentBoard) {
        return this.endgameReader.getMove(currentBoardAsFen, currentBoard);
    }
}
