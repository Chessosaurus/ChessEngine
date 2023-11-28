package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.control.Game;
import chessosaurus.review.ReviewerContext;
import chessosaurus.engine.IMoveFinder;


import java.util.List;

/**
 * Determines the currently best move using the Minimax algorithm.
 * <p>
 *
 * @author Fabian Unger
 * @version 1.0
 */
public class MiniMaxAlgorithm {

    private int depth;

    private List<Move> possibleMoves;

    protected ReviewerContext reviewerContext;

    private final IMoveFinder moveFinder;

    public MiniMaxAlgorithm(IMoveFinder moveFinder) {
        this.moveFinder = moveFinder;
    }


    /**
     * Returns the best move calculated using the Minimax algorithm.
     *
     * @return best move
     */
    public Move getBestMove(List<Move> allMoves, Board currentBoard, Color currentColor, Game currentGame) {
        //TODO alle möglichen Spielzüge

        int bestValue = Integer.MIN_VALUE;
        Move bestMove = null;

        List<Move> legalMoves = this.moveFinder.getLegalMoves(currentBoard, currentColor);

        for (Move move : legalMoves) {

            Board newBoard = currentGame.deepCloneBoard();
            newBoard.makeMove(move, newBoard);
            int value = evaluate(newBoard, currentColor, currentGame);

            if (value > bestValue) {
                bestValue = value;
                bestMove = move;
            }
        }
        return bestMove;

    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setReviewerContext(ReviewerContext reviewerContext) {
        this.reviewerContext = reviewerContext;
    }


    protected int evaluate(Board currentBoard, Color currentColor, Game currentGame) {
        return evaluate(currentBoard, currentColor, currentGame, 1);
    }

    protected int evaluate(Board currentBoard, Color currentcolor, Game currentGame, int currentDepth) {

        if (currentDepth == depth) {
            return 0;
        } else {
            List<Move> legalMoves = this.moveFinder.getLegalMoves(currentBoard, currentcolor);
            if (legalMoves.isEmpty()) {

                //TODO PATT und SCHACH überprüfen

            } else {
                if (currentDepth % 2 == 0) {
                    int max = Integer.MIN_VALUE;
                    for (Move move : legalMoves) {
                        Board newBoard = currentGame.deepCloneBoard();
                        newBoard.makeMove(move, newBoard);
                        int value = evaluate(newBoard, currentcolor, currentGame, currentDepth + 1);
                        if (value > max) {
                            max = value;
                        }
                    }
                    return max;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (Move move : legalMoves) {
                        Board newBoard = currentGame.deepCloneBoard();
                        newBoard.makeMove(move, newBoard);
                        int value = evaluate(newBoard, currentcolor, currentGame, currentDepth + 1);

                        if (value < min) {
                            min = value;

                        }
                    }
                    return min;
                }
            }

        }
    }
}
