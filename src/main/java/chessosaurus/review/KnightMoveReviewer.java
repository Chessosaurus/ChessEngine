package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

/**
 * The KnightMoveReviewer class is responsible for review a knight's move.
 * <p>
 * @version 1.0
 * @author Tobias Hahn
 */

public class KnightMoveReviewer extends MoveReviewerBase{

    /**
     * Checks whether a particular move is legal on the chessboard.
     *
     * @param move The move to be checked.
     * @param chessboard The chessboard on which the move is made.
     * @return {@code true}, if the move was legal, else {@code false}.
     */
    @Override
    boolean isSpecificLegalMove(Move move,Color color, Board chessboard) {
        Square from = move.getFrom();
        Square to = move.getTo();
        //Color color = from.getPiece().getColor();
        int fromFile = from.getFile();
        int toFile = to.getFile();
        int fromRank = from.getRankVal()-1;
        int toRank = to.getRankVal()-1;

        if(!isCheck(move, chessboard)){
            if((toFile == fromFile+2 || toFile == fromFile-2) && (toRank == fromRank+1 || toRank == fromRank-1)) return true;
            else return (toFile == fromFile + 1 || toFile == fromFile - 1) && (toRank == fromRank + 2 || toRank == fromRank - 2);
        }
        return false;
    }
}
