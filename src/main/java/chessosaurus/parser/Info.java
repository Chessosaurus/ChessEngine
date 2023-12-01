package chessosaurus.parser;

import chessosaurus.base.Color;
import chessosaurus.base.Square;

import java.util.Optional;

public class Info {
    private Color nextTurn;
    private Optional<Square> enpassant;


    public Info(Color nextTurn, Optional<Square> enpassant) {
        this.nextTurn = nextTurn;
        this.enpassant = enpassant;
    }

    public Color getNextTurn() {
        return nextTurn;
    }

    public Optional<Square> getEnpassant() {
        return enpassant;
    }
}
