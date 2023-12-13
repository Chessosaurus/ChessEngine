package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.PieceType;

/**
 * The RevieweContext is to determine the correct reviewer
 * <p>
 *
 * @author Fabian Unger
 * @version 1.0
 */

public class ReviewerContext implements IReviewerContext {

    //private IMoveReviewer reviewer;

    /**
     * Checks depending on the piece if the move is legal
     *
     * @param move  move being done
     * @param board latest chessboard
     * @return true or false depening on the move
     */
    public boolean isLegalMove(Move move, Board board) {
        if (move.getFrom().getPiece().isEmpty()) {
            throw new IllegalArgumentException("From square is empty");
        }

        PieceType pieceType = move.getFrom().getPiece().get().getType();
        switch (pieceType) {
            case KING:
                return new KingMoveReviewer().isLegalMove(move, board);
            case QUEEN:
                return new QueenMoveReviewer().isLegalMove(move, board);
            case ROOK:
                return new RookMoveReviewer().isLegalMove(move, board);
            case BISHOP:
                return new BishopMoveReviewer().isLegalMove(move, board);
            case KNIGHT:
                return new KnightMoveReviewer().isLegalMove(move, board);
            case PAWN:
                return new PawnMoveReviewer().isLegalMove(move, board);


        }
            return false;

    }


    /**
     * Checks if color is in check or not
     * @param board Given chessboard
     * @param color Color to check
     * @return {@code true}, if color is in check, else {@code false}.
     */
    public boolean isCheck(Color color, Board board) {
        IMoveReviewer moveReviewer = new KingMoveReviewer();
        return moveReviewer.isCheck(color, board);
    }

}
