package chessosaurus.persistence;

import chessosaurus.base.Move;
import chessosaurus.protocol.MoveParser;
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

public class OpeninggameRestReader implements IRestReader{

    MoveParser moveParser = new MoveParser();

    /**
     * Sends current board to get move from the api
     * @return best move
     */
    @Override
    public String getMove(Move currentMove) {
        String bestMove = "";
        String moveMade = "";
        try {
            if(currentMove != null){
                moveMade = moveParser.transformMoveToString(currentMove);
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

            bestMove = (jsonNode.get("moves").get(0).get("uci").toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bestMove;
    }
}
