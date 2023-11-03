package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

/**
 * The PawnMoveReviewer class is responsible for review a pawn's move.
 * <p>
 * @version 1.0
 * @author Tobias Hahn
 */

public class PawnMoveReviewer extends MoveReviewerBase{

    /**
     * Checks whether a particular move is legal on the chessboard.
     *
     * @param move The move to be checked.
     * @param chessboard The chessboard on which the move is made.
     * @return {@code true}, if the move was legal, else {@code false}.
     */
    @Override
    boolean isSpecificLegalMove(Move move, Board chessboard) {
        Square from = move.getFrom();
        Square to = move.getTo();
        Square[][] board = chessboard.getChessboard();
        Color color = from.getPiece().getColor();
        int fromFile = from.getFile();
        int toFile = to.getFile();
        int fromRank = charToInt(from.getRank());
        int toRank = charToInt(to.getRank());

        //kann nich nach vorne schlagen.
        if (board[toRank-1][toFile-1].getPiece() == null){
            if (color == Color.WHITE){
                if(fromFile == 2 && toFile ==4 && fromRank == toRank) return true;  //Checks if White Pawns first move
                else return toFile == fromFile + 1 && fromRank == toRank;
            }else{
                if(fromFile == 7 && toFile ==5 && fromRank == toRank) return true;  //Checks if Black Pawns first move
                else return toFile == fromFile - 1 && fromRank == toRank;
            }
        } else return false;
    }

    private int charToInt(char input){

        int intValue;

        switch (input) {
            case 'a':
                intValue = 1;
                break;
            case 'b':
                intValue = 2;
                break;
            case 'c':
                intValue = 3;
                break;
            case 'd':
                intValue = 4;
                break;
            case 'e':
                intValue = 5;
                break;
            case 'f':
                intValue = 6;
                break;
            case 'g':
                intValue = 7;
                break;
            case 'h':
                intValue = 8;
                break;
            default:
                intValue = 0;
        }
        return intValue;
    }
}
