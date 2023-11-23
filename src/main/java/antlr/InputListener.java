// Generated from D:/_Studium/S5/ChessEngine/src/main/java/antlr\Input.g4 by ANTLR 4.12.0
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InputParser}.
 */
public interface InputListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InputParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(InputParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(InputParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#moves}.
	 * @param ctx the parse tree
	 */
	void enterMoves(InputParser.MovesContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#moves}.
	 * @param ctx the parse tree
	 */
	void exitMoves(InputParser.MovesContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#whitemove}.
	 * @param ctx the parse tree
	 */
	void enterWhitemove(InputParser.WhitemoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#whitemove}.
	 * @param ctx the parse tree
	 */
	void exitWhitemove(InputParser.WhitemoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#blackmove}.
	 * @param ctx the parse tree
	 */
	void enterBlackmove(InputParser.BlackmoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#blackmove}.
	 * @param ctx the parse tree
	 */
	void exitBlackmove(InputParser.BlackmoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#move}.
	 * @param ctx the parse tree
	 */
	void enterMove(InputParser.MoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#move}.
	 * @param ctx the parse tree
	 */
	void exitMove(InputParser.MoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#promotable}.
	 * @param ctx the parse tree
	 */
	void enterPromotable(InputParser.PromotableContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#promotable}.
	 * @param ctx the parse tree
	 */
	void exitPromotable(InputParser.PromotableContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#rows}.
	 * @param ctx the parse tree
	 */
	void enterRows(InputParser.RowsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#rows}.
	 * @param ctx the parse tree
	 */
	void exitRows(InputParser.RowsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(InputParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(InputParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#single_row}.
	 * @param ctx the parse tree
	 */
	void enterSingle_row(InputParser.Single_rowContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#single_row}.
	 * @param ctx the parse tree
	 */
	void exitSingle_row(InputParser.Single_rowContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#slot}.
	 * @param ctx the parse tree
	 */
	void enterSlot(InputParser.SlotContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#slot}.
	 * @param ctx the parse tree
	 */
	void exitSlot(InputParser.SlotContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#piece}.
	 * @param ctx the parse tree
	 */
	void enterPiece(InputParser.PieceContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#piece}.
	 * @param ctx the parse tree
	 */
	void exitPiece(InputParser.PieceContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(InputParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(InputParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#info}.
	 * @param ctx the parse tree
	 */
	void enterInfo(InputParser.InfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#info}.
	 * @param ctx the parse tree
	 */
	void exitInfo(InputParser.InfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(InputParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(InputParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#castleOptions}.
	 * @param ctx the parse tree
	 */
	void enterCastleOptions(InputParser.CastleOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#castleOptions}.
	 * @param ctx the parse tree
	 */
	void exitCastleOptions(InputParser.CastleOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#square}.
	 * @param ctx the parse tree
	 */
	void enterSquare(InputParser.SquareContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#square}.
	 * @param ctx the parse tree
	 */
	void exitSquare(InputParser.SquareContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#half}.
	 * @param ctx the parse tree
	 */
	void enterHalf(InputParser.HalfContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#half}.
	 * @param ctx the parse tree
	 */
	void exitHalf(InputParser.HalfContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#full}.
	 * @param ctx the parse tree
	 */
	void enterFull(InputParser.FullContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#full}.
	 * @param ctx the parse tree
	 */
	void exitFull(InputParser.FullContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#piece_all}.
	 * @param ctx the parse tree
	 */
	void enterPiece_all(InputParser.Piece_allContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#piece_all}.
	 * @param ctx the parse tree
	 */
	void exitPiece_all(InputParser.Piece_allContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#piece_white}.
	 * @param ctx the parse tree
	 */
	void enterPiece_white(InputParser.Piece_whiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#piece_white}.
	 * @param ctx the parse tree
	 */
	void exitPiece_white(InputParser.Piece_whiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#piece_black}.
	 * @param ctx the parse tree
	 */
	void enterPiece_black(InputParser.Piece_blackContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#piece_black}.
	 * @param ctx the parse tree
	 */
	void exitPiece_black(InputParser.Piece_blackContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#king_white}.
	 * @param ctx the parse tree
	 */
	void enterKing_white(InputParser.King_whiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#king_white}.
	 * @param ctx the parse tree
	 */
	void exitKing_white(InputParser.King_whiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#king_black}.
	 * @param ctx the parse tree
	 */
	void enterKing_black(InputParser.King_blackContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#king_black}.
	 * @param ctx the parse tree
	 */
	void exitKing_black(InputParser.King_blackContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#queen_white}.
	 * @param ctx the parse tree
	 */
	void enterQueen_white(InputParser.Queen_whiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#queen_white}.
	 * @param ctx the parse tree
	 */
	void exitQueen_white(InputParser.Queen_whiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#queen_black}.
	 * @param ctx the parse tree
	 */
	void enterQueen_black(InputParser.Queen_blackContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#queen_black}.
	 * @param ctx the parse tree
	 */
	void exitQueen_black(InputParser.Queen_blackContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#rook_white}.
	 * @param ctx the parse tree
	 */
	void enterRook_white(InputParser.Rook_whiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#rook_white}.
	 * @param ctx the parse tree
	 */
	void exitRook_white(InputParser.Rook_whiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#rook_black}.
	 * @param ctx the parse tree
	 */
	void enterRook_black(InputParser.Rook_blackContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#rook_black}.
	 * @param ctx the parse tree
	 */
	void exitRook_black(InputParser.Rook_blackContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#knight_white}.
	 * @param ctx the parse tree
	 */
	void enterKnight_white(InputParser.Knight_whiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#knight_white}.
	 * @param ctx the parse tree
	 */
	void exitKnight_white(InputParser.Knight_whiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#knight_black}.
	 * @param ctx the parse tree
	 */
	void enterKnight_black(InputParser.Knight_blackContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#knight_black}.
	 * @param ctx the parse tree
	 */
	void exitKnight_black(InputParser.Knight_blackContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#bishop_white}.
	 * @param ctx the parse tree
	 */
	void enterBishop_white(InputParser.Bishop_whiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#bishop_white}.
	 * @param ctx the parse tree
	 */
	void exitBishop_white(InputParser.Bishop_whiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#bishop_black}.
	 * @param ctx the parse tree
	 */
	void enterBishop_black(InputParser.Bishop_blackContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#bishop_black}.
	 * @param ctx the parse tree
	 */
	void exitBishop_black(InputParser.Bishop_blackContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#pawn_white}.
	 * @param ctx the parse tree
	 */
	void enterPawn_white(InputParser.Pawn_whiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#pawn_white}.
	 * @param ctx the parse tree
	 */
	void exitPawn_white(InputParser.Pawn_whiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#pawn_black}.
	 * @param ctx the parse tree
	 */
	void enterPawn_black(InputParser.Pawn_blackContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#pawn_black}.
	 * @param ctx the parse tree
	 */
	void exitPawn_black(InputParser.Pawn_blackContext ctx);
}