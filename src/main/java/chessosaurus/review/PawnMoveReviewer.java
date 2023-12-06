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
    boolean isSpecificLegalMove(Move move,Color color, Board chessboard) {
        Square from = move.getFrom();
        Square to = move.getTo();
        Square[][] board = chessboard.getChessboard();
        //Color color = from.getPiece().getColor();
        int fromRank = from.getRank() -1;
        int fromRankForSearch = chessboard.getChessboard().length - from.getRank();
        int fromFile = from.getFileVal()-1;

        int toRank = to.getRank() -1;
        //int toRankForSearch = chessboard.getChessboard().length - to.getRank();
        int toFile = to.getFileVal() -1;

        if(!isCheck(color, chessboard)){
            if (board[toRank][toFile].getPiece().isEmpty()){
                if (color == Color.WHITE){
                    if(fromRank == 1 && toRank == 3 && fromFile == toFile){ //Checks if White Pawns first move
                        board[toRank][toFile].setEnPassantPossible(true);
                        return true;
                    } else //Überprüfung auf En Passant
                        if(toRank == fromRank + 1 && fromFile == toFile){
                        return true;
                    } else return board[toRank - 1][toFile].isEnPassantPossible();
                }else{
                    if(fromRank == 6 && toRank ==4 && fromFile == toFile){ //Checks if Black Pawns first move
                        board[toRank][toFile].setEnPassantPossible(true);
                        return true;
                    } else
                        if (toRank == fromRank - 1 && fromFile == toFile){
                        return true;
                    } else return board[toRank + 1][toFile].isEnPassantPossible(); //Überprüfung auf En Passant
                }
            } else if(board[toRank][toFile].getPiece().isPresent()){
                if(color == Color.WHITE){
                    if(toRank == fromRank+1 && toFile == fromFile+1 && board[toRank][toFile].getPiece().get().getColor() == Color.BLACK)return true;
                    else return toRank == fromRank + 1 && toFile == fromFile - 1 && board[toRank][toFile].getPiece().get().getColor() == Color.BLACK;
                }else{
                    if(toRank == fromRank-1 && toFile == fromFile+1 && board[toRank][toFile].getPiece().get().getColor() == Color.WHITE)return true;
                    else return toRank == fromRank - 1 && toFile == fromFile - 1 && board[toRank][toFile].getPiece().get().getColor() == Color.WHITE;
                }
            }else return false;
        }
        return false;
    }
}
