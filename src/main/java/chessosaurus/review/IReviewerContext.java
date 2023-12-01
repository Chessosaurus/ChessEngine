package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Move;

public interface IReviewerContext {

    boolean isLegalMove(Move move, Board board);

}
