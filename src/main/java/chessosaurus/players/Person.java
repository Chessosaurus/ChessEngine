package chessosaurus.players;

import chessosaurus.base.*;
import chessosaurus.review.ReviewerContext;

/**
 * Bot class is responsible to create and manage a Person as player and execute his moves.
 * @version 1.0
 * @author Fabian Unger
 */
public class Person implements IPlayer {

    private Color color;

    public Person(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Board move(Move move, Board currentBoard) {
        Board board = new Board(currentBoard);

        ReviewerContext reviewerContext = new ReviewerContext();
        boolean isLegal = reviewerContext.isLegalMove(move, board);

        if (isLegal) {
            // Move ausfuehren und Board aendern
            Board newBoard = new Board();
            Square[][] oldBoard = currentBoard.getChessboard();
            Piece piece = move.getFrom().getPiece();

            //set old field to null
            for (int i = 0; i < oldBoard.length; i++) {
                for (int j = 0; j < oldBoard.length; j++) {
                    if(oldBoard[i][j].getRank() == move.getFrom().getRank() && oldBoard[i][j].getFile() == move.getFrom().getFile()){
                        oldBoard[i][j].setPiece(null);
                    }
                }
            }

            //set piece to new field
            for (int i = 0; i < oldBoard.length; i++) {
                for (int j = 0; j < oldBoard.length; j++) {
                    if(oldBoard[i][j].getRank() == move.getTo().getRank() && oldBoard[i][j].getFile() == move.getTo().getFile()){
                        oldBoard[i][j].setPiece(piece);
                    }
                }
            }

            newBoard.setChessboard(oldBoard);

            return newBoard;
        }

        return board;
    }
}
