package chessosaurus.persistence;

import chessosaurus.base.Move;
import chessosaurus.protocol.IMoveParser;

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
    public Move getMove() {
        Move bestMove = null;

        // bestMove erfahren und mit IMoveParser zu Move Objekt parsen

        return bestMove;
    }
}
