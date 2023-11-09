package chessosaurus.review;

import chessosaurus.base.*;
/**
 * The MoveReviewerBase class is the Super-Class of the specific PieceReviewers.
 * <p>
 * @version 1.0
 * @author Tobias Hahn
 */
abstract class MoveReviewerBase implements IMoveReviewer{

    /**
     * Checks if a piece of the same color is on the destination square.
     * If there's no piece of the same color on the destination square the method isSpecificLegalMove(Move move, Board chessboard) will be called.
     *
     * @param move The move to be checked.
     * @param chessboard The chessboard on which the move is made.
     * @return {@code true}, if the move was legal, else {@code false}.
     */
    @Override
    public boolean isLegalMove(Move move, Board chessboard) {
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
            }else return false;
        }
    }

    /**
     * Checks if the king is in check.
     *
     * @param move Is used to get the current Player color.
     * @param chessboard The chessboard of the current situation.
     * @return {@code true}, if the king is in a check, else {@code false}.
     */
    public boolean isCheck(Move move, Board chessboard){
        Color color = move.getFrom().getPiece().get().getColor();
        Square[][] board = chessboard.getChessboard();
        Square from = move.getFrom();
        Square to = move.getTo();


        int kingFile = 0;
        int kingRank = 0;

        //Ermittelt die Position des Königs des aktiven Spielers
        for(int file = 0; file<8; file++){
            for(int rank = 0; rank<8; rank++){
                if(board[rank][file].getPiece().isPresent()){
                    if(board[rank][file].getPiece().get().getColor() == color && board[rank][file].getPiece().get().getType() == PieceType.KING){
                        kingFile = file;
                        kingRank = rank;
                    }
                }
            }
        }


        for(int i = 1; i<=8; i++){

            //Ermittelt ob König diagonal angegriffen wird
            if (board[kingRank + i][kingFile + i].getPiece().isPresent()){
                if(board[kingRank+i][kingFile+i].getPiece().get().getColor() != color){
                    switch(board[kingRank+i][kingFile+i].getPiece().get().getType()){
                        case PAWN:
                            if(i==1 && color == Color.WHITE) return true;
                            break;
                        case BISHOP:
                        case QUEEN:
                            return true;
                        default:
                            break;
                    }
                }
            }
            if (board[kingRank - i][kingFile + i].getPiece().isPresent()){
                if(board[kingRank-i][kingFile+i].getPiece().get().getColor() != color){
                    switch(board[kingRank-i][kingFile+i].getPiece().get().getType()){
                        case PAWN:
                            if(i==1 && color == Color.WHITE) return true;
                            break;
                        case BISHOP:
                        case QUEEN:
                            return true;
                        default:
                            break;
                    }
                }
            }
            if (board[kingRank + i][kingFile - i].getPiece().isPresent()){
                if(board[kingRank+i][kingFile-i].getPiece().get().getColor() != color){
                    switch(board[kingRank+i][kingFile-i].getPiece().get().getType()){
                        case PAWN:
                            if(i==1 && color == Color.BLACK) return true;
                            break;
                        case BISHOP:
                        case QUEEN:
                            return true;
                        default:
                            break;
                    }
                }
            }
            if (board[kingRank - i][kingFile - i].getPiece().isPresent()){
                if(board[kingRank-i][kingFile-i].getPiece().get().getColor() != color){
                    switch(board[kingRank-i][kingFile-i].getPiece().get().getType()){
                        case PAWN:
                            if(i==1 && color == Color.BLACK) return true;
                            break;
                        case BISHOP:
                        case QUEEN:
                            return true;
                        default:
                            break;
                    }
                }
            }

            //Ermittelt ob König vertikal oder horizontal angegriffen wird.
            if(board[kingRank][kingFile+i].getPiece().isPresent()){
                if(board[kingRank][kingFile+i].getPiece().get().getColor() != color){
                    switch(board[kingRank][kingFile+i].getPiece().get().getType()){
                        case ROOK:
                        case QUEEN:
                            return true;
                        default:
                            break;
                    }
                }
            }
            if(board[kingRank][kingFile-i].getPiece().isPresent()){
                if(board[kingRank][kingFile-i].getPiece().get().getColor() != color){
                    switch(board[kingRank][kingFile-i].getPiece().get().getType()){
                        case ROOK:
                        case QUEEN:
                            return true;
                        default:
                            break;
                    }
                }
            }
            if(board[kingRank+i][kingFile].getPiece().isPresent()){
                if(board[kingRank+i][kingFile].getPiece().get().getColor() != color){
                    switch(board[kingRank+i][kingFile].getPiece().get().getType()){
                        case ROOK:
                        case QUEEN:
                            return true;
                        default:
                            break;
                    }
                }
            }
            if(board[kingRank-i][kingFile].getPiece().isPresent()){
                if(board[kingRank-i][kingFile].getPiece().get().getColor() != color){
                    switch(board[kingRank-i][kingFile].getPiece().get().getType()){
                        case ROOK:
                        case QUEEN:
                            return true;
                        default:
                            break;
                    }
                }
            }
        }

        if(board[kingRank+2][kingFile+1].getPiece().isPresent()){
            if(board[kingRank+2][kingFile+1].getPiece().get().getColor() != color){
                if(board[kingRank+2][kingFile+1].getPiece().get().getType() == PieceType.KNIGHT) return true;
            }
        }
        if(board[kingRank+2][kingFile-1].getPiece().isPresent()){
            if(board[kingRank+2][kingFile-1].getPiece().get().getColor() != color){
                if(board[kingRank+2][kingFile-1].getPiece().get().getType() == PieceType.KNIGHT) return true;
            }
        }
        if(board[kingRank-2][kingFile+1].getPiece().isPresent()){
            if(board[kingRank-2][kingFile+1].getPiece().get().getColor() != color){
                if(board[kingRank-2][kingFile+1].getPiece().get().getType() == PieceType.KNIGHT) return true;
            }
        }
        if(board[kingRank-2][kingFile-1].getPiece().isPresent()){
            if(board[kingRank-2][kingFile-1].getPiece().get().getColor() != color){
                if(board[kingRank-2][kingFile-1].getPiece().get().getType() == PieceType.KNIGHT) return true;
            }
        }

        return false;
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

    /**
     * Checks whether a particular move is legal on the chessboard.
     * Each Piece has an own class where the move gets reviewed.
     *
     * @param move The move to be checked.
     * @param chessboard The chessboard on which the move is made.
     * @return {@code true}, if the move was legal, else {@code false}.
     */
    abstract boolean isSpecificLegalMove(Move move,Color color, Board chessboard);
}
