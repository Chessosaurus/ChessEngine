package chessosaurus.base;

import java.util.Optional;

public class Square {

    private char file; // Spalten
    private int rank; // Zeilen
    private Optional<Piece> piece;
    private boolean enPassantPossible = false;
    private boolean castlingRookPossible = true;

    public Square(int file, int rank) {
        this.file = transformToLiteral(file);
        this.rank = rank;
        this.piece = Optional.empty();
    }
    public Square (char file, int rank){
        this.file = file;
        this.rank = rank;
        this.piece = Optional.empty();
    }

    public Square(char file, char rank) {
        this.file = file;
        this.rank = Character.getNumericValue(rank);
        this.piece = Optional.empty();
    }

    /**
     * Sets the Piece on a Square
     * @param piece to set on Square
     */
    public void setPiece(Piece piece){
        this.piece = Optional.of(piece);
    }
    /**
     * Sets the Piece on a Square
     * @param piece to set on Square
     */
    public void setPiece(Optional<Piece> piece){
        this.piece = piece;
    }

    /**
     * Returns the Piece of Square
     * @return optional of Piece
     */
    public Optional<Piece> getPiece(){
        return this.piece;
    }

    /**
     * Transforms the int value of a row into a literal for the moves
     * @param row int value of row
     * @return literal value of row
     */
    private char transformToLiteral(int row){
        return switch (row) {
            case 1 -> 'a';
            case 2 -> 'b';
            case 3 -> 'c';
            case 4 -> 'd';
            case 5 -> 'e';
            case 6 -> 'f';
            case 7 -> 'g';
            case 8 -> 'h';
            default -> ' ';
        };
    }

    /**
     * Returns the rank
     * @return rank
     */
    public int getRank()
    {
        return rank;
    }

    /**
     * Returns the file
     * @return file
     */
    public char getFile()
    {
        return file;
    }

    /**
     * Returns the value of a file
     * @return int value of file
     */
    public int getFileVal(){

        int intValue;

        switch (file) {
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
     * Sets the enPassant option
     * @param enPassantPossible boolean
     */
    public void setEnPassantPossible(boolean enPassantPossible) {
        this.enPassantPossible = enPassantPossible;
    }

    /**
     * Returns the enPassant information
     * @return enPassantPossibke
     */
    public boolean isEnPassantPossible() {
        return enPassantPossible;
    }

    /**
     * Returns true if the given Field is corresponding to this square
     * @param file to check
     * @param rank to check
     * @return true if square is field you are looking for
     */
    public boolean isField(char file, int rank){
        return this.file == file && this.rank == rank;
    }

    /**
     * Sets the castling option for Rook
     * @param castlingRookPossible boolean
     */
    public void setCastlingRookPossible(boolean castlingRookPossible) {
        this.castlingRookPossible = castlingRookPossible;
    }

    /**
     * Returns the castling option for Rook
     * @return boolean
     */
    public boolean isCastlingRookPossible() {
        return castlingRookPossible;
    }
}
