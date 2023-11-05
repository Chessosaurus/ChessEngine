package chessosaurus.persistence;

public interface IEndgameReader {

    /**
     * Sends current board to get move from the api
     * @return best move
     */
    String getMove();

}
