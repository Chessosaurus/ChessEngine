package chessosaurus.general.board;
import chessosaurus.general.pieces.*;

/**
 * Die Klasse Board ist für die Darstellung und Umwandlung des Schachbretts zuständig.
 *
 * Version: 1.0
 * Autor: Fabian Eilber
 */

public class Board {
    private Piece[][] chessboard;

    public Board() {
        chessboard = new Piece[8][8];
        initializeChessboard();
    }

    /**
     * Initialisiert das Schachbrett mit den Startpositionen der Schachfiguren für eine neue Schachpartie.
     * Weiße Figuren werden auf den Reihen 1 und 2 platziert, schwarze Figuren auf den Reihen 7 und 8.
     * Die Startpositionen entsprechen den Schachregeln.
     */
    private void initializeChessboard() {

        //Weiße Figuren
        chessboard[0][0] = new Rook(Color.WHITE);
        chessboard[0][1] = new Knight(Color.WHITE);
        chessboard[0][2] = new Bishop(Color.WHITE);
        chessboard[0][3] = new Queen(Color.WHITE);
        chessboard[0][4] = new King(Color.WHITE);
        chessboard[0][5] = new Bishop(Color.WHITE);
        chessboard[0][6] = new Knight(Color.WHITE);
        chessboard[0][7] = new Rook(Color.WHITE);

        for (int i = 0; i < 8; i++) {
            chessboard[1][i] = new Pawn(Color.WHITE);
        }

        // Schwarze Figuren
        chessboard[7][0] = new Rook(Color.BLACK);
        chessboard[7][1] = new Knight(Color.BLACK);
        chessboard[7][2] = new Bishop(Color.BLACK);
        chessboard[7][3] = new Queen(Color.BLACK);
        chessboard[7][4] = new King(Color.BLACK);
        chessboard[7][5] = new Bishop(Color.BLACK);
        chessboard[7][6] = new Knight(Color.BLACK);
        chessboard[7][7] = new Rook(Color.BLACK);

        for (int i = 0; i < 8; i++) {
            chessboard[6][i] = new Pawn(Color.BLACK);
        }
    }

    /**
     * Gibt das Schachbrett in der Konsole aus, wobei die Namen der Schachfiguren verwendet werden.
     * Leerfelder werden durch "-" dargestellt.
     */
    public void displayBoard() {
        System.out.println("  A B C D E F G H");
        System.out.println(" -----------------");

        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "|");
            for (int j = 0; j < 8; j++) {
                if (chessboard[i][j] != null) {
                    System.out.print(chessboard[i][j].getName() + "|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.println(" " + (8 - i));
            System.out.println(" +----------------");
        }
        System.out.println("  A B C D E F G H");
    }

}
