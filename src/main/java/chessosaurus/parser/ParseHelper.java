package chessosaurus.parser;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;

import java.util.List;

public class ParseHelper {
    Board board;
    List<Move> moves;
    Color next;

    public ParseHelper(Board board, List<Move> moves, Color next) {
        this.board = board;
        this.moves = moves;
        this.next = next;
    }

    public Board getBoard() {
        return board;
    }

    public Color getNext() {
        return next;
    }

    public List<Move> getMoves() {
        return moves;
    }
}
