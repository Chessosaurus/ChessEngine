package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

/**
 * The QueenMoveReviewer class is responsible for review a queen's move.
 * <p>
 * @version 1.0
 * @author Tobias Hahn
 */

public class QueenMoveReviewer extends MoveReviewerBase{

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
        int fromRank = from.getRank()-1;
        int fromFile = from.getFileVal()-1;

        int toRank = to.getRank()-1;
        int toFile = to.getFileVal()-1;

        if(!isCheck(color, chessboard)){
            for(int i = 1; i<=7; i++){
                if(toRank == fromRank+i || toRank == fromRank-i){
                    if(toFile == fromFile+i || toFile == fromFile-i){
                        if(toFile > fromFile){
                            if(toRank > fromRank){
                                for(int j = 1; j <= toFile-fromFile-1; j++){
                                    if(board[fromRank + j][fromFile + j].getPiece().isPresent()){
                                        return false;
                                    }
                                }
                            }else {
                                for(int j = 1; j <= toFile-fromFile-1; j++){
                                    if(board[fromRank - j][fromFile + j].getPiece().isPresent()){
                                        return false;
                                    }
                                }
                            }
                        } else {
                            if(toRank > fromRank){
                                for(int j = 1; j <= fromFile-toFile-1; j++){
                                    if(board[fromRank + j][fromFile - j].getPiece().isPresent()){
                                        return false;
                                    }
                                }
                            } else {
                                for(int j = 1; j <= fromFile-toFile-1; j++){
                                    if(board[fromRank - j][fromFile - j].getPiece().isPresent()){
                                        return false;
                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
            }

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
                return true;
            } else return false;
        }
        return false;
    }
}
