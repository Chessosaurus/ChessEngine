package chessosaurus.engine;

import chessosaurus.base.Board;
import chessosaurus.base.Color;
import chessosaurus.base.Move;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MinimaxThreading {

    private final MiniMaxAlgorithm miniMaxAlgorithm;
    public MinimaxThreading(IMoveFinder moveFinder){
        this.miniMaxAlgorithm = new MiniMaxAlgorithm(moveFinder);

    }

    public Move getBestMove(Board currentBoard, Color currentColor) {
        int bestValue = Evaluation.worstValue;
        Move bestMove = null;

        List<Move> legalMoves = miniMaxAlgorithm.getMoveFinder().getLegalMoves(currentBoard, currentColor);

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Integer>> futures = new ArrayList<>();

        for (Move move : legalMoves) {
            futures.add(executor.submit(() -> {
                Board newBoard = currentBoard.deepCloneBoard();
                newBoard.makeMove(move);
                return miniMaxAlgorithm.evaluate(newBoard, currentColor);
            }));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);

            if (legalMoves.size() != futures.size()) {
                throw new IllegalStateException("Size mismatch between legalMoves and futures.");
            }

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

