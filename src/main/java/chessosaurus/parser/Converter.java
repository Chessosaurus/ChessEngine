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
        Board board = new Board();
        //Change to parse fen
        board.importFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        //@TODO implement moves Syntax
        List<Move> moves = visitWhitemove(ctx.whitemove());
        for (int i = 0; i < moves.size(); i++) {
            Move move = moves.get(i);
            if (move.getFrom().getPiece().isEmpty()) {
                return null;
            }
            //White special turns
            if (i % 2 == 0) {
                //White-Castle
                castle(board,move,1);
//                if (move.getFrom().isField('e', 1) && move.getFrom().getPiece().get().getType() == PieceType.KING) {
//                    if (move.getTo().isField('c', 1)) {
//                        board = castleTo(board, 'c', 1);
//                        //@TODO diable left white castle
//                        continue;
//                    }
//                    if (move.getTo().isField('g', 1)) {
//                        board = castleTo(board, 'g', 1);
//                        //@TODO disable right white castle
//                        continue;
//                    }
//                }
                //White-En passant
                enPass(board,move,5,6);
//                if (move.getFrom().getFile() != move.getTo().getFile() //File is different
//                        && move.getTo().getPiece().isEmpty()) //To Field is empty
//                {
//                    if (move.getFrom().getPiece().get().getType() == PieceType.PAWN //Pawn Move
//                            && move.getFrom().getRank() == 5//Rank 5 to Rank 6
//                            && move.getTo().getRank() == 6) {
//                        board = enPassant(board, move, Color.WHITE);
//                        continue;
//                    }
//                }
            }
            ;
            //Black special turns
            if (i % 2 == 1) {
                //Black-Castle
                castle(board,move,8);
//                if (move.getFrom().isField('e', 8) && move.getFrom().getPiece().get().getType() == PieceType.KING) {
//                    if (move.getTo().isField('c', 8)) {
//                        board = castleTo(board, 'c', 8);
//                        //@TODO diable left black castle
//                        continue;
//                    }
//                    if (move.getTo().isField('g', 8)) {
//                        board = castleTo(board, 'g', 8);
//                        //@TODO disable right black castle
//                        continue;
//                    }
//                }
                //Black-En passant
                enPass(board,move,4,3);
//                if (move.getFrom().getFile() != move.getTo().getFile() //File is different
//                        && move.getTo().getPiece().isEmpty()) //To Field is empty
//                {
//                    if (move.getFrom().getPiece().get().getType() == PieceType.PAWN //Pawn Move
//                            && move.getFrom().getRank() == 4//Rank 4 to Rank 3
//                            && move.getTo().getRank() == 3) {
//                        board = enPassant(board, move, Color.BLACK);
//                        continue;
//                    }
//                }
            }
            //Normal
            move.getTo().setPiece(move.getFrom().getPiece());
            move.getFrom().setPiece(Optional.empty());
            //Promote
            if(move.getPromoted().isPresent()){
                move.getTo().getPiece().get().setType(move.getPromoted().get());
            }
        }
        return board;
    }
    private boolean castle(Board board, Move move,int rank){
        if (move.getFrom().isField('e', rank) && move.getFrom().getPiece().get().getType() == PieceType.KING) {
            if (move.getTo().isField('c', rank)) {
                board = castleTo(board, 'c', rank);
                //@TODO diable left white castle
                return true;
            }
            if (move.getTo().isField('g', rank)) {
                board = castleTo(board, 'g', rank);
                //@TODO disable right white castle
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

    private boolean enPass(Board board, Move move,int rankFrom, int rankTo){
        if (move.getFrom().getFile() != move.getTo().getFile() //File is different
                && move.getTo().getPiece().isEmpty()) //To Field is empty
        {
            if (move.getFrom().getPiece().get().getType() == PieceType.PAWN //Pawn Move
                    && move.getFrom().getRank() == rankFrom//Rank 4 to Rank 3
                    && move.getTo().getRank() == rankTo) {
                board = enPassant(board, move, Color.BLACK);
                return true;
            }
        }
        return false;
    }
    private Board enPassant(Board board, Move move, Color color) {
        int rankInt = move.getTo().getRank() - 1;
        int fileInt = move.getTo().getFileVal() - 1;
        move.getTo().setPiece(move.getFrom().getPiece());
        move.getFrom().setPiece(Optional.empty());
        board.getChessboard()[color == Color.WHITE ? rankInt - 1 : rankInt + 1][fileInt].setPiece(Optional.empty());
        return board;
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
        for (int i = 7; i >= 0; i--) {
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
        int index = 0;
        for (InputParser.SlotContext sc : ctx.slot()) {
            if (sc.piece()==null) {
                for (int i = 0; i < Integer.parseInt(sc.num().FILE().getText()); i++) {
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
        if (ctx.piece_white()==null) {
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
