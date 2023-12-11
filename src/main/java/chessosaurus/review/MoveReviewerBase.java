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
            if(isSpecificLegalMove(move,from.getPiece().get().getColor() ,chessboard)){
                for(int x = 0; x < 8; x++){
                    for(int y = 0; y < 8; y++){
                        chessboard.getChessboard()[x][y].setEnPassantPossible(false);
                    }
                }
                Board copiedBoard = chessboard.deepCloneBoard();
                if(copiedBoard.getChessboard()[move.getFrom().getRank()-1][ move.getFrom().getFileVal()-1].getPiece().isPresent()){

                copiedBoard.makeMove(move);
                    if(!isCheck(copiedBoard.getChessboard()[move.getTo().getRank()-1][move.getTo().getFileVal()-1].getPiece().get().getColor(), copiedBoard)){
                        return true;
                    } else return false;
                } else return false;
            } else return false;
        } else {
            if(to.getPiece().get().getColor() != from.getPiece().get().getColor()){
                if(isSpecificLegalMove(move,from.getPiece().get().getColor(),chessboard)){
                    for(int x = 0; x < 8; x++){
                        for(int y = 0; y < 8; y++){
                            chessboard.getChessboard()[x][y].setEnPassantPossible(false);
                        }
                    }
                    Board copiedBoard = chessboard.deepCloneBoard();
                    if(copiedBoard.getChessboard()[move.getFrom().getRank()-1][move.getFrom().getFileVal()-1].getPiece().isPresent()){

                        copiedBoard.makeMove(move);
                        if(!isCheck(copiedBoard.getChessboard()[move.getTo().getRank()-1][move.getTo().getFileVal()-1].getPiece().get().getColor(), copiedBoard)){
                            return true;
                        } else return false;
                    } else return false;
                }else return false;
            }else return false;
        }
    }

    /**
     * Checks if the king is in check.
     *
     * @param color Is used to get the current Player color.
     * @param chessboard The chessboard of the current situation.
     * @return {@code true}, if the king is in a check, else {@code false}.
     */
    public boolean isCheck(Color color, Board chessboard){
        Square[][] board = chessboard.getChessboard();


        int kingRank = 0;
        int kingFile = 0;

        //Retrieves current players king position
        for(int rank = 0; rank<8; rank++){
            for(int file = 0; file<8; file++){
                if(board[rank][file].getPiece().isPresent()){
                    if(board[rank][file].getPiece().get().getColor() == color && board[rank][file].getPiece().get().getType() == PieceType.KING){
                        kingRank = rank;
                        kingFile = file;
                    }
                }
            }
        }

        for(int i = 1; i<=8; i++){

            //Checks whether the king is attack diagonally
            if(isValidPosition(kingRank+i, kingFile+i)) {
                if (board[kingRank + i][kingFile + i].getPiece().isPresent()) {
                    if (board[kingRank + i][kingFile + i].getPiece().get().getColor() != color) {
                        switch (board[kingRank + i][kingFile + i].getPiece().get().getType()) {
                            case PAWN:
                                if (i == 1 && color.equals(Color.WHITE)) return true;
                                break;
                            case BISHOP:
                            case QUEEN:
                                return true;
                            default:
                                break;
                        }
                    }
                }
            }
            if(isValidPosition(kingRank+i, kingFile-i)) {
                if (board[kingRank + i][kingFile - i].getPiece().isPresent()) {
                    if (board[kingRank + i][kingFile - i].getPiece().get().getColor() != color) {
                        switch (board[kingRank + i][kingFile - i].getPiece().get().getType()) {
                            case PAWN:
                                if (i == 1 && color.equals(Color.WHITE)) return true;
                                break;
                            case BISHOP:
                            case QUEEN:
                                return true;
                            default:
                                break;
                        }
                    }
                }
            }
            if(isValidPosition(kingRank-i, kingFile+i)) {
                if (board[kingRank - i][kingFile + i].getPiece().isPresent()) {
                    if (board[kingRank - i][kingFile + i].getPiece().get().getColor() != color) {
                        switch (board[kingRank - i][kingFile + i].getPiece().get().getType()) {
                            case PAWN:
                                if (i == 1 && color == Color.BLACK) return true;
                                break;
                            case BISHOP:
                            case QUEEN:
                                return true;
                            default:
                                break;
                        }
                    }
                }
            }
            if(isValidPosition(kingRank-i, kingFile-i)) {
                if (board[kingRank - i][kingFile - i].getPiece().isPresent()) {
                    if (board[kingRank - i][kingFile - i].getPiece().get().getColor() != color) {
                        switch (board[kingRank - i][kingFile - i].getPiece().get().getType()) {
                            case PAWN:
                                if (i == 1 && color == Color.BLACK) return true;
                                break;
                            case BISHOP:
                            case QUEEN:
                                return true;
                            default:
                                break;
                        }
                    }
                }
            }
            //Ermittelt ob König vertikal oder horizontal angegriffen wird.
            if(isValidPosition(kingRank+i, kingFile)) {
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
            }
            if(isValidPosition(kingRank-i, kingFile)) {
                if (board[kingRank - i][kingFile].getPiece().isPresent()) {
                    if (board[kingRank - i][kingFile].getPiece().get().getColor() != color) {
                        switch (board[kingRank - i][kingFile].getPiece().get().getType()) {
                            case ROOK:
                            case QUEEN:
                                return true;
                            default:
                                break;
                        }
                    }
                }
            }
            if(isValidPosition(kingRank, kingFile+i)) {
                if (board[kingRank][kingFile + i].getPiece().isPresent()) {
                    if (board[kingRank][kingFile + i].getPiece().get().getColor() != color) {
                        switch (board[kingRank][kingFile + i].getPiece().get().getType()) {
                            case ROOK:
                            case QUEEN:
                                return true;
                            default:
                                break;
                        }
                    }
                }
            }
            if(isValidPosition(kingRank, kingFile-i)) {
                if (board[kingRank][kingFile - i].getPiece().isPresent()) {
                    if (board[kingRank][kingFile - i].getPiece().get().getColor() != color) {
                        switch (board[kingRank][kingFile - i].getPiece().get().getType()) {
                            case ROOK:
                            case QUEEN:
                                return true;
                            default:
                                break;
                        }
                    }
                }
            }
        }

        if(isValidPosition(kingRank+1, kingFile+2)) {
            if (board[kingRank + 1][kingFile + 2].getPiece().isPresent()) {
                if (board[kingRank + 1][kingFile + 2].getPiece().get().getColor() != color) {
                    if (board[kingRank + 1][kingFile + 2].getPiece().get().getType() == PieceType.KNIGHT) return true;
                }
            }
        }
        if(isValidPosition(kingRank-1, kingFile+2)) {
            if (board[kingRank - 1][kingFile + 2].getPiece().isPresent()) {
                if (board[kingRank - 1][kingFile + 2].getPiece().get().getColor() != color) {
                    if (board[kingRank - 1][kingFile + 2].getPiece().get().getType() == PieceType.KNIGHT) return true;
                }
            }
        }
        if(isValidPosition(kingRank+1, kingFile-2)) {
            if (board[kingRank + 1][kingFile - 2].getPiece().isPresent()) {
                if (board[kingRank + 1][kingFile - 2].getPiece().get().getColor() != color) {
                    if (board[kingRank + 1][kingFile - 2].getPiece().get().getType() == PieceType.KNIGHT) return true;
                }
            }
        }
        if(isValidPosition(kingRank-1, kingFile-2)) {
            if (board[kingRank - 1][kingFile - 2].getPiece().isPresent()) {
                if (board[kingRank - 1][kingFile - 2].getPiece().get().getColor() != color) {
                    return board[kingRank - 1][kingFile - 2].getPiece().get().getType() == PieceType.KNIGHT;
                }
            }
        }

        return false;
    }

    /**
     * Prevents index out of bound array
     * @param file given file
     * @param rank given rank
     * @return True if it is a valid position
     */
    private boolean isValidPosition(int file, int rank){
        return file>=0 && file<8 && rank>=0 && rank<8;
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
