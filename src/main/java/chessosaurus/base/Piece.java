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

    /**
     * Sets the type of Piece
     * @param type of piece
     */
    public void setType(PieceType type) {
        this.type = type;
    }

    /**
     * Returns type of Piece
     * @return type
     */
    public PieceType getType() {
        return type;
    }

    /**
     * Sets the color of Piece
     * @param color of piece
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Returns the color of Piece
     * @return color
     */
    public Color getColor() {
        return color;
    }

}
