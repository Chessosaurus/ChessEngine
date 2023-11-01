package chessosaurus.players;

import chessosaurus.base.Board;
import chessosaurus.base.Color;

/**
 * Interface for players of the game.
 * @version 1.0
 * @author Fabian Unger
 */
public interface IPlayer {

    Color getColor();
    Board move(Board currentBoard);

}
