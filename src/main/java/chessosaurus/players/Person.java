package chessosaurus.players;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
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
            Board newBoard = new Board(board);
            return newBoard;
        }

        return board;
    }
}
