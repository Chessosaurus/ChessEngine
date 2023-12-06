package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;

public interface IMoveReviewer {
    boolean isLegalMove(Move move, Board board);
    boolean isCheck(Color color, Board chessboard);
}
