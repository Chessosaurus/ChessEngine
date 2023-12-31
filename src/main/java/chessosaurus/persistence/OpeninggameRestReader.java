package chessosaurus.persistence;

import chessosaurus.base.Board;
import chessosaurus.base.Move;
import chessosaurus.protocol.IMoveParser;
import chessosaurus.review.IReviewerContext;
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
    private final IReviewerContext reviewerContext;

    public OpeninggameRestReader(IMoveParser moveParser, IReviewerContext reviewerContext) {
        this.moveParser = moveParser;
        this.reviewerContext = reviewerContext;
    }

    /**
     * Sends current board to get move from the api
     * @param currentBoard The current chessboard
     * @param allMoves all moves to pick last one
     * @return best move
     */
    @Override
    public Move getMove(Board currentBoard, List<Move> allMoves) {

        int movesCount = allMoves.size();
        Move currentMove = null;
        if (!allMoves.isEmpty() && movesCount > 0) {
            currentMove = allMoves.get(movesCount - 1);
        }
        Move bestMove = null;
        String moveMade = "";
        List<Move> bestMovesAsMove = new ArrayList<>();

        try {
            if(currentMove != null){
                moveMade = moveParser.fromMoveToString(currentMove);
            }

            StringBuilder movesStringBuilder = new StringBuilder();

            for (Move moveToParse : allMoves) {
                movesStringBuilder.append(moveParser.fromMoveToString(moveToParse));
                if (allMoves.indexOf(moveToParse) != allMoves.size() - 1) {
                    movesStringBuilder.append(",");
                }
            }
            String movesMade = movesStringBuilder.toString();

            //If someone is to capture a figure x is inserted, but the API can´t resolve this
            movesMade.replace("x","");

            // API-URL for the opening database
            String apiUrl = "https://explorer.lichess.ovh/masters?play=" + movesMade;

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
                if(!checkMoveInList(moveToCheck, allMoves)) {
                    if (reviewerContext.isLegalMove(moveToCheck, currentBoard)) {
                        bestMove = moveToCheck;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bestMove;
    }

    private boolean checkMoveInList(Move move, List<Move> allMoves){
        for (Move moveToCheck : allMoves) {
            if(moveToCheck.getFrom().getRank() == move.getFrom().getRank() && moveToCheck.getFrom().getFileVal() == move.getFrom().getFileVal()){
                return true;
            }
        }
        return false;
    }
}
