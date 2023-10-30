package chessosaurus.base;

/**
 * The Move class is responsible for the representation of a move.
 * For each possible move there is an exclusive constructor.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */

public class Move {

    private Piece piece;
    private Square from;
    private Square to;
    private boolean capture;
    private PieceType newPieceType;


    /**
     * Generates a move, where the piece is only moved to another square
     * @param piece moved piece
     * @param from start position
     * @param to end position
     */
    public Move(Piece piece, Square from, Square to){
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.capture = false;
        this.newPieceType = null;
    }

    /**
     * Generates a move, where the piece is moved to another square, may cause a capture, may cause a transformation
     * @param piece moved piece
     * @param from start position
     * @param to end position
     * @param capture is a piece of the enemy going to be captured
     * @param newPieceType new piece type to replace the old one
     */
    public Move(Piece piece, Square from, Square to, boolean capture, PieceType newPieceType){
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.capture = capture;
        this.newPieceType = newPieceType;
    }

    /**
     * Generates a move, where the piece is moved to another square => capture
     * @param piece moved piece
     * @param from start position
     * @param to end position
     * @param capture is a piece of the enemy going to be captured
     */
    public Move(Piece piece, Square from, Square to, boolean capture){
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.capture = capture;
        this.newPieceType = null;
    }

    /**
     * Generates a move, where the piece is moved to the enemy baseline => transformation
     * @param piece moved piece
     * @param from start position
     * @param to end position
     * @param newPieceType new piece type to replace the old one
     */
    public Move(Piece piece, Square from, Square to, PieceType newPieceType){
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.capture = false;
        this.newPieceType = newPieceType;
    }
}
