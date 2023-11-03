package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

abstract class MoveReviewerBase implements IMoveReviewer{

    /**
     * Checks if a piece of the same color is on the destination square.
     * If there's no piece of the same color on the destination square the method isSpecificLegalMove(Move move, Board chessboard) will be called.
     *
     * @param move The move to be checked.
     * @param chessboard The chessboard on which the move is made.
     * @return {@code true}, if the move was legal, else {@code false}.
     */
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


    /**
     * Checks whether a particular move is legal on the chessboard.
     * Each Piece has a own class where the move gets reviewed.
     *
     * @param move The move to be checked.
     * @param chessboard The chessboard on which the move is made.
     * @return {@code true}, if the move was legal, else {@code false}.
     */
    abstract boolean isSpecificLegalMove(Move move, Board chessboard);
}
