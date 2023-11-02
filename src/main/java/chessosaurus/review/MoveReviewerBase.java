package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

abstract class MoveReviewerBase implements IMoveReviewer{
    @Override
    public boolean isLegalMove(Move move, Board chessboard) {
        Square from = move.getFrom();
        Square to = move.getTo();

        if(to.getPiece() == null){
            return isSpecificLegalMove(move, chessboard);
        } else {
            if(to.getPiece().getColor() != from.getPiece().getColor()){
                return isSpecificLegalMove(move, chessboard);
            }else return false;
        }
    }

    abstract boolean isSpecificLegalMove(Move move, Board chessboard);
}
