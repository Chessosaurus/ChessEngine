package chessosaurus.control;

import chessosaurus.base.*;
import chessosaurus.engine.IEnemyMoverContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BusinessControllerTest {
/*
    private final BusinessController businessController;
    private Game mockGame;
    private final Board expectedBoard = new Board();

    public BusinessControllerTest() {
        this.mockGame = mock(Game.class);
        IEnemyMoverContext mockEnemyMoverContext = mock(IEnemyMoverContext.class);
        this.businessController = new BusinessController(mockEnemyMoverContext, mockGame);
    }

    @Test
    public void testInitializeGame() {

        // ACT

        Board board = this.businessController.initializeGame();
        Game game = this.businessController.getGame();

        // ASSERT

        assertNotNull(board);
        assertNotNull(game);
        assertNotEquals(this.mockGame, game);
    }

    @Test
    public void testReviewPlayerMove() {

        // ARRANGE

        when(this.mockGame.getChessboard()).thenReturn(this.expectedBoard);

        Piece pieceFrom = new Piece();
        pieceFrom.setColor(Color.BLACK);
        pieceFrom.setType(PieceType.PAWN);
        Square testFrom = new Square(1,2);
        testFrom.setPiece(pieceFrom);

        Square testTo = new Square(1,3);

        Move testMove = new Move (testFrom, testTo);

        // ACT

        Board board = this.businessController.reviewPlayerMove(testMove);

        // ASSERT

        assertNotNull(board);
        assertEquals(this.expectedBoard, board);
        verify(this.mockGame, times(1)).reviewPlayerMove(testMove);
        verify(this.mockGame, times(1)).getChessboard();
    }

    @Test
    public void testCalculateBestMove() {

        // ARRANGE

        Piece pieceFrom = new Piece();
        pieceFrom.setColor(Color.BLACK);
        pieceFrom.setType(PieceType.PAWN);
        Square testFrom = new Square(1,2);
        testFrom.setPiece(pieceFrom);

        Square testTo = new Square(1,3);

        Move expectedMove = new Move (testFrom, testTo);

        when(this.mockGame.calculateBestEnemyMove()).thenReturn(expectedMove);

        // ACT

        Move move = this.businessController.calculateBestMove();

        // ASSERT

        assertNotNull(move);
        assertEquals(expectedMove, move);
    }

/*
    @Test
    @Tag("testGetGame")
    public void testGetGame() {
        // ARRANGE
        Game expectedGame = this.mockGame;

        // ACT

        Game game = this.businessController.getGame();

        // ASSERT

        assertNotNull(game);
        assertEquals(expectedGame, game);
    }*/
}
