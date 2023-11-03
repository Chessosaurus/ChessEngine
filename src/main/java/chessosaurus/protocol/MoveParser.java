package chessosaurus.protocol;

import chessosaurus.base.*;

/**
 * The class MoveParser is responsible for parsing the moves made to a processable object.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */
public class MoveParser
  {

    /**
     * Parses the input string containing the moves to a processable move object
     * @param moveInput part of the uci protocoll describing moves made
     * @return move object to further process
     */
    public Move fromUCIToMove (String moveInput, Board board)
      {
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
     * Parses the given move Object back to uci protocol notation.
     * @param move move object
     * @return transformed move object
     */
    public String fromMoveToUCI(Move move)
      {
        return "move made";
      }

    public Piece getPieceFromSquare(Square square, Board board){
      Piece piece = null;
      Square[][] chessboard = board.getChessboard();
      for (int i = 0; i < chessboard.length; i++) {
        for (int j = 0; j < chessboard.length; j++) {
          if(chessboard[i][j].getRank() == square.getRank() && chessboard[i][j].getFile() == square.getFile()){
            piece = chessboard[i][j].getPiece();
          }
        }
      }

      return piece;
    }
  }
