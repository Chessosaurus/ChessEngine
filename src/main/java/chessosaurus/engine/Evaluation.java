package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Piece;
import chessosaurus.base.Square;

public class Evaluation implements IEvaluation {


    @Override
    public int evaluateMove(Board board, Color color) {
        int sum = 0;
        Square[][] squares = board.getChessboard();

        for (int rank = 0; rank < 8; rank++ ){
            for (int file = 0; file < 8; file++){
                Square square = squares[rank][file];
                if(square.getPiece().isPresent()) {
                    Piece piece = square.getPiece().get();
                    int value = piece.getType().getValue();
                    if(piece.getColor() == color){
                        sum += value;
                    }else {
                        sum -= value;
                    }
                }
            }
        }
        return sum;
    }
}
