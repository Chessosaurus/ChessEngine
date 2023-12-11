package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import chessosaurus.control.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
//import io.reactive.rxjava3.subjects.ReplaySubject;

public class MinimaxThreading {

    private final MiniMaxAlgorithm miniMaxAlgorithm;
    public MinimaxThreading(IMoveFinder moveFinder){
        this.miniMaxAlgorithm = new MiniMaxAlgorithm(moveFinder);

    }

    public Move getBestMove(Board currentBoard, Color currentColor, Game currentGame) {
        int bestValue = Evaluation.worstValue;
        Move bestMove = null;

        List<Move> legalMoves = miniMaxAlgorithm.getMoveFinder().getLegalMoves(currentBoard, currentColor);

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Integer>> futures = new ArrayList<>();

        for (Move move : legalMoves) {
            futures.add(executor.submit(() -> {
                Board newBoard = currentGame.deepCloneBoard();
                newBoard.makeMove(move);
                return miniMaxAlgorithm.evaluate(newBoard, currentColor, currentGame);
            }));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            for (int i = 0; i < futures.size(); i++) {
                int value = futures.get(i).get();
                if (value > bestValue) {
                    bestValue = value;
                    bestMove = legalMoves.get(i);
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return bestMove;
    }
}

