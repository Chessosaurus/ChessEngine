package chessosaurus.base;

public class Square {

    private int file;
    private char rank;
    private Piece piece;

    public Square(int file, int rank) {
        this.file = file;
        this.rank = transformToLiteral(rank);
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece(){
        return this.piece;
    }

    private char transformToLiteral(int row){
        return switch (row) {
            case 0 -> 'a';
            case 1 -> 'b';
            case 2 -> 'c';
            case 3 -> 'd';
            case 4 -> 'e';
            case 5 -> 'f';
            case 6 -> 'g';
            case 7 -> 'h';
            default -> ' ';
        };
    }

}
