package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.persistence.IOpeninggameReader;

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

    public Move getBestMove(Board currentBoard, Move lastMove) {
        return this.openinggameReader.getMove(currentBoard, lastMove);
    }
}
