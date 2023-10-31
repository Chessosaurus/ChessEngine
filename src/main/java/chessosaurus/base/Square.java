package chessosaurus.base;

public class Square {

    private int file;
    private char rank;
    private Piece piece;

    public Square(int rank, int file) {
        this.file = file;
        this.rank = transformToLiteral(rank);
    }

    public Square(char rank, char file) {
    this.file = Character.getNumericValue(file);
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

    public char getRank()
    {
        return rank;
    }

    public int getFile()
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
}
