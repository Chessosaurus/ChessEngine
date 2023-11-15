package chessosaurus.persistence;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.protocol.IMoveParser;
import chessosaurus.review.ReviewerContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
        List<Move>      bestMovesAsMove = new ArrayList<>();
        ReviewerContext reviewerContext = new ReviewerContext();

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