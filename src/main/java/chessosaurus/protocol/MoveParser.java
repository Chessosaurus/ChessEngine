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
     * @param board most recent board
     * @return move object to further process
     */
    public Move fromUCIToMove (String moveInput, Board board)
      {
        int halfLength = moveInput.length() / 2;
        String moveFrom = moveInput.substring(0, halfLength);
        String moveTo = moveInput.substring(halfLength);

        Square from = new Square(moveFrom.charAt(0),moveFrom.charAt(1));
        Square to = new Square(moveTo.charAt(0),moveTo.charAt(1));

        Square[][] chessboard = board.getChessboard();

        boolean capture = false;

        if(isCapturing(chessboard, to)){
          capture = true;
        }

        Piece piece = getMovingPiece(chessboard, from);
        PieceType newPieceType = piece.getType();

        Move move = new Move(piece, from, to,capture, newPieceType);

        return move;
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


    /**
     * Determines which Piece is being moved in the given move
     * @param chessboard Square representing the board
     * @param from Square which is being moved from
     * @return piece which is being moved
     */
    private Piece getMovingPiece(Square[][] chessboard, Square from){
      Piece piece = null;
      for(int i=0; i < chessboard.length; i++){
        for(int j=0; j < chessboard.length; j++){
          if(chessboard[i][j].getFile() == from.getFile() && chessboard[i][j].getRank() == from.getRank()){
            piece = chessboard[i][j].getPiece();
          }
        }
      }
      return piece;
    }


    /**
     * Determines wether a move is capturing an enemy piece or not
     * @param chessboard Square representing the board
     * @param to Square which is being moved to
     * @return true or false depending on capturing or not
     */
    public boolean isCapturing(Square[][] chessboard, Square to){
      Piece piece = null;
      for(int i=0; i < chessboard.length; i++){
        for(int j=0; j < chessboard.length; j++){
          if(chessboard[i][j].getFile() == to.getFile() && chessboard[i][j].getRank() == to.getRank()){
            piece = chessboard[i][j].getPiece();
          }
        }
      }

      if(piece != null){
        return true;
      }else{
        return false;
      }

    }
  }
