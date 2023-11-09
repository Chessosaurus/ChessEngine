package chessosaurus.persistence;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.protocol.IMoveParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * EndgameRestReader calls closing database via Rest to get move.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */

public class EndgameRestReader implements IEndgameReader {

    private final IMoveParser moveParser;

    public EndgameRestReader(IMoveParser moveParser) {
        this.moveParser = moveParser;
    }

    @Override
    public Move getMove(String currentBoardAsFen, Board currentBoard) {
        Move bestMove = null;

        try {

            if(currentBoardAsFen == null){
                return null;
            }

            // API-URL for the endgame tablebase
            String apiUrl = "https://tablebase.lichess.ovh/standard?fen=" + currentBoardAsFen;

            // Create connection
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the JSON recieved
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(connection.getInputStream());

            // Selects the best rated move
            String bestMoveString = (jsonNode.get("moves").get(0).get("uci").toString());
            bestMove = moveParser.fromStringToMove(bestMoveString, currentBoard);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bestMove;
    }
}
