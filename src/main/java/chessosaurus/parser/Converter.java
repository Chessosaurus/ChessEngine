package chessosaurus.parser;

import antlr.InputParser;
import antlr.InputVisitor;
import chessosaurus.base.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Converter implements InputVisitor {
    @Override
    public Board visitStart(InputParser.StartContext ctx) {
        if (ctx.FEN() != null) {
            Board b = visitRows(ctx.rows());
            //info not yet used in board, would have to be implemented here
            return b;
        }
        //arithmetic notation
        else {
            return visitMoves(ctx.moves());
        }
    }

    @Override
    public Board visitMoves(InputParser.MovesContext ctx) {
        Board b = new Board();
        b.importFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        //@TODO implement moves Syntax
        //List all moves, then execute them all in order
        List<Move> moves = visitWhitemove(ctx.whitemove());
        for (Move m : moves) {
            Piece p = b.getChessboard()
                    [m.getFrom().getRank()]
                    [m.getFrom().getFile()]
                    .getPiece().get();
            if(m.getPromoted().isPresent()){
                p.setType(m.getPromoted().get());
            }
            b.getChessboard()
                    [m.getFrom().getRank()]
                    [m.getFrom().getFile()]
                    .setPiece(Optional.empty());
            b.getChessboard()
                    [m.getTo().getRank()]
                    [m.getTo().getFile()]
                    .setPiece(p);
        }
        return b;
    }

    @Override
    public List<Move> visitWhitemove(InputParser.WhitemoveContext ctx) {
        List<Move> moves = new ArrayList<>();
        moves.add(visitMove(ctx.move()));
        if (ctx.blackmove().isEmpty()) {
            return moves;
        }
        moves.addAll(visitBlackmove(ctx.blackmove()));
        return moves;
    }

    @Override
    public List<Move> visitBlackmove(InputParser.BlackmoveContext ctx) {
        List<Move> moves = new ArrayList<>();
        moves.add(visitMove(ctx.move()));
        if (ctx.whitemove().isEmpty()) {
            return moves;
        }
        moves.addAll(visitWhitemove(ctx.whitemove()));
        return moves;
    }

    @Override
    public Move visitMove(InputParser.MoveContext ctx) {

        Square from = new Square(Integer.parseInt(ctx.RANK(0).getText()),
                ctx.FILE(0).getText().charAt(0));
        Square to = new Square(Integer.parseInt(ctx.RANK(1).getText()),
                ctx.FILE(1).getText().charAt(0));
        return ctx.promotable().isEmpty() ?
                new Move(from, to)
                : new Move(from, to, visitPromotable(ctx.promotable()));
    }

    @Override
    public PieceType visitPromotable(InputParser.PromotableContext ctx) {
        if (!ctx.queen().isEmpty()) return PieceType.QUEEN;
        if (!ctx.rook().isEmpty()) return PieceType.ROOK;
        if (!ctx.knight().isEmpty()) return PieceType.KNIGHT;
        /*if (!ctx.bishop().isEmpty())*/
        return PieceType.BISHOP;
    }

    @Override
    public Board visitRows(InputParser.RowsContext ctx) {
        Board b = new Board();
        for (int i = 8; i > 0; i--) {
            b.setRank(i, visitSingle_row(ctx.row(i).single_row()));
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
        int index = 1;
        for (InputParser.SlotContext sc : ctx.slot()) {
            if (sc.piece().isEmpty()) {
                for (int i = 0; i < Integer.parseInt(sc.num().FILE().getText()); i++) {
                    rank[index++] = Optional.empty();
                }
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
    public Object visitInfo(InputParser.InfoContext ctx) {
        return null;
    }

    @Override
    public Object visitColor(InputParser.ColorContext ctx) {
        return null;
    }

    @Override
    public Object visitCastleOptions(InputParser.CastleOptionsContext ctx) {
        return null;
    }

    @Override
    public Object visitSquare(InputParser.SquareContext ctx) {
        return null;
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
        if (ctx.piece_white().isEmpty()) {
            return visitPiece_black(ctx.piece_black());
        } else {
            return visitPiece_white(ctx.piece_white());
        }
    }

    @Override
    public Piece visitPiece_white(InputParser.Piece_whiteContext ctx) {
        if (!ctx.king_white().isEmpty()) return new Piece(PieceType.KING, Color.WHITE);
        if (!ctx.queen_white().isEmpty()) return new Piece(PieceType.QUEEN, Color.WHITE);
        if (!ctx.rook_white().isEmpty()) return new Piece(PieceType.ROOK, Color.WHITE);
        if (!ctx.knight_white().isEmpty()) return new Piece(PieceType.KNIGHT, Color.WHITE);
        if (!ctx.bishop_white().isEmpty()) return new Piece(PieceType.BISHOP, Color.WHITE);
        return new Piece(PieceType.PAWN, Color.WHITE);
    }

    @Override
    public Piece visitPiece_black(InputParser.Piece_blackContext ctx) {
        if (!ctx.king_black().isEmpty()) return new Piece(PieceType.KING, Color.BLACK);
        if (!ctx.queen_black().isEmpty()) return new Piece(PieceType.QUEEN, Color.BLACK);
        if (!ctx.rook_black().isEmpty()) return new Piece(PieceType.ROOK, Color.BLACK);
        if (!ctx.knight_black().isEmpty()) return new Piece(PieceType.KNIGHT, Color.BLACK);
        if (!ctx.bishop_black().isEmpty()) return new Piece(PieceType.BISHOP, Color.BLACK);
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
