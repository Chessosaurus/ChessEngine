package chessosaurus.engine;

import chessosaurus.base.Move;

public class EvaluatedMove implements Comparable<EvaluatedMove>{
    private Move move;

    private int value;

    public EvaluatedMove(Move move, int value){
        this.move = move;
        this.value = value;
    }

    public Move getMove() {
        return move;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(EvaluatedMove evaluatedMove) {
        return this.value - evaluatedMove.getValue();
    }
}
