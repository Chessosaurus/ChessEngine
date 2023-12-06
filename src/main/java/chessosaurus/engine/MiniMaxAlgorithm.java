package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.control.Game;

import java.util.List;

/**
 * Determines the currently best move using the Minimax algorithm.
 * <p>
 *
 * @author Timo Zink
 * @version 2.0
 */
public class MiniMaxAlgorithm {

    private int depth = 3;

    private final IMoveFinder moveFinder;
    protected static IEvaluation evaluation = new Evaluation();

    //private final IMoveReviewer moveReviewer;

    public MiniMaxAlgorithm(IMoveFinder moveFinder) {
        this.moveFinder = moveFinder;


    }

    public void setEvaluation(IEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    public IMoveFinder getMoveFinder() {
        return moveFinder;
    }


    /**
     * Returns the best move calculated using the Minimax algorithm.
     *
     * @return bestMove
     */
    public Move getBestMove(Board currentBoard, Color currentColor, Game currentGame) {

        int bestValue = Evaluation.worstValue;
        Move bestMove = null;

        List<Move> legalMoves = this.moveFinder.getLegalMoves(currentBoard, currentColor);

        for (Move move : legalMoves) {

            Board newBoard = currentGame.deepCloneBoard();
            newBoard.makeMove(move);
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


    /**
     * Calculate the Value of a Move recursive and returns the Value
     * @param currentBoard
     * @param currentColor
     * @param currentGame
     * @return Value of the Move
     */

    protected int evaluate(Board currentBoard, Color currentColor, Game currentGame) {
        return evaluate(currentBoard, currentColor, currentGame, 1);
    }


    /**
     * @param currentBoard
     * @param currentcolor
     * @param currentGame
     * @param currentDepth
     * @return
     */
    protected int evaluate(Board currentBoard, Color currentcolor, Game currentGame, int currentDepth) {

        if (currentDepth == depth) {
            return evaluation.evaluateMove(currentBoard, currentcolor);
        } else {
            Color playerColor = currentcolor.getOpposite();
            List<Move> legalMoves = this.moveFinder.getLegalMoves(currentBoard, playerColor);
            if (legalMoves.isEmpty()) {

                if (!moveFinder.isColorInCheck(currentBoard, playerColor)) {
                    return Evaluation.balancedValue;
                }
                if (currentGame.getEnemy().getColor() == currentcolor) {
                    return Evaluation.mateValue - currentDepth;
                } else {
                    return -Evaluation.mateValue - currentDepth;
                }
            } else {
                if (currentDepth % 2 == 0) {
                    int max = Evaluation.worstValue;
                    for (Move move : legalMoves) {
                        Board newBoard = currentGame.deepCloneBoard();
                        newBoard.makeMove(move);
                        int value = evaluate(newBoard, playerColor, currentGame, currentDepth + 1);
                        if (value > max) {
                            max = value;
                        }
                    }
                    return max;
                } else {
                    int min = Evaluation.bestValue;
                    for (Move move : legalMoves) {
                        Board newBoard = currentGame.deepCloneBoard();
                        newBoard.makeMove(move);
                        int value = evaluate(newBoard, playerColor, currentGame, currentDepth + 1);

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
