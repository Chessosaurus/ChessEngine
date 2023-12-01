package chessosaurus.control;

import chessosaurus.base.*;
import chessosaurus.engine.EnemyMoverContext;
import chessosaurus.engine.IEnemyMoverContext;
import chessosaurus.players.Enemy;
import chessosaurus.review.IReviewerContext;
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

    private final IReviewerContext reviewerContext;

    public Game(Color enemyColor, IEnemyMoverContext enemyMoverContext, IReviewerContext reviewerContext) {
        this.reviewerContext = reviewerContext;
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

    public List<Move> getMoves() {
        return new ArrayList<>(this.moves);
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

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
        }
    }

    /**
     * Access the Enemy to get the best move possible.
     * @return best move
     */
    public Move calculateBestEnemyMove() {
        return this.enemy.getBestMove(this.moves, this.chessboard, this);
    }


    public Board deepCloneBoard(){
        Board copiedBoard = new Board();

        final Square[][] result = copiedBoard.getChessboard();

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                if (this.chessboard.getChessboard()[i][j].getPiece().isPresent()){
                    result[i][j].setPiece(new Piece(this.chessboard.getChessboard()[i][j].getPiece().get().getType(), this.chessboard.getChessboard()[i][j].getPiece().get().getColor()));
                }else {
                    result[i][j].setPiece(Optional.empty());
                }

                //result[i][j] = this.chessboard.getChessboard()[i][j] == null? null : new Square(i,j);
                //result[i][j].setPiece(this.chessboard.getChessboard()[i][j].getPiece().isEmpty()?null : this.chessboard.getChessboard()[i][j].getPiece());
            }
        }

        //copiedBoard.setChessboard(result);
        copiedBoard.setMoveCounter(moves.size());

        return copiedBoard;

    }
}
