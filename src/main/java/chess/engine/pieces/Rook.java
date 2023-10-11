package chess.engine.pieces;

/**
 * Die Klasse Rook repräsentiert die Schachfigur Turm.
 *
 * Version: 1.0
 * Autor: Fabian Eilber
 */

public class Rook implements Piece {
    private int value;
    private Color color;

    public Rook(Color color) {
        this.value = 5;  // Der Wert des Turmes ist 5
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
        System.out.println("Turm bewegt sich!");
    }
}

