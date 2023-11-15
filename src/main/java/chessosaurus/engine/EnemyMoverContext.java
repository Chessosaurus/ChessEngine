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

    /**
     * Depending on the current game situation, different classes are accessed in order to find the best possible move.
     * @param allMoves All previous moves
     * @param currentBoard The current chessboard
     * @param currentColor The color of the enemy
     * @return Best move
     */
    @Override
    public Move getBestMove(List<Move> allMoves, Board currentBoard, Color currentColor) {
        String Fen = "";

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
            String currentBoardFen = new Board().transformBoardToFen(currentBoard);
            // TODO: checken ob Parameter nach Board gebraucht werden oder so belassen werden können(siehe _-_-_0_1).
            if(currentBoard.equals(Color.WHITE)){
                Fen = currentBoardFen+"_w_-_-_0_1";
            } else {
                Fen = currentBoardFen+"_b_-_-_0_1";
            }
            move = enemyMover.getBestMove(Fen,currentBoard);
        }
        if (move == null) {
            MiniMax enemyMover = new MiniMax();
            move = enemyMover.getBestMove();
        }

        return move;
    }

}
