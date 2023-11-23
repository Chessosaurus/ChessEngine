// Generated from D:/_Studium/S5/ChessEngine/src/main/java/antlr\Input.g4 by ANTLR 4.12.0
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InputParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InputVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InputParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(InputParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#moves}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoves(InputParser.MovesContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#whitemove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhitemove(InputParser.WhitemoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#blackmove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlackmove(InputParser.BlackmoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#move}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMove(InputParser.MoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#promotable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPromotable(InputParser.PromotableContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#rows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRows(InputParser.RowsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(InputParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#single_row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_row(InputParser.Single_rowContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#slot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlot(InputParser.SlotContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#piece}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiece(InputParser.PieceContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(InputParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfo(InputParser.InfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(InputParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#castleOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastleOptions(InputParser.CastleOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#square}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquare(InputParser.SquareContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#half}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalf(InputParser.HalfContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#full}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull(InputParser.FullContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#piece_all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiece_all(InputParser.Piece_allContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#piece_white}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiece_white(InputParser.Piece_whiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#piece_black}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiece_black(InputParser.Piece_blackContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#king_white}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKing_white(InputParser.King_whiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#king_black}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKing_black(InputParser.King_blackContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#queen_white}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueen_white(InputParser.Queen_whiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#queen_black}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueen_black(InputParser.Queen_blackContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#rook_white}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRook_white(InputParser.Rook_whiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#rook_black}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRook_black(InputParser.Rook_blackContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#knight_white}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnight_white(InputParser.Knight_whiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#knight_black}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnight_black(InputParser.Knight_blackContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#bishop_white}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBishop_white(InputParser.Bishop_whiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#bishop_black}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBishop_black(InputParser.Bishop_blackContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#pawn_white}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPawn_white(InputParser.Pawn_whiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#pawn_black}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPawn_black(InputParser.Pawn_blackContext ctx);
}