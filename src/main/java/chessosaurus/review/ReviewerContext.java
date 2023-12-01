package chessosaurus.review;

import chessosaurus.base.Board;
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

    private IMoveReviewer reviewer;

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
                this.reviewer = new KingMoveReviewer();
                break;
            case QUEEN:
                this.reviewer = new QueenMoveReviewer();
                break;
            case ROOK:
                this.reviewer = new RookMoveReviewer();
                break;
            case BISHOP:
                this.reviewer = new BishopMoveReviewer();
                break;
            case KNIGHT:
                this.reviewer = new KnightMoveReviewer();
                break;
            case PAWN:
                this.reviewer = new PawnMoveReviewer();
                break;
        }

        return this.reviewer.isLegalMove(move, board);
    }
}
