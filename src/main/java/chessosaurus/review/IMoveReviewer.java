package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Move;

public interface IMoveReviewer {
    public boolean isLegalMove(Move move, Board board);
}
