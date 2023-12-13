package chessosaurus.control;


import chessosaurus.base.*;
import chessosaurus.engine.*;
import chessosaurus.review.IReviewerContext;
import chessosaurus.review.ReviewerContext;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MiniMaxTest {

    private MinimaxThreading minimaxThreading;
    private MiniMaxAlgorithm miniMaxAlgorithm;

    public MiniMaxTest() {
        ReviewerContext reviewerContext = new ReviewerContext();
        MoveFinder finder = new MoveFinder(reviewerContext);
        this. minimaxThreading = new MinimaxThreading(finder);
        this.miniMaxAlgorithm = new MiniMaxAlgorithm(finder);

    }
    @Test
    void testThreadingBestMove() {

        // ARRANGE
        Board board = new Board();
        board.importFen("8/4k3/8/2p1P3/3Q4/8/2K5/8 b - - 0 1");


        // ACT

        Move move = minimaxThreading.getBestMove(board, Color.BLACK);


        //ASSERT
        assertNotNull(move);
    }

    @Test
    void testAlgorithmBestMove() {

        // ARRANGE
        Board board = new Board();
        board.importFen("8/4k3/8/2p1P3/3Q4/8/2K5/8 b - - 0 1");


        // ACT
        Move move = miniMaxAlgorithm.getBestMove(board, Color.BLACK);


        //ASSERT
        assertNotNull(move);
    }
}
