package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.control.Game;
import chessosaurus.persistence.IEndgameReader;
import chessosaurus.persistence.IOpeninggameReader;

import java.util.List;

/**
 * Depending on the current state of the chessboard, accesses the respective classes to determine the currently best move.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public class EnemyMoverContext implements IEnemyMoverContext {

    private final IOpeninggameReader openinggameReader;
    private final IEndgameReader endgameReader;


    public EnemyMoverContext(IOpeninggameReader openinggameReader,
                             IEndgameReader endgameReader) {
        this.openinggameReader = openinggameReader;
        this.endgameReader = endgameReader;
    }

    public Move getBestMove(List<Move> allMoves, Board currentBoard, Color currentColor) {

        Move move = null;

        int movesCount = allMoves.size();

        int pieceCount = currentBoard.getPieceCount(currentBoard);

        if (movesCount < 16 && movesCount!=0) {
            Move lastMove = allMoves.get(movesCount-1);
            OpeningMoveSelector enemyMover = new OpeningMoveSelector(this.openinggameReader);
            move = enemyMover.getBestMove(currentBoard, lastMove);
        }
        if (move == null && pieceCount < 8) {
            EndMoveSelector enemyMover = new EndMoveSelector(this.endgameReader);
            //TODO BestMove benötigt FEN-Notation von aktuellem Board, in der auch die Farbe dargestellt ist. => 4k3/6KP/8/8/8/8/7p/8_w_-_-_0_1
            move = enemyMover.getBestMove();
        }
        if (move == null) {
            MiniMax enemyMover = new MiniMax();
            move = enemyMover.getBestMove();
        }

        return move;
    }

}
