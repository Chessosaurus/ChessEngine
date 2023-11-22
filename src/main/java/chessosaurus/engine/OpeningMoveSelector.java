package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.persistence.IOpeninggameReader;

import java.util.List;

/**
 * Part of the strategy pattern for determining the best move, using access to an opening game database.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public class OpeningMoveSelector {

    private final IOpeninggameReader openinggameReader;

    public OpeningMoveSelector(IOpeninggameReader openinggameReader) {
        this.openinggameReader = openinggameReader;
    }

    /**
     * Accesses the interface for finding the best move in the opening game to get it.
     * @param currentBoard The current chessboard
     * @param allMoves all moves made
     * @return best move
     */
    public Move getBestMove(Board currentBoard, List<Move> allMoves) {
        return this.openinggameReader.getMove(currentBoard, allMoves);
    }
}
