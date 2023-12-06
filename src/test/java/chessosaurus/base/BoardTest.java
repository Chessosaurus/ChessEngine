package chessosaurus.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void transformBoardToFen() {
        String originalFen = "8/5pk1/4r2p/7P/8/5Q2/7K/8";
        String compareFen = "";

        Board cleanBoard = new Board();
        cleanBoard.importFen(originalFen);

        compareFen = new Board().transformBoardToFen(cleanBoard);

        assertEquals(originalFen, compareFen);

    }
}