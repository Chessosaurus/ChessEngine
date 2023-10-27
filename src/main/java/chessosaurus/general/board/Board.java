package chessosaurus.general.board;
import chessosaurus.general.pieces.*;

/**
 * The Board class is responsible for the representation and transformation of the chessboard.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */

public class Board {
    private char[][] chessboard;

    public Board() {
        this.chessboard = new char[8][8];
    }

    public void importFen(String fenNotation){

        String[] parts = fenNotation.split(" ");
        String position = parts[0];
        int rank = 7;
        int file = 0;

        for (char c : position.toCharArray()) {
            if (c == '/') {
                rank--;
                file = 0; // Zur nächsten Zeile wechseln, Spalte auf 0 zurücksetzen
            } else if (Character.isDigit(c)) {
                int emptySpaces = Character.getNumericValue(c);
                for (int i = 0; i < emptySpaces; i++) {
                    this.chessboard[rank][file++] = ' ';
                }
            } else {
                this.chessboard[rank][file++] = c;
            }
        }
    }

    /**
     * Outputs the chessboard in the console, using the names of the chess pieces.
     * Blank fields are represented by "-".
     */
    public void displayBoard() {
        System.out.println("  A B C D E F G H");
        System.out.println(" ┏━┳━┳━┳━┳━┳━┳━┳━┓");

        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "┃");
            for (int j = 0; j < 8; j++) {
                char piece = chessboard[i][j];
                String pieceSymbol = getPieceSymbol(piece);
                System.out.print(pieceSymbol + "┃");
            }
            System.out.println(" " + (8 - i));
            if (i < 7) {
                System.out.println(" ┣━┫━┫━┫━┫━┫━┫━┫━┫");
            } else {
                System.out.println(" ┗━┻━┻━┻━┻━┻━┻━┻━┛");
            }
        }
        System.out.println("  A B C D E F G H");
    }

    /**
     * Returns the unicode symbol for the piece
     * @param piece char which describes the piece
     * @return String to display unicode symbol
     */
    private String getPieceSymbol(char piece) {
        switch (piece) {
            case 'P':
                return "♟";
            case 'R':
                return "♜";
            case 'N':
                return "♞";
            case 'B':
                return "♝";
            case 'Q':
                return "♛";
            case 'K':
                return "♚";
            case 'p':
                return "♙";
            case 'r':
                return "♖";
            case 'n':
                return "♘";
            case 'b':
                return "♗";
            case 'q':
                return "♕";
            case 'k':
                return "♔";
            default:
                return " ";
        }
    }

}
