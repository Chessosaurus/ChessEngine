package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import io.reactive.rxjava3.subjects.ReplaySubject;

public class MinimaxThreading implements IEnemyMoverContext{

    private ExecutorService excutorService;
    //private ReplaySubject<EvaluatedMove> searchresults;

    /*public MinimaxThreading(){
        int cores = Runtime.getRuntime().availableProcessors();
        excutorService = Executors.newFixedThreadPool(cores);
    }*/

    @Override
    public Move getBestMove(List<Move> allMoves, Board currentBoard, Color currentColor) {
        return null;
    }
}
