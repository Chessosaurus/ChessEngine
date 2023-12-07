package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

/**
 * The RookMoveReviewer class is responsible for review a rook's move.
 * <p>
 * @version 1.0
 * @author Tobias Hahn
 */

public class RookMoveReviewer extends MoveReviewerBase{

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
        Square[][] board = chessboard.getChessboard();
        //Color color = from.getPiece().getColor();
        int fromRank = from.getRank()-1;
        //int fromRankForSearch = chessboard.getChessboard().length - from.getRank();
        int fromFile = from.getFileVal()-1;

        int toRank = to.getRank()-1;
        int toFile = to.getFileVal()-1;

        if(!isCheck(color, chessboard)){
            if(toRank == fromRank && toFile != fromFile){
                if(toFile > fromFile){
                    for(int i = 1; i <= toFile-fromFile-1; i++){
                        if(board[fromRank][fromFile + i].getPiece().isPresent()){
                            return false;
                        }
                    }
                } else {
                    for(int i = 1; i <= fromFile-toFile-1; i++){
                        if(board[fromRank][fromFile - i].getPiece().isPresent()){
                            return false;
                        }
                    }
                }
                board[fromRank][fromFile].setCastlingRookPossible(false);
                return true;
            } else if (toFile == fromFile && toRank != fromRank) {
                if(toRank > fromRank){
                    for(int i = 1; i <= toRank-fromRank-1; i++){
                        if(board[fromRank + i][fromFile].getPiece().isPresent()){
                            return false;
                        }
                    }
                } else {
                    for(int i = 1; i <= fromRank-toRank-1; i++){
                        if(board[fromRank - i][fromFile].getPiece().isPresent()){
                            return false;
                        }
                    }
                }
                board[fromRank][fromFile].setCastlingRookPossible(false);
                return true;
            } else return false;
        }
        return false;
    }
}
