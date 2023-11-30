package chessosaurus.engine;

import chessosaurus.base.*;
import chessosaurus.review.IReviewerContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to find all legal moves based on the given chessboard and current color.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public class MoveFinder implements IMoveFinder {

    private final IReviewerContext reviewerContext;

    public MoveFinder(IReviewerContext reviewerContext) {
        this.reviewerContext = reviewerContext;
    }

    /**
     * Calculates all legal moves.
     * @param board Given chessboard
     * @param currentColor Color for the moves to find
     * @return All legal moves
     */
    @Override
    public List<Move> getLegalMoves(Board board, Color currentColor) {
        List<Move> legalMoves = new ArrayList<>();

        Square[][] squares = board.getChessboard();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = squares[i][j];
                Piece piece = square.getPiece().get();
                if (piece != null && piece.getColor() == currentColor) {
                    List<Move> possibleMoves = generateMovesForPiece(square, board);

                    for (Move move : possibleMoves) {
                        if (reviewerContext.isLegalMove(move, board)) {
                            legalMoves.add(move);
                        }
                    }
                }
            }
        }

        return legalMoves;
    }

    /**
     * Generates a List of moves which are possible from a square.
     * @param square Given square
     * @param board Given chessboard
     * @return All possible moves of a piece on the square.
     */
    private List<Move> generateMovesForPiece(Square square, Board board) {
        Piece piece = square.getPiece().get();
        PieceType pieceType = piece.getType();

        List<Move> possibleMoves = new ArrayList<>();

        if (pieceType == PieceType.PAWN) {
            possibleMoves.addAll(this.getPawnMoves(square, board));
        }
        else if (pieceType == PieceType.ROOK) {
            possibleMoves.addAll(this.getRookMoves(square, board));
        }
        else if (pieceType == PieceType.KNIGHT) {
            possibleMoves.addAll(this.getKnightMoves(square, board));
        }
        else if (pieceType == PieceType.BISHOP) {
            possibleMoves.addAll(this.getBishopMoves(square, board));
        }
        else if (pieceType == PieceType.QUEEN) {
            possibleMoves.addAll(this.getQueenMoves(square, board));
        }
        else if (pieceType == PieceType.KING) {
            possibleMoves.addAll(this.getKingMoves(square, board));
        }

        return possibleMoves;
    }

    /**
     * Generates a List of moves which are possible for a pawn
     * @param square Given square
     * @param board Given chessboard
     * @return All possible moves of a pawn.
     */
    private List<Move> getPawnMoves(Square square, Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        Piece piece = square.getPiece().get();
        Color color = piece.getColor();

        int currentRank = square.getRank();
        char currentFile = square.getFile();

        if (color == Color.WHITE) {
            if (this.isValidSquare(currentRank + 1, currentFile)) {
                possibleMoves.add(new Move(square, board.getSquare(currentRank + 1, currentFile)));
                if (currentRank == 2) {
                    possibleMoves.add(new Move(square, board.getSquare(currentRank + 2, currentFile)));
                }
            }
            if (this.isValidSquare(currentRank + 1, (char) (currentFile + 1))) {
                possibleMoves.add(new Move(square, board.getSquare(currentRank + 1, (char) (currentFile + 1))));
            }
            if (this.isValidSquare(currentRank + 1, (char) (currentFile - 1))) {
                possibleMoves.add(new Move(square, board.getSquare(currentRank + 1, (char) (currentFile - 1))));
            }
        }
        else {
            if (this.isValidSquare(currentRank - 1, square.getFile())) {
                possibleMoves.add(new Move(square, board.getSquare(currentRank - 1, square.getFile())));
                if (currentRank == 7) {
                    possibleMoves.add(new Move(square, board.getSquare(currentRank - 2, square.getFile())));
                }
            }
            if (this.isValidSquare(currentRank - 1, (char) (currentFile + 1))) {
                possibleMoves.add(new Move(square, board.getSquare(currentRank - 1, (char) (currentFile + 1))));
            }
            if (this.isValidSquare(currentRank - 1, (char) (currentFile - 1))) {
                possibleMoves.add(new Move(square, board.getSquare(currentRank - 1, (char) (currentFile - 1))));
            }
        }

        return possibleMoves;
    }

    /**
     * Generates a List of moves which are possible for a rook
     * @param square Given square
     * @param board Given chessboard
     * @return All possible moves of a rook.
     */
    private List<Move> getRookMoves(Square square, Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        int currentRank = square.getRank();
        char currentFile = square.getFile();

        int newRank = 1;
        char newFile = 'a';

        while (this.isValidSquare(newRank, currentFile)) {
            possibleMoves.add(new Move(square, board.getSquare(newRank, currentFile)));

            newRank++;
        }

        while (this.isValidSquare(currentRank, newFile)) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank, newFile)));

            newFile = (char) (newFile + 1);
        }

        return possibleMoves;
    }

    /**
     * Generates a List of moves which are possible for a knight
     * @param square Given square
     * @param board Given chessboard
     * @return All possible moves of a knight.
     */
    private List<Move> getKnightMoves(Square square, Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        int currentRank = square.getRank();
        char currentFile = square.getFile();

        int[][] knightMoves = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

        for (int[] knightMove : knightMoves) {
            int newRank = currentRank + knightMove[0];
            char newFile = (char) (currentFile + knightMove[1]);

            if (this.isValidSquare(newRank, newFile)) {
                possibleMoves.add(new Move(square, board.getSquare(newRank, newFile)));
            }
        }

        return possibleMoves;
    }

    /**
     * Generates a List of moves which are possible for a bishop
     * @param square Given square
     * @param board Given chessboard
     * @return All possible moves of a bishop.
     */
    private List<Move> getBishopMoves(Square square, Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        int currentRank = square.getRank();
        char currentFile = square.getFile();

        int newRank = currentRank;
        char newFile = currentFile;

        while (this.isValidSquare(newRank + 1, (char) (newFile + 1))) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank + 1, (char) (currentFile + 1))));
            newRank++;
            newFile++;
        }

        newRank = currentRank;
        newFile = currentFile;

        while (this.isValidSquare(newRank + 1, (char) (newFile - 1))) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank + 1, (char) (currentFile - 1))));
        }

        newRank = currentRank;
        newFile = currentFile;

        while (this.isValidSquare(newRank - 1, (char) (newFile + 1))) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank - 1, (char) (currentFile + 1))));
        }

        newRank = currentRank;
        newFile = currentFile;

        while (this.isValidSquare(newRank - 1, (char) (newFile - 1))) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank - 1, (char) (currentFile - 1))));
        }

        return possibleMoves;
    }

    /**
     * Generates a List of moves which are possible for a queen
     * @param square Given square
     * @param board Given chessboard
     * @return All possible moves of a queen.
     */
    private List<Move> getQueenMoves(Square square, Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        int currentRank = square.getRank();
        char currentFile = square.getFile();

        // Diagonal

        int newRank = currentRank;
        char newFile = currentFile;

        while (this.isValidSquare(newRank + 1, (char) (newFile + 1))) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank + 1, (char) (currentFile + 1))));
            newRank++;
            newFile++;
        }

        newRank = currentRank;
        newFile = currentFile;

        while (this.isValidSquare(newRank + 1, (char) (newFile - 1))) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank + 1, (char) (currentFile - 1))));
        }

        newRank = currentRank;
        newFile = currentFile;

        while (this.isValidSquare(newRank - 1, (char) (newFile + 1))) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank - 1, (char) (currentFile + 1))));
        }

        newRank = currentRank;
        newFile = currentFile;

        while (this.isValidSquare(newRank - 1, (char) (newFile - 1))) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank - 1, (char) (currentFile - 1))));
        }

        // Horizontal

        newFile = 'a';

        while (this.isValidSquare(currentRank, newFile)) {
            possibleMoves.add(new Move(square, board.getSquare(currentRank, newFile)));

            newFile = (char) (newFile + 1);
        }

        // Vertikal

        newRank = 1;

        while (this.isValidSquare(newRank, currentFile)) {
            possibleMoves.add(new Move(square, board.getSquare(newRank, currentFile)));

            newRank++;
        }

        return possibleMoves;
    }

    /**
     * Generates a List of moves which are possible for a king
     * @param square Given square
     * @param board Given chessboard
     * @return All possible moves of a king.
     */
    private List<Move> getKingMoves(Square square, Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        int currentRank = square.getRank();
        char currentFile = square.getFile();

        int[][] kingMoves = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] kingMove : kingMoves) {
            int newRank = currentRank + kingMove[0];
            char newFile = (char) (currentFile + kingMove[1]);

            if (isValidSquare(newRank, newFile)) {
                possibleMoves.add(new Move(square, board.getSquare(newRank, newFile)));
            }
        }

        return possibleMoves;
    }


    /**
     * Checks if the square is valid for the chessboard.
     * @param rank row of square
     * @param file column of square
     * @return {@code true}, if the square is valid, else {@code false}.
     */
    private boolean isValidSquare(int rank, char file) {
        return rank >= 1 && rank <= 8 && file >= 'a' && file <= 'h';
    }
}
