package chessosaurus.parser;

import antlr.InputLexer;
import antlr.InputParser;
import antlr.InputVisitor;
import chessosaurus.base.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Converter implements InputVisitor {
    private Board parseStartFen(String fen) {
        return visitStart(
                new InputParser(
                        new CommonTokenStream(
                                new InputLexer(
                                        CharStreams.fromString(fen)))).start());
    }

    @Override
    public Board visitStart(InputParser.StartContext ctx) {
        //fen notation
        if (ctx.FEN() != null) {
            Board b = visitRows(ctx.rows());
            //info not yet used in board, would have to be implemented here
            Info info = visitInfo(ctx.info());
            b.setNextTurn(info.getNextTurn());
            if(info.getEnpassant().isPresent()){
                b.getCorrespondingSquare(info.getEnpassant().get()).setEnPassantPossible(true);
            }
            return b;
        }
        //arithmetic notation
        else {
            return visitMoves(ctx.moves());
        }
    }


    @Override
    public Board visitMoves(InputParser.MovesContext ctx) {
        Board board;
        //Change to parse fen
        board = parseStartFen("position fen rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w - - 0 1");
        List<Move> moves = visitWhitemove(ctx.whitemove());
        for (int i = 0; i < moves.size(); i++) {
            Move move = moves.get(i);
            if (board.getCorrespondingSquare(move.getFrom()).getPiece().isEmpty()) {
                return null;
            }
            //White special turns
            if (i % 2 == 0) {
                //White-Castle
                if (castle(board, move, 1)) continue;
                //White-En passant
                if (enPass(board, move, 5, 6, Color.WHITE)) continue;
            }

            //Black special turns
            else {
                //Black-Castle
                if (castle(board, move, 8)) continue;


                //Black-En passant
                if (enPass(board, move, 4, 3, Color.BLACK)) continue;
            }
            //Normal
            Square corresTo = board.getCorrespondingSquare(move.getTo());
            Square corresFrom = board.getCorrespondingSquare(move.getFrom());
            corresTo.setPiece(corresFrom.getPiece());
            corresFrom.setPiece(Optional.empty());
            //Promote
            if (move.getPromoted().isPresent()) {
                board.getCorrespondingSquare(move.getTo()).getPiece().get().setType(move.getPromoted().get());
            }
        }
        board.setNextTurn(moves.size() % 2 == 0 ? Color.WHITE : Color.BLACK);
        Move lastmove = moves.get(moves.size()-1);
        if(board.getCorrespondingSquare(lastmove.getTo()).getPiece().get().getType() == PieceType.PAWN){
            if(board.getNextTurn() == Color.WHITE && lastmove.getFrom().getRank()-2 == lastmove.getTo().getRank()){
                //Last turn of black enables en passant
                board.getChessboard()[lastmove.getFrom().getRank()-2][lastmove.getFrom().getFileVal()-1].setEnPassantPossible(true);
            }
            else if(board.getNextTurn() == Color.BLACK && lastmove.getFrom().getRank()+2 == lastmove.getTo().getRank()){
                //Last turn of white enables en passant
                board.getChessboard()[lastmove.getFrom().getRank()][lastmove.getFrom().getFileVal()-1].setEnPassantPossible(true);
            }
        }
        return board;
    }

    private boolean castle(Board board, Move move, int rank) {
        if (move.getFrom().isField('e', rank)
                && board.getCorrespondingSquare(move.getFrom()).getPiece().get().getType() == PieceType.KING) {
            if (move.getTo().isField('c', rank)) {
                board = castleTo(board, 'c', rank);
                //@TODO diable left white castle
                //@TODO disable left black castle
                return true;
            }
            if (move.getTo().isField('g', rank)) {
                board = castleTo(board, 'g', rank);
                //@TODO disable right white castle
                //@TODO disable right black castle
                return true;
            }
        }
        return false;
    }

    private Board castleTo(Board board, char file, int rank) {
        int fileInt = file == 'c' ? 2 : 6;
        int rankInt = rank - 1;
        //Move king to Square and reset King Square
        board.getChessboard()[rankInt][fileInt].setPiece
                (board.getChessboard()[rankInt][4].getPiece());
        board.getChessboard()[rankInt][4].setPiece(Optional.empty());
        //Move Rook behind King and reset Rook Square
        board.getChessboard()[rankInt][fileInt == 2 ? 3 : 5].setPiece(
                board.getChessboard()[rankInt][fileInt == 2 ? 0 : 7].getPiece());
        board.getChessboard()[rankInt][fileInt == 2 ? 0 : 7].setPiece(Optional.empty());
        return board;
    }

    private boolean enPass(Board board, Move move, int rankFrom, int rankTo, Color color) {
        if (move.getFrom().getFile() != move.getTo().getFile() //File is different
                && board.getCorrespondingSquare(move.getTo()).getPiece().isEmpty()) //To Field is empty
        {
            if (board.getCorrespondingSquare(move.getFrom()).getPiece().get().getType() == PieceType.PAWN //Pawn Move
                    && move.getFrom().getRank() == rankFrom
                    && move.getTo().getRank() == rankTo) {
                board = enPassant(board, move, color);
                return true;
            }
        }
        return false;
    }

    private Board enPassant(Board board, Move move, Color color) {
        int rankInt = move.getTo().getRank() - 1;
        int fileInt = move.getTo().getFileVal() - 1;
        board.getCorrespondingSquare(move.getTo())
                .setPiece(board.getCorrespondingSquare(move.getFrom()).getPiece());
        board.getCorrespondingSquare(move.getFrom()).setPiece(Optional.empty());
        int rankRemoveInt = color == Color.WHITE ? rankInt - 1 : rankInt + 1;
        board.getChessboard()[rankRemoveInt][fileInt].setPiece(Optional.empty());
        return board;
    }

    @Override
    public List<Move> visitWhitemove(InputParser.WhitemoveContext ctx) {
        List<Move> moves = new ArrayList<>();
        moves.add(visitMove(ctx.move()));
        if (ctx.blackmove() == null) {
            return moves;
        }
        moves.addAll(visitBlackmove(ctx.blackmove()));
        return moves;
    }

    @Override
    public List<Move> visitBlackmove(InputParser.BlackmoveContext ctx) {
        List<Move> moves = new ArrayList<>();
        moves.add(visitMove(ctx.move()));
        if (ctx.whitemove() == null) {
            return moves;
        }
        moves.addAll(visitWhitemove(ctx.whitemove()));
        return moves;
    }

    @Override
    public Move visitMove(InputParser.MoveContext ctx) {
        String move = ctx.MOVE().getText();
        Square from = new Square(move.charAt(0),move.charAt(1));
        Square to = new Square(move.charAt(2),move.charAt(3));
        /*String rank = ctx.FILE(0).getText();
        String file = ctx.NUMBER(0).getText();
        Square from = new Square(ctx.FILE(0).getText().charAt(0),
                Integer.parseInt(ctx.NUMBER(0).getText()));
        Square to = new Square(ctx.FILE(1).getText().charAt(0),
                Integer.parseInt(ctx.NUMBER(1).getText()));*/
        return ctx.promotable() == null ?
                new Move(from, to)
                : new Move(from, to, visitPromotable(ctx.promotable()));
    }

    @Override
    public PieceType visitPromotable(InputParser.PromotableContext ctx) {
        if (ctx.queen() != null) return PieceType.QUEEN;
        if (ctx.rook() != null) return PieceType.ROOK;
        if (ctx.knight() != null) return PieceType.KNIGHT;
        /*if (!ctx.bishop().isEmpty())*/
        return PieceType.BISHOP;
    }

    @Override
    public Board visitRows(InputParser.RowsContext ctx) {
        Board b = new Board();
        for (int i = 7; i >= 0; i--) {
            b.setRank(i, visitSingle_row(ctx.row(7 - i).single_row()));
        }
        return b;
    }

    @Override
    public Object visitRow(InputParser.RowContext ctx) {
        return null;
    }

    @Override
    public Optional<Piece>[] visitSingle_row(InputParser.Single_rowContext ctx) {
        Optional<Piece>[] rank = new Optional[8];
        //rank[0] = Optional.of(new Piece());
        int index = 0;
        for (InputParser.SlotContext sc : ctx.slot()) {
            if (sc.piece() == null) {
                for (int i = 0; i < Integer.parseInt(sc.num().NUMBER().getText()); i++) {//Hier stand FILE NICHT NUMBER
                    rank[index++] = Optional.empty();
                }
                continue;
            }
            InputParser.Piece_allContext pc = sc.piece().piece_all();
            rank[index++] = Optional.of(visitPiece_all(pc));
        }
        return rank;
    }

    @Override
    public Object visitSlot(InputParser.SlotContext ctx) {
        return null;
    }

    @Override
    public Object visitPiece(InputParser.PieceContext ctx) {
        return null;
    }

    @Override
    public Object visitNum(InputParser.NumContext ctx) {
        return null;
    }

    @Override
    public Info visitInfo(InputParser.InfoContext ctx) {
        return new Info(visitColor(ctx.color()), visitSquare(ctx.square()));
    }

    @Override
    public Color visitColor(InputParser.ColorContext ctx) {
        if (ctx.WHITE() == null) {
            return Color.BLACK;
        }
        return Color.WHITE;
    }

    @Override
    public Object visitCastleOptions(InputParser.CastleOptionsContext ctx) {
        return null;
    }

    @Override
    public Optional<Square> visitSquare(InputParser.SquareContext ctx) {
        if (ctx.FILE() == null) return Optional.empty();
        return Optional.of(new Square(
                ctx.FILE().getText().charAt(0),
                Integer.parseInt(ctx.NUMBER().getText())));
    }

    @Override
    public Object visitHalf(InputParser.HalfContext ctx) {
        return null;
    }

    @Override
    public Object visitFull(InputParser.FullContext ctx) {
        return null;
    }

    @Override
    public Piece visitPiece_all(InputParser.Piece_allContext ctx) {
        if (ctx.piece_white() == null) {
            return visitPiece_black(ctx.piece_black());
        } else {
            return visitPiece_white(ctx.piece_white());
        }
    }

    @Override
    public Piece visitPiece_white(InputParser.Piece_whiteContext ctx) {
        if (ctx.king_white() != null) return new Piece(PieceType.KING, Color.WHITE);
        if (ctx.queen_white() != null) return new Piece(PieceType.QUEEN, Color.WHITE);
        if (ctx.rook_white() != null) return new Piece(PieceType.ROOK, Color.WHITE);
        if (ctx.knight_white() != null) return new Piece(PieceType.KNIGHT, Color.WHITE);
        if (ctx.bishop_white() != null) return new Piece(PieceType.BISHOP, Color.WHITE);
        return new Piece(PieceType.PAWN, Color.WHITE);
    }

    @Override
    public Piece visitPiece_black(InputParser.Piece_blackContext ctx) {
        if (ctx.king_black() != null) return new Piece(PieceType.KING, Color.BLACK);
        if (ctx.queen_black() != null) return new Piece(PieceType.QUEEN, Color.BLACK);
        if (ctx.rook_black() != null) return new Piece(PieceType.ROOK, Color.BLACK);
        if (ctx.knight_black() != null) return new Piece(PieceType.KNIGHT, Color.BLACK);
        if (ctx.bishop_black() != null) return new Piece(PieceType.BISHOP, Color.BLACK);
        return new Piece(PieceType.PAWN, Color.BLACK);
    }


    @Override
    public Object visitKing_white(InputParser.King_whiteContext ctx) {
        return null;
    }

    @Override
    public Object visitKing_black(InputParser.King_blackContext ctx) {
        return null;
    }

    @Override
    public Object visitQueen(InputParser.QueenContext ctx) {
        return null;
    }


    @Override
    public Object visitQueen_white(InputParser.Queen_whiteContext ctx) {
        return null;
    }

    @Override
    public Object visitQueen_black(InputParser.Queen_blackContext ctx) {
        return null;
    }

    @Override
    public Object visitRook(InputParser.RookContext ctx) {
        return null;
    }


    @Override
    public Object visitRook_white(InputParser.Rook_whiteContext ctx) {
        return null;
    }

    @Override
    public Object visitRook_black(InputParser.Rook_blackContext ctx) {
        return null;
    }

    @Override
    public Object visitKnight(InputParser.KnightContext ctx) {
        return null;
    }


    @Override
    public Object visitKnight_white(InputParser.Knight_whiteContext ctx) {
        return null;
    }

    @Override
    public Object visitKnight_black(InputParser.Knight_blackContext ctx) {
        return null;
    }

    @Override
    public Object visitBishop(InputParser.BishopContext ctx) {
        return null;
    }


    @Override
    public Object visitBishop_white(InputParser.Bishop_whiteContext ctx) {
        return null;
    }

    @Override
    public Object visitBishop_black(InputParser.Bishop_blackContext ctx) {
        return null;
    }


    @Override
    public Object visitPawn_white(InputParser.Pawn_whiteContext ctx) {
        return null;
    }

    @Override
    public Object visitPawn_black(InputParser.Pawn_blackContext ctx) {
        return null;
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
