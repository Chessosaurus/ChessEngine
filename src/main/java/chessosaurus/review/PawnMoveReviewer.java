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
        Square[][] board = chessboard.getChessboard();
        Color color = from.getPiece().getColor();
        int fromFile = from.getFile();
        int toFile = to.getFile();
        char fromRank = from.getRank();
        char toRank = to.getRank();

        //kann nich nach vorne schlagen.
        if (board[toRank][toFile].getPiece() == null){
            if (color == Color.WHITE){
                if(fromFile == 2 && toFile ==4 && fromRank == toRank) return true;  //Checks if White Pawns first move
                else return toFile == fromFile + 1 && fromRank == toRank;
            }else{
                if(fromFile == 7 && toFile ==5 && fromRank == toRank) return true;  //Checks if Black Pawns first move
                else return toFile == fromFile - 1 && fromRank == toRank;
            }
        } else return false;
    }
}
