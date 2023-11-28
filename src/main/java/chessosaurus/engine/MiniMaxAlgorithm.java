package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.control.Game;
import chessosaurus.review.ReviewerContext;
import chessosaurus.engine.IMoveFinder;
import chessosaurus.engine.IEvaluation;


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
    protected static IEvaluation evaluation;

    public MiniMaxAlgorithm(IMoveFinder moveFinder) {
        this.moveFinder = moveFinder;
    }


    public void setEvaluation (IEvaluation evaluation) {
        this.evaluation = evaluation;
    }


    /**
     * Returns the best move calculated using the Minimax algorithm.
     *
     * @return best move
     */
    public Move getBestMove(List<Move> allMoves, Board currentBoard, Color currentColor, Game currentGame) {
        //TODO alle möglichen Spielzüge

        int bestValue = Evaluation.badestValue;
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
            return evaluation.evaluateMove(currentBoard, currentcolor);
        } else {
            List<Move> legalMoves = this.moveFinder.getLegalMoves(currentBoard, currentcolor);
            if (legalMoves.isEmpty()) {
                //TODO PATT und MATT überprüfen
                return Evaluation.balancedValue;

            } else {
                if (currentDepth % 2 == 0) {
                    int max = Evaluation.badestValue;
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
                    int min = Evaluation.bestValue;
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
