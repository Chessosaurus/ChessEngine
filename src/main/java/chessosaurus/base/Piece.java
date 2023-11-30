package chessosaurus.base;

public class Piece {
    private PieceType type;
    private Color color;

    public Piece(){

    }

    public Piece(PieceType type, Color color) {
        this.type = type;
        this.color = color;
    }


    public void setType(PieceType type) {
        this.type = type;
    }

    public PieceType getType() {
        return type;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
