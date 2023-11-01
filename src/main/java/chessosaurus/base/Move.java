package chessosaurus.base;

/**
 * The Move class is responsible for the representation of a move.
 * For each possible move there is an exclusive constructor.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */

public class Move {

    private final Square from;
    private final Square to;


    /**
     * Generates a move, where the piece is moved to another square
     * @param from start position
     * @param to end position
     */
    public Move(Square from, Square to){
        this.from = from;
        this.to = to;
    }
}