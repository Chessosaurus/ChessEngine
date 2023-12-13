package chessosaurus.control;

import chessosaurus.base.*;
import chessosaurus.engine.*;
import chessosaurus.review.IReviewerContext;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private Board expectedBoard;
    private List<Move> expectedMoves;
    private final Move expectedBestMove;


    private final Game game;

    public GameTest() {
        IEnemyMoverContext mockEnemyMoverContext = mock(IEnemyMoverContext.class);
        Piece pieceFrom = new Piece();
        pieceFrom.setColor(Color.BLACK);
        pieceFrom.setType(PieceType.PAWN);
        Square testFrom = new Square(1,2);
        testFrom.setPiece(pieceFrom);

        IReviewerContext mockReviewerContext = mock(IReviewerContext.class);
        when(mockReviewerContext.isLegalMove(any(), any())).thenReturn(true);

        Square testTo = new Square(1,3);

        this.expectedBestMove = new Move (testFrom, testTo);
        when(mockEnemyMoverContext.getBestMove(anyList(), any(), any())).thenReturn(this.expectedBestMove);

        this.game = new Game(Color.BLACK, mockEnemyMoverContext, mockReviewerContext);
    }


    @Test
    public void testChessboard() {

        // ARRANGE

        this.expectedBoard = new Board();

        // ACT

        this.game.setChessboard(this.expectedBoard);
        Board board = this.game.getChessboard();

        // ASSERT

        assertNotNull(board);
        assertEquals(this.expectedBoard, board);

    }

    @Test
    public void testMoves() {

        // ARRANGE

        Piece pieceFromA = new Piece();
        pieceFromA.setColor(Color.BLACK);
        pieceFromA.setType(PieceType.PAWN);
        Square testFromA = new Square(1,2);
        testFromA.setPiece(pieceFromA);

        Square testToA = new Square(1,3);

        Move testMoveA = new Move (testFromA, testToA);

        Piece pieceFromB = new Piece();
        pieceFromB.setColor(Color.BLACK);
        pieceFromB.setType(PieceType.PAWN);
        Square testFromB = new Square(2,2);
        testFromB.setPiece(pieceFromB);

        Square testToB = new Square(2,3);

        Move testMoveB = new Move (testFromB, testToB);

        this.expectedMoves = new ArrayList<>();
        this.expectedMoves.add(testMoveA);
        this.expectedMoves.add(testMoveB);

        // ACT

        this.game.setMoves(this.expectedMoves);
        List<Move> moves = this.game.getMoves();

        // ASSERT

        assertNotNull(moves);
        assertEquals(this.expectedMoves.size(), moves.size());
        assertEquals(this.expectedMoves.get(0), moves.get(0));
        assertEquals(this.expectedMoves.get(1), moves.get(1));
        assertEquals(this.expectedMoves, moves);
    }

    @Test
    public void testReviewPlayerMove() {

        // ARRANGE

        String expectedFen = "rnbqkbnr/pppppppp/8/8/8/P7/1PPPPPPP/RNBQKBNR";

        this.expectedBoard = new Board();
        this.expectedBoard.importFen("rnbqkbnr/pppppppp/8/8/8/P7/1PPPPPPP/RNBQKBNR");

        Board cleanBoard = new Board();
        cleanBoard.importFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        this.game.setChessboard(cleanBoard);

        Piece pieceFrom = new Piece();
        pieceFrom.setColor(Color.WHITE);
        pieceFrom.setType(PieceType.PAWN);
        Square testFrom = new Square(1,2);
        testFrom.setPiece(pieceFrom);

        Square testTo = new Square(1,3);

        Move testMove = new Move (testFrom, testTo);

        // ACT

        this.game.reviewPlayerMove(testMove);
        Board resultBoard = this.game.getChessboard();
        String resultBoardFen = resultBoard.transformBoardToFen(resultBoard);

        // ASSERT

        assertNotNull(resultBoard);
        assertNotNull(resultBoardFen);
        assertEquals(expectedFen, resultBoardFen);

    }

    @Test
    public void testCalculateBestEnemyMove() {

        // ARRANGE

        Board board = new Board();
        board.importFen("rnbqkbnr/pppppppp/8/8/8/P7/1PPPPPPP/RNBQKBNR");

        this.game.setChessboard(board);


        // ACT

        Move move = this.game.calculateBestEnemyMove();

        // ASSERT

        assertNotNull(move);
        assertEquals(this.expectedBestMove, move);
    }
}
