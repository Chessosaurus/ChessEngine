package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;

public interface IEvaluation {

    int bestValue = Integer.MAX_VALUE;

    int badestValue = Integer.MIN_VALUE;

    int balancedValue = 0;

    int mateValue = bestValue / 2 ;



    int evaluateMove(Board board, Color color);

}
