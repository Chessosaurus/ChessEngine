package chessosaurus.engine;

import chessosaurus.base.Move;

public class EvaluatedMove implements Comparable<EvaluatedMove>{
    private Move move;

    private int value;

    public EvaluatedMove(Move move, int value){
        this.move = move;
        this.value = value;
    }

    /**
     * Returns the evaluated move
     * @return move
     */
    public Move getMove() {
        return move;
    }

    /**
     * Returns the value of the evaluated move
     * @return int value
     */
    public int getValue() {
        return value;
    }

    /**
     * Compares the recent value with another one
     * @param evaluatedMove the object to be compared.
     * @return int value
     */
    @Override
    public int compareTo(EvaluatedMove evaluatedMove) {
        return this.value - evaluatedMove.getValue();
    }
}
