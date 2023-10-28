package chessosaurus.base;

/**
 * The Board class is responsible for the representation and transformation of the chessboard.
 * <p>
 * Version: 1.0
 * Author: Fabian Eilber
 */

public class Board {
    private Square[][] chessboard;

    public Board() {
        this.chessboard = new Square[8][8];

        for(int i=0; i<8;i++){
            for(int j=0; j<8;j++){
                this.chessboard[i][j] = new Square(i,j);
            }
        }
    }

    /**
     * Transforms the fen-Notation into a processable 2d array
     * @param fenNotation String given by the UI
     */
    public void importFen(String fenNotation){

        String[] parts = fenNotation.split(" ");
        String position = parts[0];
        int rank = 7;
        int file = 0;

        for (char c : position.toCharArray()) {
            if (c == '/') {
                rank--;
                file = 0;
            } else if (Character.isDigit(c)) {
                int emptySpaces = Character.getNumericValue(c);
                for (int i = 0; i < emptySpaces; i++) {
                    //this.chessboard[rank][file++] ;
                    file++;
                }
            } else {


                Piece piece = new Piece();

                switch (c) {
                    case 'k':
                        piece.setType(PieceType.KING);
                        piece.setColor(Color.BLACK);
                        break;
                    case 'K':
                        piece.setType(PieceType.KING);
                        piece.setColor(Color.WHITE);
                        break;
                    case 'q':
                        piece.setType(PieceType.QUEEN);
                        piece.setColor(Color.BLACK);
                        break;
                    case 'Q':
                        piece.setType(PieceType.QUEEN);
                        piece.setColor(Color.WHITE);
                        break;
                    case 'r':
                        piece.setType(PieceType.ROOK);
                        piece.setColor(Color.BLACK);
                        break;
                    case 'R':
                        piece.setType(PieceType.ROOK);
                        piece.setColor(Color.WHITE);
                        break;
                    case 'b':
                        piece.setType(PieceType.BISHOP);
                        piece.setColor(Color.BLACK);
                        break;
                    case 'B':
                        piece.setType(PieceType.BISHOP);
                        piece.setColor(Color.WHITE);
                        break;
                    case 'n':
                        piece.setType(PieceType.KNIGHT);
                        piece.setColor(Color.BLACK);
                        break;
                    case 'N':
                        piece.setType(PieceType.KNIGHT);
                        piece.setColor(Color.WHITE);
                        break;
                    case 'p':
                        piece.setType(PieceType.PAWN);
                        piece.setColor(Color.BLACK);
                        break;
                    case 'P':
                        piece.setType(PieceType.PAWN);
                        piece.setColor(Color.WHITE);
                        break;
                    default:
                        throw new IllegalArgumentException("No permissible figure type");
                }


                this.chessboard[rank][file++].setPiece(piece);
            }
        }
    }

    /**
     * Outputs the chessboard in the console, using the names of the chess pieces.
     * Blank fields are represented by "-".
     */
    public void displayBoard() {

        String pieceSymbol;

        System.out.println("  A B C D E F G H");
        System.out.println(" ┏━┳━┳━┳━┳━┳━┳━┳━┓");

        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "┃");
            for (int j = 0; j < 8; j++) {
                if(this.chessboard[i][j].getPiece() == null){
                    pieceSymbol = " ";
                }else{
                    Piece piece = this.chessboard[i][j].getPiece();
                    pieceSymbol = getPieceSymbol(piece);
                }
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
    private String getPieceSymbol(Piece piece) {
        switch (piece.getType()) {
            case KING:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♔";
                }else{
                    return "♚";
                }
            case QUEEN:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♕";
                }else{
                    return "♛";
                }
            case ROOK:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♖";
                }else{
                    return "♜";
                }
            case BISHOP:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♗";
                }else{
                    return "♝";
                }

            case KNIGHT:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♘";
                }else{
                    return "♞";
                }
            case PAWN:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♙";
                }else{
                    return "♟";
                }
            default:
                return " ";
        }
    }

}
