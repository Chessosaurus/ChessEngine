package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

public class PawnMoveReviewer extends MoveReviewerBase{
    @Override
    boolean isSpecificLegalMove(Move move, Board chessboard) {
        Square from = move.getFrom();
        Square to = move.getTo();
        Color color = from.getPiece().getColor();
        int fromFile = from.getFile();
        int toFile = to.getFile();
        char fromRank = from.getRank();
        char toRank = to.getRank();

        //kann nich nach vorne schlagen.

        if (color == Color.WHITE){
            if(fromFile == 2 && toFile ==4 && fromRank == toRank) return true;  //Checks if White Pawns first move
            else if (toFile == fromFile+1 && fromRank == toRank) return true;
            else return false;
        }else{
            if(fromFile == 7 && toFile ==5 && fromRank == toRank) return true;  //Checks if Black Pawns first move
            else if (toFile == fromFile-1 && fromRank == toRank) return true;
            else return false;
        }
    }
}
