// *****************************************************************************
// ARBURG GmbH & Co
// -----------------------------------------------------------------------------
// Name:     MoveParser.java
//
// Project:  ALS
//
// Function: 
// -----------------------------------------------------------------------------
// History:
// 31.10.2023 fe created
// -----------------------------------------------------------------------------
// Copyright (C) ARBURG GmbH & Co, 2023
// *****************************************************************************
package chessosaurus.protocol;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.base.Piece;
import chessosaurus.base.Square;

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
     * @param chessboard most recent board
     * @return move object to further process
     */
    public Move fromUCIToMove (String moveInput, Square[][] chessboard)
      {
        Move move = null;

        int halfLength = moveInput.length() / 2;
        String moveFrom = moveInput.substring(0, halfLength);
        String moveTo = moveInput.substring(halfLength);

        Square from = new Square(moveFrom.charAt(0),moveFrom.charAt(1));
        Square to = new Square(moveTo.charAt(0),moveTo.charAt(1));
        boolean capture = false;
        Piece newPiece = getMovingPiece(chessboard, moveFrom);

        move = new Move(newPiece, from, to, capture, newPiece.getType());

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


    private Piece getMovingPiece(Square[][] chessboard, String moveFrom)
    {

      Piece piece = null;

      for(int i=0; i<chessboard.length; i++)
        {
          for (int j=0; j<chessboard.length;j++)
            {
              if(chessboard[i][j].equalsFrom(moveFrom)){
                piece = chessboard[i][j].getPiece();
              }
            }
        }
      return piece;
    }
  }
