package chessosaurus.base;

import java.util.Optional;

/**
 * The Board class is responsible for the representation and transformation of the chessboard.
 * <p>
 * @version 1.0
 * @author Fabian Eilber
 * @author Fabian Unger
 */

public class Board {
    private Square[][] chessboard;
    static private boolean whiteCastlingPossible = true;
    static private boolean blackCastlingPossible = true;
    private Board board;

    private int moveCounter;

    public Board() {
        this.chessboard = new Square[8][8];

        for(int i=0; i<8;i++){
            for(int j=0; j<8;j++){
                this.chessboard[i][j] = new Square(i+1,j+1);
                this.chessboard[i][j].setPiece(Optional.empty());
            }
        }
    }

    // Copy-Konstruktor
    public Board(Board board) {
        this.chessboard = board.getChessboard();
    }

    public void setRank(int rank, Optional<Piece>[] pieces) {
        for (int i = 0; i < 8; i++) {
            chessboard[rank][i].setPiece(pieces[i]);
        }
    }

    /**
     * Returns square from a board by rank and file
     * @param rank Given row
     * @param file Given column
     * @return square
     */
    public Square getSquare(int rank, char file) {
        Square[][] squares = this.chessboard;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (squares[i][j].getRank() == rank && squares[i][j].getFile() == file) {
                    return squares[i][j];
                }
            }
        }

        return null;
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
                //rank = 0;
                //file ++;
                file = 0;
                rank--;
            } else if (Character.isDigit(c)) {
                int emptySpaces = Character.getNumericValue(c);
                for (int i = 0; i < emptySpaces; i++) {
                    //rank++;
                    file++;
                }
            } else {

                Piece piece = new Piece();

                switch (c) {
                    case 'k' -> {
                        piece.setType(PieceType.KING);
                        piece.setColor(Color.BLACK);
                    }
                    case 'K' -> {
                        piece.setType(PieceType.KING);
                        piece.setColor(Color.WHITE);
                    }
                    case 'q' -> {
                        piece.setType(PieceType.QUEEN);
                        piece.setColor(Color.BLACK);
                    }
                    case 'Q' -> {
                        piece.setType(PieceType.QUEEN);
                        piece.setColor(Color.WHITE);
                    }
                    case 'r' -> {
                        piece.setType(PieceType.ROOK);
                        piece.setColor(Color.BLACK);
                    }
                    case 'R' -> {
                        piece.setType(PieceType.ROOK);
                        piece.setColor(Color.WHITE);
                    }
                    case 'b' -> {
                        piece.setType(PieceType.BISHOP);
                        piece.setColor(Color.BLACK);
                    }
                    case 'B' -> {
                        piece.setType(PieceType.BISHOP);
                        piece.setColor(Color.WHITE);
                    }
                    case 'n' -> {
                        piece.setType(PieceType.KNIGHT);
                        piece.setColor(Color.BLACK);
                    }
                    case 'N' -> {
                        piece.setType(PieceType.KNIGHT);
                        piece.setColor(Color.WHITE);
                    }
                    case 'p' -> {
                        piece.setType(PieceType.PAWN);
                        piece.setColor(Color.BLACK);
                    }
                    case 'P' -> {
                        piece.setType(PieceType.PAWN);
                        piece.setColor(Color.WHITE);
                    }
                    default -> throw new IllegalArgumentException("No permissible figure type");
                }
                this.chessboard[rank][file].setPiece(piece);
                //rank++;
                file++;
            }
        }
    }

    /**
     * Transforms the given chessboard to fen-notation
     * @param chessboard chessboard
     * @return chessboard as fen-notation
     */
    public String transformBoardToFen(Board chessboard){
        StringBuilder fen = new StringBuilder();
        int emptyCount = 0;
        Square[][] square = chessboard.getChessboard();

        for (int i=0; i< square.length; i++){
            for (int j=0; j < square.length; j++){
                if(square[i][j].getPiece().isEmpty()){
                    emptyCount++;
                } else {
                    if (emptyCount > 0) {
                        fen.append(emptyCount);
                        emptyCount = 0;
                    }
                    fen.append(getCharFromPiece(square[i][j].getPiece().get()));
                }
            }
            if(emptyCount>0){
                fen.append(emptyCount);
                emptyCount = 0;
            }
            if(i<7) {
                fen.append('/');
            }
        }


        return fen.toString();
    }

    /**
     * Outputs the chessboard in the console, using the names of the chess pieces.
     * Blank fields are represented by "-".
     */
    public void displayBoard() {

        String pieceSymbol;

        System.out.println("  A  B  C  D  E  F  G  H");
        System.out.println(" ┏━━┳━━┳━━┳━━┳━━┳━━┳━━┳━━┓");

        for (int i = 0; i <=7; i++) {
            System.out.print((8-i) + "┃");
            for (int j = 0; j <=7; j++) {
                if(this.chessboard[i][j].getPiece().isEmpty()){
                    pieceSymbol = "  ";
                }else{
                    Piece piece = this.chessboard[i][j].getPiece().get();
                    pieceSymbol = getPieceSymbol(piece);
                }
                System.out.print(pieceSymbol + "┃");
            }
            System.out.println(" " + (8-i));
            if (i != 0) {
                System.out.println(" ┣━━┫━━┫━━┫━━┫━━┫━━┫━━┫━━┫");
            } else {
                System.out.println(" ┗━━┻━━┻━━┻━━┻━━┻━━┻━━┻━━┛");
            }
        }
        System.out.println("  A  B  C  D  E  F  G  H");
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
                    //return "K";
                }else{
                    return "♚";
                    //return "k";
                }
            case QUEEN:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♕";
                    //return "Q";
                }else{
                    return "♛";
                    //return "q";
                }
            case ROOK:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♖";
                    //return "R";
                }else{
                    return "♜";
                    //return "r";
                }
            case BISHOP:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♗";
                    //return "B";
                }else{
                    return "♝";
                    //return "b";
                }

            case KNIGHT:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♘";
                    //return "N";
                }else{
                    return "♞";
                    //return "n";
                }
            case PAWN:
                if(piece.getColor().equals(Color.WHITE)){
                    return "♙";
                    //return  "P";
                }else{
                    return "♟";
                    //return "P";
                }
            default:
                return " ";
        }
    }

    /**
     * Returns the current chessboard
     * @return current chessboard
     */
    public Square[][] getChessboard() {
        return chessboard;
    }

    /**
     * Sets the current chessboard
     * @param chessboard current chessboard
     */
    public void setChessboard(Square[][] chessboard) {
        this.chessboard = chessboard;
    }

    /**
     * Counts the pieces on the board
     * @return count of pieces on the board
     */
    public int getPieceCount(){
        int count = 0;
        Square[][] square = this.chessboard;
        for (Square[] squares : square) {
            for (int j = 0; j < square.length; j++) {
                if (squares[j].getPiece().isPresent()) {
                    count++;
                }
            }
        }


        return count;
    }

    public char getCharFromPiece(Piece piece){
        char charFromPiece = ' ';
        if(piece.getColor().equals(Color.BLACK)){
            switch (piece.getType()){
            case ROOK -> charFromPiece = 'r';
            case KING -> charFromPiece = 'k';
            case QUEEN -> charFromPiece = 'q';
            case PAWN -> charFromPiece = 'p';
            case BISHOP -> charFromPiece = 'b';
            case KNIGHT -> charFromPiece = 'n';
            }
        } else {
            switch (piece.getType()){
                case ROOK -> charFromPiece = 'R';
                case KING -> charFromPiece = 'K';
                case QUEEN -> charFromPiece = 'Q';
                case PAWN -> charFromPiece = 'P';
                case BISHOP -> charFromPiece = 'B';
                case KNIGHT -> charFromPiece = 'N';
            }
        }
        return charFromPiece;
    }

    public void setCastlingImpossible(Color color){
        if(color.equals(Color.WHITE)) whiteCastlingPossible = false;
        else blackCastlingPossible = false;
    }

    public boolean isCastlingPossible(Color color){
        if(color.equals(Color.WHITE)) return whiteCastlingPossible;
        else return blackCastlingPossible;
    }


    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

   public Board makeMove (Move move) {
        int toRank = move.getTo().getRank()-1;
        int toFile = move.getTo().getFileVal()-1;

        int fromRank = move.getFrom().getRank()-1;
        int fromFile = move.getFrom().getFileVal()-1;
        this.getChessboard()[toRank][toFile].setPiece(move.getFrom().getPiece().isEmpty()?null : move.getFrom().getPiece());
        this.getChessboard()[fromRank][fromFile].setPiece(Optional.empty());

        return this;
    }
}
