package chessosaurus.base;

import java.util.Optional;

public class Square {

    private char file; // Spalten
    private int rank; // Zeilen
    private Optional<Piece> piece;

    public Square(int file, int rank) {
        this.file = transformToLiteral(file);
        this.rank = rank;
        this.piece = Optional.empty();
    }

    public Square(char file, char rank) {
        this.file = file;
        this.rank = Character.getNumericValue(rank);
        this.piece = Optional.empty();
    }

    public void setPiece(Piece piece){
        this.piece = Optional.of(piece);
    }
    public void setPiece(Optional<Piece> piece){
        this.piece = piece;
    }

    public Optional<Piece> getPiece(){
        return this.piece;
    }

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

    public int getRank()
    {
        return rank;
    }

    public char getFile()
    {
        return file;
    }

    public boolean equalsFrom(String from){
        String toCheckOn = rank + String.valueOf(file);

        if(from.equals(toCheckOn))
        {
            return  true;
        }
        else
        {
            return false;
        }
    }
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
}
