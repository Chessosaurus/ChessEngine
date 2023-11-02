package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.base.PieceType;

public class ReviewerContext {

    private IMoveReviewer reviewer;

    public boolean isLegalMove(Move move, Board board) {
        PieceType pieceType = move.getFrom().getPiece().getType();
        switch (pieceType) {
            case KING: this.reviewer = new KingMoveReviewer();
                break;
            case QUEEN: this.reviewer = new QueenMoveReviewer();
                break;
            case ROOK: this.reviewer = new RookMoveReviewer();
                break;
            case BISHOP: this.reviewer = new BishopMoveReviewer();
                break;
            case KNIGHT: this.reviewer = new KnightMoveReviewer();
                break;
            case PAWN: this.reviewer = new PawnMoveReviewer();
                break;
        }

        return this.reviewer.isLegalMove(move, board);
    }
}
