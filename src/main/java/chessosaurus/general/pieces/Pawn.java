package chessosaurus.general.pieces;

/**
 * Die Klasse Pawn repräsentiert die Schachfigur Bauer.
 *
 * Version: 1.0
 * Autor: Fabian Eilber
 */

public class Pawn implements Piece {
    private int value;
    private String name;
    private Color color;

    public Pawn(Color color) {
        this.value = 1;  // Der Wert des Bauern ist 1
        this.name = "P";
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
        System.out.println("Bauer bewegt sich!");
    }
}
