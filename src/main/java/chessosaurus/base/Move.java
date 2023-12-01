package chessosaurus.base;

import java.util.Optional;

/**
 * The Move class is responsible for the representation of a move.
 * For each possible move there is an exclusive constructor.
 * <p>
 * @version 1.0
 * @author Fabian Eilber
 * @author Fabian Unger
 */

public class Move {

    private final Square from;
    private final Square to;

    private final Optional<PieceType> promoted;
    /**
     * Generates a move, where the piece is moved to another square
     * @param from start position
     * @param to end position
     */
    public Move(Square from, Square to){
        this.from = from;
        this.to = to;
        promoted = Optional.empty();
    }
    public Move(Square from, Square to,PieceType promoted){
        this.from = from;
        this.to = to;
        this.promoted = Optional.of(promoted);
    }

    public Square getFrom() {
        return this.from;
    }
    public Square getTo() {
        return this.to;
    }

    public Optional<PieceType> getPromoted() {
        return promoted;
    }
}
