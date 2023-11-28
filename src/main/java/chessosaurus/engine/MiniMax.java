package chessosaurus.engine;

import chessosaurus.base.Move;

/**
 * Determines the currently best move using the Minimax algorithm.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public class MiniMax {

    private final IMoveFinder moveFinder;

    public MiniMax(IMoveFinder moveFinder) {
        this.moveFinder = moveFinder;
    }


    /**
     * Returns the best move calculated using the Minimax algorithm.
     * @return best move
     */
    public Move getBestMove() {
        return null;
    }
}
