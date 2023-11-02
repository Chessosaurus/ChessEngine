package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

public class KnightMoveReviewer extends MoveReviewerBase{
    @Override
    boolean isSpecificLegalMove(Move move, Board chessboard) {
        Square from = move.getFrom();
        Square to = move.getTo();
        Color color = from.getPiece().getColor();
        int fromFile = from.getFile();
        int toFile = to.getFile();
        char fromRank = from.getRank();
        char toRank = to.getRank();

        if((toFile == fromFile+2 || toFile == fromFile-2) && (toRank == fromRank+1 || toRank == fromRank-1)) return true;
        else if ((toFile == fromFile+1 || toFile == fromFile-1) && (toRank == fromRank+2 || toRank == fromRank-2)) return true;
        else return false;
    }
}
