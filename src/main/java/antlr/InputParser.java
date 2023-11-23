// Generated from D:/_Studium/S5/ChessEngine/src/main/java/antlr\Input.g4 by ANTLR 4.12.0
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InputParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, WS=2, FILE=3, STARTPOS=4, POSITION=5, MOVES=6, FEN=7, SLASH=8, 
		WHITE=9, KING_WHITE=10, KING_BLACK=11, QUEEN_WHITE=12, QUEEN_BLACK=13, 
		ROOK_WHITE=14, ROOK_BLACK=15, KNIGHT_WHITE=16, KNIGHT_BLACK=17, BISHOP_WHITE=18, 
		BISHOP_BLACK=19, PAWN_WHITE=20, PAWN_BLACK=21, RANK=22, NUMBER=23;
	public static final int
		RULE_start = 0, RULE_moves = 1, RULE_whitemove = 2, RULE_blackmove = 3, 
		RULE_move = 4, RULE_promotable = 5, RULE_rows = 6, RULE_row = 7, RULE_single_row = 8, 
		RULE_slot = 9, RULE_piece = 10, RULE_num = 11, RULE_info = 12, RULE_color = 13, 
		RULE_castleOptions = 14, RULE_square = 15, RULE_half = 16, RULE_full = 17, 
		RULE_piece_all = 18, RULE_piece_white = 19, RULE_piece_black = 20, RULE_king_white = 21, 
		RULE_king_black = 22, RULE_queen = 23, RULE_queen_white = 24, RULE_queen_black = 25, 
		RULE_rook = 26, RULE_rook_white = 27, RULE_rook_black = 28, RULE_knight = 29, 
		RULE_knight_white = 30, RULE_knight_black = 31, RULE_bishop = 32, RULE_bishop_white = 33, 
		RULE_bishop_black = 34, RULE_pawn_white = 35, RULE_pawn_black = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "moves", "whitemove", "blackmove", "move", "promotable", "rows", 
			"row", "single_row", "slot", "piece", "num", "info", "color", "castleOptions", 
			"square", "half", "full", "piece_all", "piece_white", "piece_black", 
			"king_white", "king_black", "queen", "queen_white", "queen_black", "rook", 
			"rook_white", "rook_black", "knight", "knight_white", "knight_black", 
			"bishop", "bishop_white", "bishop_black", "pawn_white", "pawn_black"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", null, null, "'startpos'", "'position'", "'moves'", "'fen'", 
			"'/'", "'w'", "'K'", "'k'", "'Q'", "'q'", "'R'", "'r'", "'N'", "'n'", 
			"'B'", "'b'", "'P'", "'p'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "WS", "FILE", "STARTPOS", "POSITION", "MOVES", "FEN", "SLASH", 
			"WHITE", "KING_WHITE", "KING_BLACK", "QUEEN_WHITE", "QUEEN_BLACK", "ROOK_WHITE", 
			"ROOK_BLACK", "KNIGHT_WHITE", "KNIGHT_BLACK", "BISHOP_WHITE", "BISHOP_BLACK", 
			"PAWN_WHITE", "PAWN_BLACK", "RANK", "NUMBER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Input.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	int lineCount = 0;
	int rowCount = 0;

	public InputParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode POSITION() { return getToken(InputParser.POSITION, 0); }
		public TerminalNode FEN() { return getToken(InputParser.FEN, 0); }
		public RowsContext rows() {
			return getRuleContext(RowsContext.class,0);
		}
		public InfoContext info() {
			return getRuleContext(InfoContext.class,0);
		}
		public TerminalNode STARTPOS() { return getToken(InputParser.STARTPOS, 0); }
		public MovesContext moves() {
			return getRuleContext(MovesContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(POSITION);
				setState(75);
				match(FEN);
				setState(76);
				rows();
				setState(77);
				info();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(POSITION);
				setState(80);
				match(STARTPOS);
				setState(81);
				moves();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MovesContext extends ParserRuleContext {
		public TerminalNode MOVES() { return getToken(InputParser.MOVES, 0); }
		public WhitemoveContext whitemove() {
			return getRuleContext(WhitemoveContext.class,0);
		}
		public MovesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moves; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterMoves(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitMoves(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitMoves(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MovesContext moves() throws RecognitionException {
		MovesContext _localctx = new MovesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_moves);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(MOVES);
			setState(85);
			whitemove();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhitemoveContext extends ParserRuleContext {
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public BlackmoveContext blackmove() {
			return getRuleContext(BlackmoveContext.class,0);
		}
		public WhitemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whitemove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterWhitemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitWhitemove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitWhitemove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhitemoveContext whitemove() throws RecognitionException {
		WhitemoveContext _localctx = new WhitemoveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_whitemove);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				move();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				move();
				setState(89);
				blackmove();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlackmoveContext extends ParserRuleContext {
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public WhitemoveContext whitemove() {
			return getRuleContext(WhitemoveContext.class,0);
		}
		public BlackmoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blackmove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterBlackmove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitBlackmove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitBlackmove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlackmoveContext blackmove() throws RecognitionException {
		BlackmoveContext _localctx = new BlackmoveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_blackmove);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				move();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				move();
				setState(95);
				whitemove();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MoveContext extends ParserRuleContext {
		public List<TerminalNode> RANK() { return getTokens(InputParser.RANK); }
		public TerminalNode RANK(int i) {
			return getToken(InputParser.RANK, i);
		}
		public List<TerminalNode> FILE() { return getTokens(InputParser.FILE); }
		public TerminalNode FILE(int i) {
			return getToken(InputParser.FILE, i);
		}
		public PromotableContext promotable() {
			return getRuleContext(PromotableContext.class,0);
		}
		public MoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_move; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterMove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitMove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoveContext move() throws RecognitionException {
		MoveContext _localctx = new MoveContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_move);
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(RANK);
				setState(100);
				match(FILE);
				setState(101);
				match(RANK);
				setState(102);
				match(FILE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(RANK);
				setState(104);
				match(FILE);
				setState(105);
				match(RANK);
				setState(106);
				match(FILE);
				setState(107);
				promotable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PromotableContext extends ParserRuleContext {
		public QueenContext queen() {
			return getRuleContext(QueenContext.class,0);
		}
		public RookContext rook() {
			return getRuleContext(RookContext.class,0);
		}
		public KnightContext knight() {
			return getRuleContext(KnightContext.class,0);
		}
		public BishopContext bishop() {
			return getRuleContext(BishopContext.class,0);
		}
		public PromotableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_promotable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterPromotable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitPromotable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitPromotable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PromotableContext promotable() throws RecognitionException {
		PromotableContext _localctx = new PromotableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_promotable);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUEEN_WHITE:
			case QUEEN_BLACK:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				queen();
				}
				break;
			case ROOK_WHITE:
			case ROOK_BLACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				rook();
				}
				break;
			case KNIGHT_WHITE:
			case KNIGHT_BLACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				knight();
				}
				break;
			case BISHOP_WHITE:
			case BISHOP_BLACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				bishop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RowsContext extends ParserRuleContext {
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public List<TerminalNode> SLASH() { return getTokens(InputParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(InputParser.SLASH, i);
		}
		public RowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterRows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitRows(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitRows(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowsContext rows() throws RecognitionException {
		RowsContext _localctx = new RowsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rows);
		rowCount = 0;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(116);
					row();
					setState(117);
					match(SLASH);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(121); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(123);
			row();
			setState(124);
			if (!(lineCount == 8)) throw new FailedPredicateException(this, "lineCount == 8");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RowContext extends ParserRuleContext {
		public Single_rowContext single_row() {
			return getRuleContext(Single_rowContext.class,0);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitRow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_row);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			single_row();
			lineCount++;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Single_rowContext extends ParserRuleContext {
		public List<SlotContext> slot() {
			return getRuleContexts(SlotContext.class);
		}
		public SlotContext slot(int i) {
			return getRuleContext(SlotContext.class,i);
		}
		public Single_rowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterSingle_row(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitSingle_row(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitSingle_row(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_rowContext single_row() throws RecognitionException {
		Single_rowContext _localctx = new Single_rowContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_single_row);
		rowCount = 0;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(129);
					slot();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(132); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(134);
			if (!(rowCount == 8)) throw new FailedPredicateException(this, "rowCount == 8");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SlotContext extends ParserRuleContext {
		public PieceContext piece() {
			return getRuleContext(PieceContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public SlotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterSlot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitSlot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitSlot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotContext slot() throws RecognitionException {
		SlotContext _localctx = new SlotContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_slot);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KING_WHITE:
			case KING_BLACK:
			case QUEEN_WHITE:
			case QUEEN_BLACK:
			case ROOK_WHITE:
			case ROOK_BLACK:
			case KNIGHT_WHITE:
			case KNIGHT_BLACK:
			case BISHOP_WHITE:
			case BISHOP_BLACK:
			case PAWN_WHITE:
			case PAWN_BLACK:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				piece();
				}
				break;
			case FILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				num();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PieceContext extends ParserRuleContext {
		public Piece_allContext piece_all() {
			return getRuleContext(Piece_allContext.class,0);
		}
		public PieceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_piece; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterPiece(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitPiece(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitPiece(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PieceContext piece() throws RecognitionException {
		PieceContext _localctx = new PieceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_piece);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			piece_all();
			rowCount++;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumContext extends ParserRuleContext {
		public TerminalNode FILE() { return getToken(InputParser.FILE, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(FILE);
			rowCount+=Integer.valueOf(_input.getText(_localctx.start, _input.LT(-1)));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InfoContext extends ParserRuleContext {
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public CastleOptionsContext castleOptions() {
			return getRuleContext(CastleOptionsContext.class,0);
		}
		public SquareContext square() {
			return getRuleContext(SquareContext.class,0);
		}
		public HalfContext half() {
			return getRuleContext(HalfContext.class,0);
		}
		public FullContext full() {
			return getRuleContext(FullContext.class,0);
		}
		public InfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_info; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfoContext info() throws RecognitionException {
		InfoContext _localctx = new InfoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			color();
			setState(147);
			castleOptions();
			setState(148);
			square();
			setState(149);
			half();
			setState(150);
			full();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColorContext extends ParserRuleContext {
		public TerminalNode WHITE() { return getToken(InputParser.WHITE, 0); }
		public TerminalNode BISHOP_BLACK() { return getToken(InputParser.BISHOP_BLACK, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_color);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !(_la==WHITE || _la==BISHOP_BLACK) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastleOptionsContext extends ParserRuleContext {
		public King_whiteContext king_white() {
			return getRuleContext(King_whiteContext.class,0);
		}
		public Queen_whiteContext queen_white() {
			return getRuleContext(Queen_whiteContext.class,0);
		}
		public King_blackContext king_black() {
			return getRuleContext(King_blackContext.class,0);
		}
		public Queen_blackContext queen_black() {
			return getRuleContext(Queen_blackContext.class,0);
		}
		public CastleOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castleOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterCastleOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitCastleOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitCastleOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastleOptionsContext castleOptions() throws RecognitionException {
		CastleOptionsContext _localctx = new CastleOptionsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_castleOptions);
		int _la;
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KING_WHITE) {
					{
					setState(155);
					king_white();
					}
				}

				}
				{
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUEEN_WHITE) {
					{
					setState(158);
					queen_white();
					}
				}

				}
				{
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KING_BLACK) {
					{
					setState(161);
					king_black();
					}
				}

				}
				{
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUEEN_BLACK) {
					{
					setState(164);
					queen_black();
					}
				}

				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SquareContext extends ParserRuleContext {
		public TerminalNode RANK() { return getToken(InputParser.RANK, 0); }
		public TerminalNode FILE() { return getToken(InputParser.FILE, 0); }
		public SquareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_square; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterSquare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitSquare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitSquare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareContext square() throws RecognitionException {
		SquareContext _localctx = new SquareContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_square);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(T__0);
				}
				break;
			case RANK:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(RANK);
				setState(171);
				match(FILE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HalfContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(InputParser.NUMBER, 0); }
		public HalfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_half; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterHalf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitHalf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitHalf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HalfContext half() throws RecognitionException {
		HalfContext _localctx = new HalfContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_half);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FullContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(InputParser.NUMBER, 0); }
		public FullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_full; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterFull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitFull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitFull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullContext full() throws RecognitionException {
		FullContext _localctx = new FullContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_full);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Piece_allContext extends ParserRuleContext {
		public Piece_whiteContext piece_white() {
			return getRuleContext(Piece_whiteContext.class,0);
		}
		public Piece_blackContext piece_black() {
			return getRuleContext(Piece_blackContext.class,0);
		}
		public Piece_allContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_piece_all; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterPiece_all(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitPiece_all(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitPiece_all(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Piece_allContext piece_all() throws RecognitionException {
		Piece_allContext _localctx = new Piece_allContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_piece_all);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KING_WHITE:
			case QUEEN_WHITE:
			case ROOK_WHITE:
			case KNIGHT_WHITE:
			case BISHOP_WHITE:
			case PAWN_WHITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				piece_white();
				}
				break;
			case KING_BLACK:
			case QUEEN_BLACK:
			case ROOK_BLACK:
			case KNIGHT_BLACK:
			case BISHOP_BLACK:
			case PAWN_BLACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				piece_black();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Piece_whiteContext extends ParserRuleContext {
		public King_whiteContext king_white() {
			return getRuleContext(King_whiteContext.class,0);
		}
		public Queen_whiteContext queen_white() {
			return getRuleContext(Queen_whiteContext.class,0);
		}
		public Rook_whiteContext rook_white() {
			return getRuleContext(Rook_whiteContext.class,0);
		}
		public Knight_whiteContext knight_white() {
			return getRuleContext(Knight_whiteContext.class,0);
		}
		public Bishop_whiteContext bishop_white() {
			return getRuleContext(Bishop_whiteContext.class,0);
		}
		public Pawn_whiteContext pawn_white() {
			return getRuleContext(Pawn_whiteContext.class,0);
		}
		public Piece_whiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_piece_white; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterPiece_white(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitPiece_white(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitPiece_white(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Piece_whiteContext piece_white() throws RecognitionException {
		Piece_whiteContext _localctx = new Piece_whiteContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_piece_white);
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KING_WHITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				king_white();
				}
				break;
			case QUEEN_WHITE:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				queen_white();
				}
				break;
			case ROOK_WHITE:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				rook_white();
				}
				break;
			case KNIGHT_WHITE:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				knight_white();
				}
				break;
			case BISHOP_WHITE:
				enterOuterAlt(_localctx, 5);
				{
				setState(186);
				bishop_white();
				}
				break;
			case PAWN_WHITE:
				enterOuterAlt(_localctx, 6);
				{
				setState(187);
				pawn_white();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Piece_blackContext extends ParserRuleContext {
		public King_blackContext king_black() {
			return getRuleContext(King_blackContext.class,0);
		}
		public Queen_blackContext queen_black() {
			return getRuleContext(Queen_blackContext.class,0);
		}
		public Rook_blackContext rook_black() {
			return getRuleContext(Rook_blackContext.class,0);
		}
		public Knight_blackContext knight_black() {
			return getRuleContext(Knight_blackContext.class,0);
		}
		public Bishop_blackContext bishop_black() {
			return getRuleContext(Bishop_blackContext.class,0);
		}
		public Pawn_blackContext pawn_black() {
			return getRuleContext(Pawn_blackContext.class,0);
		}
		public Piece_blackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_piece_black; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterPiece_black(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitPiece_black(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitPiece_black(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Piece_blackContext piece_black() throws RecognitionException {
		Piece_blackContext _localctx = new Piece_blackContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_piece_black);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KING_BLACK:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				king_black();
				}
				break;
			case QUEEN_BLACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				queen_black();
				}
				break;
			case ROOK_BLACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				rook_black();
				}
				break;
			case KNIGHT_BLACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				knight_black();
				}
				break;
			case BISHOP_BLACK:
				enterOuterAlt(_localctx, 5);
				{
				setState(194);
				bishop_black();
				}
				break;
			case PAWN_BLACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(195);
				pawn_black();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class King_whiteContext extends ParserRuleContext {
		public TerminalNode KING_WHITE() { return getToken(InputParser.KING_WHITE, 0); }
		public King_whiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_king_white; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterKing_white(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitKing_white(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitKing_white(this);
			else return visitor.visitChildren(this);
		}
	}

	public final King_whiteContext king_white() throws RecognitionException {
		King_whiteContext _localctx = new King_whiteContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_king_white);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(KING_WHITE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class King_blackContext extends ParserRuleContext {
		public TerminalNode KING_BLACK() { return getToken(InputParser.KING_BLACK, 0); }
		public King_blackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_king_black; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterKing_black(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitKing_black(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitKing_black(this);
			else return visitor.visitChildren(this);
		}
	}

	public final King_blackContext king_black() throws RecognitionException {
		King_blackContext _localctx = new King_blackContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_king_black);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(KING_BLACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueenContext extends ParserRuleContext {
		public Queen_whiteContext queen_white() {
			return getRuleContext(Queen_whiteContext.class,0);
		}
		public Queen_blackContext queen_black() {
			return getRuleContext(Queen_blackContext.class,0);
		}
		public QueenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterQueen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitQueen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitQueen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueenContext queen() throws RecognitionException {
		QueenContext _localctx = new QueenContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_queen);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUEEN_WHITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				queen_white();
				}
				break;
			case QUEEN_BLACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				queen_black();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Queen_whiteContext extends ParserRuleContext {
		public TerminalNode QUEEN_WHITE() { return getToken(InputParser.QUEEN_WHITE, 0); }
		public Queen_whiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queen_white; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterQueen_white(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitQueen_white(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitQueen_white(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Queen_whiteContext queen_white() throws RecognitionException {
		Queen_whiteContext _localctx = new Queen_whiteContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_queen_white);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(QUEEN_WHITE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Queen_blackContext extends ParserRuleContext {
		public TerminalNode QUEEN_BLACK() { return getToken(InputParser.QUEEN_BLACK, 0); }
		public Queen_blackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queen_black; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterQueen_black(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitQueen_black(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitQueen_black(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Queen_blackContext queen_black() throws RecognitionException {
		Queen_blackContext _localctx = new Queen_blackContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_queen_black);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(QUEEN_BLACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RookContext extends ParserRuleContext {
		public Rook_whiteContext rook_white() {
			return getRuleContext(Rook_whiteContext.class,0);
		}
		public Rook_blackContext rook_black() {
			return getRuleContext(Rook_blackContext.class,0);
		}
		public RookContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rook; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterRook(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitRook(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitRook(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RookContext rook() throws RecognitionException {
		RookContext _localctx = new RookContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_rook);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ROOK_WHITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				rook_white();
				}
				break;
			case ROOK_BLACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				rook_black();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rook_whiteContext extends ParserRuleContext {
		public TerminalNode ROOK_WHITE() { return getToken(InputParser.ROOK_WHITE, 0); }
		public Rook_whiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rook_white; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterRook_white(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitRook_white(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitRook_white(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rook_whiteContext rook_white() throws RecognitionException {
		Rook_whiteContext _localctx = new Rook_whiteContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rook_white);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(ROOK_WHITE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rook_blackContext extends ParserRuleContext {
		public TerminalNode ROOK_BLACK() { return getToken(InputParser.ROOK_BLACK, 0); }
		public Rook_blackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rook_black; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterRook_black(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitRook_black(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitRook_black(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rook_blackContext rook_black() throws RecognitionException {
		Rook_blackContext _localctx = new Rook_blackContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_rook_black);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(ROOK_BLACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KnightContext extends ParserRuleContext {
		public Knight_whiteContext knight_white() {
			return getRuleContext(Knight_whiteContext.class,0);
		}
		public Knight_blackContext knight_black() {
			return getRuleContext(Knight_blackContext.class,0);
		}
		public KnightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterKnight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitKnight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitKnight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KnightContext knight() throws RecognitionException {
		KnightContext _localctx = new KnightContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_knight);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KNIGHT_WHITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				knight_white();
				}
				break;
			case KNIGHT_BLACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				knight_black();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Knight_whiteContext extends ParserRuleContext {
		public TerminalNode KNIGHT_WHITE() { return getToken(InputParser.KNIGHT_WHITE, 0); }
		public Knight_whiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knight_white; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterKnight_white(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitKnight_white(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitKnight_white(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Knight_whiteContext knight_white() throws RecognitionException {
		Knight_whiteContext _localctx = new Knight_whiteContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_knight_white);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(KNIGHT_WHITE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Knight_blackContext extends ParserRuleContext {
		public TerminalNode KNIGHT_BLACK() { return getToken(InputParser.KNIGHT_BLACK, 0); }
		public Knight_blackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knight_black; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterKnight_black(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitKnight_black(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitKnight_black(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Knight_blackContext knight_black() throws RecognitionException {
		Knight_blackContext _localctx = new Knight_blackContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_knight_black);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(KNIGHT_BLACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BishopContext extends ParserRuleContext {
		public Bishop_whiteContext bishop_white() {
			return getRuleContext(Bishop_whiteContext.class,0);
		}
		public Bishop_blackContext bishop_black() {
			return getRuleContext(Bishop_blackContext.class,0);
		}
		public BishopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bishop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterBishop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitBishop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitBishop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BishopContext bishop() throws RecognitionException {
		BishopContext _localctx = new BishopContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_bishop);
		try {
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BISHOP_WHITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				bishop_white();
				}
				break;
			case BISHOP_BLACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				bishop_black();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Bishop_whiteContext extends ParserRuleContext {
		public TerminalNode BISHOP_WHITE() { return getToken(InputParser.BISHOP_WHITE, 0); }
		public Bishop_whiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bishop_white; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterBishop_white(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitBishop_white(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitBishop_white(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bishop_whiteContext bishop_white() throws RecognitionException {
		Bishop_whiteContext _localctx = new Bishop_whiteContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_bishop_white);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(BISHOP_WHITE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Bishop_blackContext extends ParserRuleContext {
		public TerminalNode BISHOP_BLACK() { return getToken(InputParser.BISHOP_BLACK, 0); }
		public Bishop_blackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bishop_black; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterBishop_black(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitBishop_black(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitBishop_black(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bishop_blackContext bishop_black() throws RecognitionException {
		Bishop_blackContext _localctx = new Bishop_blackContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_bishop_black);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(BISHOP_BLACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pawn_whiteContext extends ParserRuleContext {
		public TerminalNode PAWN_WHITE() { return getToken(InputParser.PAWN_WHITE, 0); }
		public Pawn_whiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pawn_white; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterPawn_white(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitPawn_white(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitPawn_white(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pawn_whiteContext pawn_white() throws RecognitionException {
		Pawn_whiteContext _localctx = new Pawn_whiteContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_pawn_white);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(PAWN_WHITE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pawn_blackContext extends ParserRuleContext {
		public TerminalNode PAWN_BLACK() { return getToken(InputParser.PAWN_BLACK, 0); }
		public Pawn_blackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pawn_black; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterPawn_black(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitPawn_black(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitPawn_black(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pawn_blackContext pawn_black() throws RecognitionException {
		Pawn_blackContext _localctx = new Pawn_blackContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_pawn_black);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(PAWN_BLACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return rows_sempred((RowsContext)_localctx, predIndex);
		case 8:
			return single_row_sempred((Single_rowContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rows_sempred(RowsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return lineCount == 8;
		}
		return true;
	}
	private boolean single_row_sempred(Single_rowContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return rowCount == 8;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u00ef\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000S\b"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\\\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003b\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004m\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005s\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0004"+
		"\u0006x\b\u0006\u000b\u0006\f\u0006y\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0004\b\u0083\b\b\u000b\b"+
		"\f\b\u0084\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u008b\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u009d\b\u000e\u0001\u000e\u0003\u000e\u00a0\b\u000e\u0001\u000e"+
		"\u0003\u000e\u00a3\b\u000e\u0001\u000e\u0003\u000e\u00a6\b\u000e\u0003"+
		"\u000e\u00a8\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00ad"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u00b5\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00bd\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00c5"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u00cd\b\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u00d5\b\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u00dd"+
		"\b\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0003 \u00e5\b \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0000\u0000%\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFH\u0000\u0001"+
		"\u0002\u0000\t\t\u0013\u0013\u00e8\u0000R\u0001\u0000\u0000\u0000\u0002"+
		"T\u0001\u0000\u0000\u0000\u0004[\u0001\u0000\u0000\u0000\u0006a\u0001"+
		"\u0000\u0000\u0000\bl\u0001\u0000\u0000\u0000\nr\u0001\u0000\u0000\u0000"+
		"\fw\u0001\u0000\u0000\u0000\u000e~\u0001\u0000\u0000\u0000\u0010\u0082"+
		"\u0001\u0000\u0000\u0000\u0012\u008a\u0001\u0000\u0000\u0000\u0014\u008c"+
		"\u0001\u0000\u0000\u0000\u0016\u008f\u0001\u0000\u0000\u0000\u0018\u0092"+
		"\u0001\u0000\u0000\u0000\u001a\u0098\u0001\u0000\u0000\u0000\u001c\u00a7"+
		"\u0001\u0000\u0000\u0000\u001e\u00ac\u0001\u0000\u0000\u0000 \u00ae\u0001"+
		"\u0000\u0000\u0000\"\u00b0\u0001\u0000\u0000\u0000$\u00b4\u0001\u0000"+
		"\u0000\u0000&\u00bc\u0001\u0000\u0000\u0000(\u00c4\u0001\u0000\u0000\u0000"+
		"*\u00c6\u0001\u0000\u0000\u0000,\u00c8\u0001\u0000\u0000\u0000.\u00cc"+
		"\u0001\u0000\u0000\u00000\u00ce\u0001\u0000\u0000\u00002\u00d0\u0001\u0000"+
		"\u0000\u00004\u00d4\u0001\u0000\u0000\u00006\u00d6\u0001\u0000\u0000\u0000"+
		"8\u00d8\u0001\u0000\u0000\u0000:\u00dc\u0001\u0000\u0000\u0000<\u00de"+
		"\u0001\u0000\u0000\u0000>\u00e0\u0001\u0000\u0000\u0000@\u00e4\u0001\u0000"+
		"\u0000\u0000B\u00e6\u0001\u0000\u0000\u0000D\u00e8\u0001\u0000\u0000\u0000"+
		"F\u00ea\u0001\u0000\u0000\u0000H\u00ec\u0001\u0000\u0000\u0000JK\u0005"+
		"\u0005\u0000\u0000KL\u0005\u0007\u0000\u0000LM\u0003\f\u0006\u0000MN\u0003"+
		"\u0018\f\u0000NS\u0001\u0000\u0000\u0000OP\u0005\u0005\u0000\u0000PQ\u0005"+
		"\u0004\u0000\u0000QS\u0003\u0002\u0001\u0000RJ\u0001\u0000\u0000\u0000"+
		"RO\u0001\u0000\u0000\u0000S\u0001\u0001\u0000\u0000\u0000TU\u0005\u0006"+
		"\u0000\u0000UV\u0003\u0004\u0002\u0000V\u0003\u0001\u0000\u0000\u0000"+
		"W\\\u0003\b\u0004\u0000XY\u0003\b\u0004\u0000YZ\u0003\u0006\u0003\u0000"+
		"Z\\\u0001\u0000\u0000\u0000[W\u0001\u0000\u0000\u0000[X\u0001\u0000\u0000"+
		"\u0000\\\u0005\u0001\u0000\u0000\u0000]b\u0003\b\u0004\u0000^_\u0003\b"+
		"\u0004\u0000_`\u0003\u0004\u0002\u0000`b\u0001\u0000\u0000\u0000a]\u0001"+
		"\u0000\u0000\u0000a^\u0001\u0000\u0000\u0000b\u0007\u0001\u0000\u0000"+
		"\u0000cd\u0005\u0016\u0000\u0000de\u0005\u0003\u0000\u0000ef\u0005\u0016"+
		"\u0000\u0000fm\u0005\u0003\u0000\u0000gh\u0005\u0016\u0000\u0000hi\u0005"+
		"\u0003\u0000\u0000ij\u0005\u0016\u0000\u0000jk\u0005\u0003\u0000\u0000"+
		"km\u0003\n\u0005\u0000lc\u0001\u0000\u0000\u0000lg\u0001\u0000\u0000\u0000"+
		"m\t\u0001\u0000\u0000\u0000ns\u0003.\u0017\u0000os\u00034\u001a\u0000"+
		"ps\u0003:\u001d\u0000qs\u0003@ \u0000rn\u0001\u0000\u0000\u0000ro\u0001"+
		"\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000"+
		"s\u000b\u0001\u0000\u0000\u0000tu\u0003\u000e\u0007\u0000uv\u0005\b\u0000"+
		"\u0000vx\u0001\u0000\u0000\u0000wt\u0001\u0000\u0000\u0000xy\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{|\u0003\u000e\u0007\u0000|}\u0004\u0006\u0000\u0000"+
		"}\r\u0001\u0000\u0000\u0000~\u007f\u0003\u0010\b\u0000\u007f\u0080\u0006"+
		"\u0007\uffff\uffff\u0000\u0080\u000f\u0001\u0000\u0000\u0000\u0081\u0083"+
		"\u0003\u0012\t\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0004"+
		"\b\u0001\u0000\u0087\u0011\u0001\u0000\u0000\u0000\u0088\u008b\u0003\u0014"+
		"\n\u0000\u0089\u008b\u0003\u0016\u000b\u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u0013\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0003$\u0012\u0000\u008d\u008e\u0006\n\uffff\uffff"+
		"\u0000\u008e\u0015\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0003\u0000"+
		"\u0000\u0090\u0091\u0006\u000b\uffff\uffff\u0000\u0091\u0017\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0003\u001a\r\u0000\u0093\u0094\u0003\u001c\u000e"+
		"\u0000\u0094\u0095\u0003\u001e\u000f\u0000\u0095\u0096\u0003 \u0010\u0000"+
		"\u0096\u0097\u0003\"\u0011\u0000\u0097\u0019\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0007\u0000\u0000\u0000\u0099\u001b\u0001\u0000\u0000\u0000\u009a"+
		"\u00a8\u0005\u0001\u0000\u0000\u009b\u009d\u0003*\u0015\u0000\u009c\u009b"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009f"+
		"\u0001\u0000\u0000\u0000\u009e\u00a0\u00030\u0018\u0000\u009f\u009e\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a3\u0003,\u0016\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a6\u00032\u0019\u0000\u00a5\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a7\u009a\u0001\u0000\u0000\u0000\u00a7\u009c\u0001\u0000\u0000"+
		"\u0000\u00a8\u001d\u0001\u0000\u0000\u0000\u00a9\u00ad\u0005\u0001\u0000"+
		"\u0000\u00aa\u00ab\u0005\u0016\u0000\u0000\u00ab\u00ad\u0005\u0003\u0000"+
		"\u0000\u00ac\u00a9\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ad\u001f\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0017\u0000"+
		"\u0000\u00af!\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0017\u0000\u0000"+
		"\u00b1#\u0001\u0000\u0000\u0000\u00b2\u00b5\u0003&\u0013\u0000\u00b3\u00b5"+
		"\u0003(\u0014\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b5%\u0001\u0000\u0000\u0000\u00b6\u00bd\u0003*\u0015"+
		"\u0000\u00b7\u00bd\u00030\u0018\u0000\u00b8\u00bd\u00036\u001b\u0000\u00b9"+
		"\u00bd\u0003<\u001e\u0000\u00ba\u00bd\u0003B!\u0000\u00bb\u00bd\u0003"+
		"F#\u0000\u00bc\u00b6\u0001\u0000\u0000\u0000\u00bc\u00b7\u0001\u0000\u0000"+
		"\u0000\u00bc\u00b8\u0001\u0000\u0000\u0000\u00bc\u00b9\u0001\u0000\u0000"+
		"\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bd\'\u0001\u0000\u0000\u0000\u00be\u00c5\u0003,\u0016\u0000"+
		"\u00bf\u00c5\u00032\u0019\u0000\u00c0\u00c5\u00038\u001c\u0000\u00c1\u00c5"+
		"\u0003>\u001f\u0000\u00c2\u00c5\u0003D\"\u0000\u00c3\u00c5\u0003H$\u0000"+
		"\u00c4\u00be\u0001\u0000\u0000\u0000\u00c4\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c0\u0001\u0000\u0000\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c5)\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\n\u0000\u0000\u00c7"+
		"+\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u000b\u0000\u0000\u00c9-\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cd\u00030\u0018\u0000\u00cb\u00cd\u00032\u0019"+
		"\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cd/\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\f\u0000\u0000"+
		"\u00cf1\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005\r\u0000\u0000\u00d1"+
		"3\u0001\u0000\u0000\u0000\u00d2\u00d5\u00036\u001b\u0000\u00d3\u00d5\u0003"+
		"8\u001c\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d55\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u000e\u0000"+
		"\u0000\u00d77\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u000f\u0000\u0000"+
		"\u00d99\u0001\u0000\u0000\u0000\u00da\u00dd\u0003<\u001e\u0000\u00db\u00dd"+
		"\u0003>\u001f\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00db\u0001"+
		"\u0000\u0000\u0000\u00dd;\u0001\u0000\u0000\u0000\u00de\u00df\u0005\u0010"+
		"\u0000\u0000\u00df=\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\u0011\u0000"+
		"\u0000\u00e1?\u0001\u0000\u0000\u0000\u00e2\u00e5\u0003B!\u0000\u00e3"+
		"\u00e5\u0003D\"\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e5A\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005"+
		"\u0012\u0000\u0000\u00e7C\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005\u0013"+
		"\u0000\u0000\u00e9E\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\u0014\u0000"+
		"\u0000\u00ebG\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0015\u0000\u0000"+
		"\u00edI\u0001\u0000\u0000\u0000\u0015R[alry\u0084\u008a\u009c\u009f\u00a2"+
		"\u00a5\u00a7\u00ac\u00b4\u00bc\u00c4\u00cc\u00d4\u00dc\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}