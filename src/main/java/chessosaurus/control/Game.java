package chessosaurus.control;

import chessosaurus.base.*;
import chessosaurus.engine.IEnemyMoverContext;
import chessosaurus.players.Enemy;
import chessosaurus.review.IReviewerContext;

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

    private final IReviewerContext reviewerContext;

    public Game(Color enemyColor, IEnemyMoverContext enemyMoverContext, IReviewerContext reviewerContext) {
        this.reviewerContext = reviewerContext;
        this.chessboard = new Board();
        this.enemy = new Enemy(enemyColor, enemyMoverContext);
        this.moves = new ArrayList<>();
    }

    /**
     * Returns the chessboard
     * @return recent chessboard
     */
    public Board getChessboard() {
        return this.chessboard;
    }

    /**
     * Sets the chessboard
     * @param chessboard recent board
     */
    public void setChessboard(Board chessboard) {
        this.chessboard = chessboard;
    }

    /**
     * Returns the moves made
     * @return all moves made
     */
    public List<Move> getMoves() {
        return new ArrayList<>(this.moves);
    }

    /**
     * Sets the moves made
     * @param moves made
     */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * Returns the information about the enemy
     * @return enemy
     */
    public Enemy getEnemy() {
        return enemy;
    }

    /**
     * Checks the player's move and updates the chessboard accordingly
     * @param move Move of the player
     */
    public void reviewPlayerMove(Move move) {
        boolean isLegal;

        int fromRank = move.getFrom().getRank()-1;
        int fromFile = move.getFrom().getFileVal() - 1;

        int toRank = move.getTo().getRank()-1;
        int toFile = move.getTo().getFileVal() - 1;
        if(move.getFrom().getPiece().isEmpty()){
            isLegal = false;
        }
        else {
            isLegal = this.reviewerContext.isLegalMove(move, this.chessboard);
        }

        if (isLegal) {
            this.chessboard.getChessboard()[toRank][toFile].setPiece(move.getFrom().getPiece().get());
            this.chessboard.getChessboard()[fromRank][fromFile].setPiece(Optional.empty());
        }
        else {
            // TODO: Hier hat Spieler an Frontend verloren
            System.out.println("1-0");
        }
    }

    /**
     * Access the Enemy to get the best move possible.
     * @return best move
     */
    public Move calculateBestEnemyMove() {
        return this.enemy.getBestMove(this.moves, this.chessboard);
    }


}
