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
        int fromFile = from.getFile();
        int toFile = to.getFile();
        int fromRank = from.getRankVal()-1;
        int toRank = to.getRankVal()-1;

        if(!isCheck(move, chessboard)){
            if(toFile == fromFile && toRank != fromRank){
                if(toRank > fromRank){
                    for(int i = 1; i < toRank-fromRank; i++){
                        if(board[fromFile][fromRank + i].getPiece().isPresent()){
                            return false;
                        }
                    }
                } else {
                    for(int i = fromRank; i > fromRank-toRank; i--){
                        if(board[fromFile][fromRank - i].getPiece().isPresent()){
                            return false;
                        }
                    }
                }
                return true;
            } else if (toRank == fromRank && toFile != fromFile) {
                if(toFile > fromFile){
                    for(int i = 1; i < toFile-fromFile; i++){
                        if(board[fromFile + i][fromRank].getPiece().isPresent()){
                            return false;
                        }
                    }
                } else {
                    for(int i = fromFile; i > fromFile-toFile; i--){
                        if(board[fromFile - i][fromRank].getPiece().isPresent()){
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
