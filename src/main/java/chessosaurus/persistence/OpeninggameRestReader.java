package chessosaurus.persistence;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.protocol.IMoveParser;
import chessosaurus.protocol.UCIMoveParser;
import chessosaurus.review.ReviewerContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
     * @param currentBoard The current chessboard
     * @param currentMove The last move which was made
     * @return best move
     */
    @Override
    public Move getMove(Board currentBoard, Move currentMove) {
        Move bestMove = null;
        String moveMade = "";
        List<Move> bestMovesAsMove = new ArrayList<>();
        ReviewerContext reviewerContext = new ReviewerContext();
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
            JsonNode rootNode = mapper.readTree(connection.getInputStream());

            //Extract moves
            JsonNode movesNode = rootNode.path("moves");

            //Extract UCI moves
            for (JsonNode moveNode: movesNode) {
                bestMovesAsMove.add(moveParser.fromStringToMove(moveNode.path("uci").asText(),currentBoard));
            }

            for (Move moveToCheck: bestMovesAsMove) {
                if(reviewerContext.isLegalMove(moveToCheck,currentBoard)){
                    bestMove = moveToCheck;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bestMove;
    }
}
