package chessosaurus.players;

import chessosaurus.base.Board;
import chessosaurus.base.Color;

/**
 * Bot class is responsible to create and manage a Person as player and execute his moves.
 * @version 1.0
 * @author Fabian Unger
 */
public class Person implements IPlayer {

    private Color color;

    public Person(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Board move(Board currentBoard) {
        Board board = new Board(currentBoard);

        // if isLegalMove return board after move
        // else
        return board;
    }
}
