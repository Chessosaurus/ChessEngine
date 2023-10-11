package chess.engine.pieces;

/**
 * Das Interface Piece repräsentiert eine Schachfigur
 *
 * Version: 1.0
 * Autor: Fabian Eilber
 */

public interface Piece {
    int getValue();
    Color getColor();
    void move();
}

