package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.base.Piece;

public class ReviewerContext {

    private IMoveReviewer reviewer;

    public void setReviewer(Piece piece){

    }
    public boolean isLegalMove(Move move, Board board){

        return reviewer.isLegalMove(move, board);
    }
}
