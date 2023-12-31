package chessosaurus.protocol;

import chessosaurus.base.*;

import java.util.Optional;

/**
 * The class MoveParser is responsible for parsing the moves made to a processable object.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */
public class UCIMoveParser implements IMoveParser
  {

    /**
     * Parses the input string containing the moves to a processable move object
     * @param moveInput part of the uci protocoll describing moves made
     * @return move object to further process
     */
    @Override
    public Move fromStringToMove(String moveInput, Board currentBoard)
      {
        Board board = new Board(currentBoard);

        int halfLength = moveInput.length() / 2;
        String moveFrom = moveInput.substring(0, halfLength);
        String moveTo = moveInput.substring(halfLength);

        Square from = new Square(moveFrom.charAt(0),moveFrom.charAt(1));
        from.setPiece(getPieceFromSquare(from, board));
        Square to = new Square(moveTo.charAt(0),moveTo.charAt(1));
        to.setPiece(getPieceFromSquare(to, board));

        return new Move(from, to);
      }

    /**
     * Extract the move as a string
     * @param move move given
     * @return move as string
     */
    @Override
    public String fromMoveToString(Move move){
      String from =  move.getFrom().getFile() + String.valueOf(move.getFrom().getRank());
      String to = move.getTo().getFile() + String.valueOf(move.getTo().getRank());
      return from+to;
    }

    /**
     * Extracts piece from given square
     * @param square given square
     * @param board given board
     * @return extractes piece
     */
    public Optional<Piece> getPieceFromSquare(Square square, Board board){

        int file = square.getFileVal();
        int rank = square.getRank();
        return board.getChessboard()[rank-1][file-1].getPiece();
    }
  }
