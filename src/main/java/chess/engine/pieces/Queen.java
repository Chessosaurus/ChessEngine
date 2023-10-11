package chess.engine.pieces;

/**
 * Die Klasse Queen repräsentiert die Schachfigur Dame.
 *
 * Version: 1.0
 * Autor: Fabian Eilber
 */

public class Queen implements Piece {
    private int value;
    private Color color;

    public Queen(Color color) {
        this.value = 9;  // Wert der Dame ist 9
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
        System.out.println("Dame bewegt sich!");
    }
}