package chessosaurus.persistence;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.protocol.IMoveParser;
import chessosaurus.protocol.UCIMoveParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * OpeninggameRestReader calls opening database via Rest to get move.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */

public class OpeninggameRestReader implements IOpeninggameReader {

    private final IMoveParser moveParser;

    public OpeninggameRestReader(IMoveParser moveParser) {
        this.moveParser = moveParser;
    }

    /**
     * Sends current board to get move from the api
     * @return best move
     */
    @Override
    public Move getMove(Board currentBoard, Move currentMove) {
        Move bestMove = null;
        String moveMade = "";
        try {
            if(currentMove != null){
                moveMade = moveParser.fromMoveToString(currentMove);
            }

            // API-URL for the opening database
            String apiUrl = "https://explorer.lichess.ovh/master?play=" + moveMade;

            // Create connection
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the JSON recieved
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(connection.getInputStream());

            String bestMoveString = (jsonNode.get("moves").get(0).get("uci").toString());
            bestMove = moveParser.fromStringToMove(bestMoveString, currentBoard);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bestMove;
    }
}
