package chessosaurus.control;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.engine.EnemyMoverContext;
import chessosaurus.engine.IEnemyMoverContext;
import chessosaurus.players.Enemy;
import chessosaurus.review.ReviewerContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Class to manage the game by managing the main board and the players.
 * @version 1.0
 * @author Fabian Unger
 */
public class Game {

    private Board chessboard;
    private final Enemy enemy;
    private List<Move> moves;

    public Game(Color enemyColor, IEnemyMoverContext enemyMoverContext) {
        this.chessboard = new Board();
        this.enemy = new Enemy(enemyColor, enemyMoverContext);
        this.moves = new ArrayList<>();
    }

    public Board getChessboard() {
        return this.chessboard;
    }

    public void setChessboard(Board chessboard) {
        this.chessboard = chessboard;
    }

    public void reviewPlayerMove(Move move) {
        if(move.getFrom().getPiece().isEmpty()){
            throw new IllegalArgumentException("The from field doesnt have a piece on it");
        }

        ReviewerContext reviewerContext = new ReviewerContext();

        if (reviewerContext.isLegalMove(move, this.chessboard)) {
            this.chessboard.getChessboard()[move.getTo().getRankVal() - 1][move.getTo().getFile() - 1].setPiece(move.getFrom().getPiece().get());
            this.chessboard.getChessboard()[move.getFrom().getRankVal() - 1][move.getFrom().getFile() - 1].setPiece(Optional.empty());
        }
        else {
            // TODO: Hier hat Spieler an Frontend verloren
        }
    }

    public Move calculateBestEnemyMove() {
        return this.enemy.getBestMove(this.moves, this.chessboard);
    }

    public List<Move> getMoves() {
        return new ArrayList<>(this.moves);
    }

}
