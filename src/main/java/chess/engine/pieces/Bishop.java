package chess.engine.pieces;

/**
 * Die Klasse Bishop repräsentiert die Schachfigur Löufer.
 *
 * Version: 1.0
 * Autor: Fabian Eilber
 */

public class Bishop implements Piece {
    private int value;
    private Color color;

    public Bishop(Color color) {
        this.value = 3;  // Der Wert des Läufers ist 3
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
        System.out.println("Läufer bewegt sich!");
    }
}

