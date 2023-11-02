package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

public class KingMoveReviewer extends MoveReviewerBase {
    @Override
    boolean isSpecificLegalMove(Move move, Board chessboard) {
        Square from = move.getFrom();
        Square to = move.getTo();
        Color color = from.getPiece().getColor();
        int fromFile = from.getFile();
        int toFile = to.getFile();
        char fromRank = from.getRank();
        char toRank = to.getRank();

        if(toFile == fromFile+1 || toFile == fromFile-1){
            if(toRank == toRank+1 || toRank == fromRank-1){
                return true;
            }
        }else if(toFile == fromFile && (toRank == fromRank+1 || toRank == fromRank-1)){
            return true;
        } else if (toRank == fromRank && (toFile == fromFile+1 || toFile == fromFile-1)){
            return true;
        } else return false;

        return false;
    }
}
