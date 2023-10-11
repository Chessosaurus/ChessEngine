package chess.engine.pieces;

/**
 * Die Klasse King repräsentiert die Schachfigur König.
 *
 * Version: 1.0
 * Autor: Fabian Eilber
 */

public class King implements Piece {
    private int value;
    private Color color;

    public King(Color color) {
        this.value = 10;  // Wert des Königs ist 10
        this.color = color;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void move() {
        System.out.println("König bewegt sich!");
    }
}





