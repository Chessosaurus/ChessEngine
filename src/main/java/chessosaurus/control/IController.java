package chessosaurus.control;

import chessosaurus.base.Board;
import chessosaurus.base.Move;

/**
 * Interface of the main engine so that protocol can access over that the engine.
 * @version 1.0
 * @author Fabian Unger
 */
public interface IController {

    Board initializePlayerVsPlayerGame();
    Board initializePlayerVsBotGame();
    Board executeMove(Move move);

}
