package chessosaurus.players;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.engine.EnemyMoverContext;
import chessosaurus.engine.IEnemyMoverContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Bot class is responsible to create and manage a Computer enemy and execute his moves.
 * @version 1.0
 * @author Fabian Unger
 */
public class Enemy {

    private Color color;
    private final IEnemyMoverContext enemyMoverContext;

    public Enemy(Color color, IEnemyMoverContext enemyMoverContext) {
        this.color = color;
        this.enemyMoverContext = enemyMoverContext;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color){this.color = color;}

    /**
     * Accesses the IEnemyMoverContext interface to find out the best possible move.
     * @param allMoves All moves which were made.
     * @param currentBoard The current chessboard.
     * @return best possible move
     */
    public Move getBestMove(List<Move> allMoves, Board currentBoard) {
        Board board = new Board(currentBoard);
        List<Move> moves = new ArrayList<>(allMoves);

        Move bestMove = this.enemyMoverContext.getBestMove(moves, board, this.color);

        return bestMove;
    }
}
