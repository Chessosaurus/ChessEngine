package chessosaurus.review;

import chessosaurus.base.*;

/**
 * The KingMoveReviewer class is responsible for review a king's move.
 * <p>
 * @version 1.0
 * @author Tobias Hahn
 */

public class KingMoveReviewer extends MoveReviewerBase {

    @Override
    public boolean isLegalMove(Move move, Board chessboard){
        Square from = move.getFrom();
        Square to = move.getTo();

        if(from.getPiece().isEmpty()){
            throw new IllegalArgumentException("From square is empty");
        }
        if(to.getPiece().isEmpty()){
            return isSpecificLegalMove(move,from.getPiece().get().getColor() ,chessboard);
        } else {
            if(to.getPiece().get().getColor() != from.getPiece().get().getColor()){
                return isSpecificLegalMove(move,from.getPiece().get().getColor(),chessboard);
            }else if(to.getPiece().get().getColor().equals(from.getPiece().get().getColor()) && to.getPiece().get().getType().equals(PieceType.ROOK)){
                return isSpecificLegalMove(move,from.getPiece().get().getColor() ,chessboard);
            }else return false;
        }
    }

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
        int fromRank = from.getRank();
        int fromFile = from.getFile()-1; //hier war get FileVal()

        int toRank = to.getRank();
        int toFile = to.getFile()-1; //hier war get FileVal()
        boolean wayClear = true;

        if(toRank == fromRank+1 || toRank == fromRank-1){
            if(toFile == fromFile+1 || toFile == fromFile-1){
                chessboard.setCastlingImpossible(color);
                return true;
            }
        }
        if(toRank == fromRank && (toFile == fromFile+1 || toFile == fromFile-1)){
            chessboard.setCastlingImpossible(color);
            return true;
        }
        if (toFile == fromFile && (toRank == fromRank+1 || toRank == fromRank-1)){
            chessboard.setCastlingImpossible(color);
            return true;
        }

        //Überprüfung der Rochade
        if(!isCheck(move, chessboard) && chessboard.isCastlingPossible(color)){
            if(toRank==7 && toFile==0 || toRank==0 && toFile ==7){/*Hier bedingung ob nach links oder nach rechts. Hier zuerst nach rechts überprüft*/
                for (int i = 1; i < 3; i++) {
                    if(color.equals(Color.WHITE)){
                        if(board[0][4+i].getPiece().isPresent()) wayClear = false;
                    } else {
                        if(board[7][4-i].getPiece().isPresent()) wayClear = false;
                    }
                }
                if (wayClear) {
                    if(color.equals(Color.WHITE)){
                        if(board[0][7].getPiece().isPresent()){
                            if(board[0][7].getPiece().get().getType().equals(PieceType.ROOK)){
                                return board[0][7].getPiece().get().getColor().equals(Color.WHITE);
                            }
                        }
                    } else {
                        if(board[7][7].getPiece().isPresent()){
                            if(board[7][7].getPiece().get().getType().equals(PieceType.ROOK)){
                                return board[7][7].getPiece().get().getColor().equals(Color.BLACK);
                            }
                        }
                    }
                }
            }
            else{
                for (int i = 1; i < 4; i++) {
                    if(color.equals(Color.WHITE)){
                        if(board[0][4-i].getPiece().isPresent()) wayClear = false;
                    } else {
                        if(board[7][4+i].getPiece().isPresent()) wayClear = false;
                    }
                }
                if(wayClear){
                    if(color.equals(Color.WHITE)){
                        if(board[0][0].getPiece().isPresent()){
                            if(board[0][0].getPiece().get().getType().equals(PieceType.ROOK)){
                                return board[0][0].getPiece().get().getColor().equals(Color.WHITE);
                            }
                        }
                    }else {
                        if(board[7][0].getPiece().isPresent()){
                            if(board[7][0].getPiece().get().getType().equals(PieceType.ROOK)){
                                return board[7][0].getPiece().get().getColor().equals(Color.BLACK);
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
