package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

/**
 * The BishopMoveReviewer class is responsible for review a bishop's move.
 * <p>
 * @version 1.0
 * @author Tobias Hahn
 */

public class BishopMoveReviewer extends MoveReviewerBase{

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
        char fromRank = from.getRank();
        char toRank = to.getRank();

        for(int i = 1; i<=8; i++){
            if(toFile == fromFile+i || toFile == fromFile-i){
                if(toRank == fromRank+i || toRank == fromRank-i){
                    if(toRank > fromRank){
                        if(toFile > fromFile){
                            for(int j = 1; j < toRank-fromRank; j++){
                                if(board[fromRank+j][fromFile+j].getPiece() != null){
                                    return false;
                                }
                            }
                        }else {
                            for(int j = 1; j < toRank-fromRank; j++){
                                if(board[fromRank+j][fromFile-j].getPiece() != null){
                                    return false;
                                }
                            }
                        }
                    } else {
                        if(toFile > fromFile){
                            for(int j = fromRank; j > fromRank-toRank; j--){
                                if(board[fromRank-j][fromFile+j].getPiece() != null){
                                    return false;
                                }
                            }
                        } else {
                            for(int j = fromRank; j > fromRank-toRank; j--){
                                if(board[fromRank-j][fromFile-j].getPiece() != null){
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
