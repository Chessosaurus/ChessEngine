package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Piece;

public class Evaluation implements IEvaluation {


    @Override
    public int evaluateMove(Board board, Color color) {
        int sum = 0;

        for (int rank = 0; rank < board.getChessboard().length; rank++ ){
            for (int file = 0; file < board.getChessboard().length; file++){
                Piece piece = board.getChessboard()[rank][file].getPiece().get();
                if(piece != null){
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
