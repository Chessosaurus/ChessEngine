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

        if(from.getPiece().isEmpty()){
            throw new IllegalArgumentException("From square is empty");
        }
        if(to.getPiece().isEmpty()){
            return isSpecificLegalMove(move,from.getPiece().get().getColor() ,chessboard);
        } else {
            if(to.getPiece().get().getColor() != from.getPiece().get().getColor()){
                return isSpecificLegalMove(move,from.getPiece().get().getColor(),chessboard);
            }else return false;
        }
    }


    /**
     * Checks whether a particular move is legal on the chessboard.
     * Each Piece has an own class where the move gets reviewed.
     *
     * @param move The move to be checked.
     * @param chessboard The chessboard on which the move is made.
     * @return {@code true}, if the move was legal, else {@code false}.
     */
    abstract boolean isSpecificLegalMove(Move move,Color color, Board chessboard);
}
