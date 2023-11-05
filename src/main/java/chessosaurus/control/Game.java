package chessosaurus.control;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.players.IPlayer;


/**
 * Class to manage the game by managing the main board and the players.
 * @version 1.0
 * @author Fabian Unger
 */
public class Game {

    private Board chessboard;
    private IPlayer whitePlayer;
    private IPlayer blackPlayer;

    public Game(IPlayer whitePlayer, IPlayer blackPlayer) {
        this.chessboard = new Board();
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
    }

    public Board getChessboard() {
        return this.chessboard;
    }

    public void setChessboard(Board chessboard) {
        this.chessboard = chessboard;
    }

    public void executeMove(Move move) {
        Color color = move.getFrom().getPiece().getColor();

        Board boardAfterMove;
        if (color.equals(Color.WHITE)) {
            boardAfterMove = whitePlayer.move(move, this.chessboard);
        } else {
            boardAfterMove = blackPlayer.move(move, this.chessboard);
        }
        this.chessboard = boardAfterMove;
    }

    public void setBlackPlayer(IPlayer blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public void setWhitePlayer(IPlayer whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public IPlayer getBlackPlayer() {
        return blackPlayer;
    }

    public IPlayer getWhitePlayer() {
        return whitePlayer;
    }
}
