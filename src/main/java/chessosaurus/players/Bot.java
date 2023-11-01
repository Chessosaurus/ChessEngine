package chessosaurus.players;

import chessosaurus.base.Board;
import chessosaurus.base.Color;

/**
 * Bot class is responsible to create and manage a Computer enemy and execute his moves.
 * @version 1.0
 * @author Fabian Unger
 */
public class Bot implements IPlayer {

    private Color color;

    public Bot(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Board move(Board currentBoard) {
        Board board = new Board(currentBoard);

        // make move

        return board; // TODO change to new Board
    }
}
