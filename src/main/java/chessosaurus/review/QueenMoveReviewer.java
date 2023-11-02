package chessosaurus.review;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.base.Square;

public class QueenMoveReviewer extends MoveReviewerBase{
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
                if(toRank == toRank+i || toRank == fromRank-i){
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
                            for(int j = fromRank; j < fromRank-toRank; j--){
                                if(board[fromRank-j][fromFile+j].getPiece() != null){
                                    return false;
                                }
                            }
                        } else {
                            for(int j = fromRank; j < fromRank-toRank; j--){
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

        if(toFile == fromFile && toRank != fromRank){
            if(toRank > fromRank){
                for(int i = 1; i < toRank-fromRank; i++){
                    if(board[fromRank+i][fromFile].getPiece() != null){
                        return false;
                    }
                }
            } else {
                for(int i = fromRank; i < fromRank-toRank; i--){
                    if(board[fromRank-i][fromFile].getPiece() != null){
                        return false;
                    }
                }
            }
            return true;
        } else if (toRank == fromRank && toFile != fromFile) {
            if(toFile > fromFile){
                for(int i = 1; i < toFile-fromFile; i++){
                    if(board[fromRank][fromFile+i].getPiece() != null){
                        return false;
                    }
                }
            } else {
                for(int i = fromFile; i < fromFile-toFile; i--){
                    if(board[fromRank][fromFile-i].getPiece() != null){
                        return false;
                    }
                }
            }
            return true;
        } else return false;

        /*
        for(int i = 1; i<=8; i++){
            if(toFile == fromFile+i || toFile == fromFile-i){
                if(toRank == toRank+i || toRank == fromRank-i){
                    return true;
                }
            }
        }
        if(toFile == fromFile && toRank != fromRank){
            return true;
        } else if (toRank == fromRank && toFile != fromFile) {
            return true;
        } else return false;
         */
    }


}
