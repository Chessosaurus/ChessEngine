package chess.engine.pieces;

/**
 * Die Klasse Knight repräsentiert die Schachfigur Springer.
 *
 * Version: 1.0
 * Autor: Fabian Eilber
 */

public class Knight implements Piece {
    private int value;
    private String name;
    private Color color;

    public Knight(Color color) {
        this.value = 3;  // Der Wert des Springers ist 3
        this.name = "KN";
        this.color = color;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getName(){return name;}

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void move() {
        System.out.println("Springer bewegt sich!");
    }
}

