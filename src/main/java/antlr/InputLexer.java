// Generated from D:/Github/Github/ChessEngine/src/main/java/antlr\Input.g4 by ANTLR 4.12.0
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InputLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, WS=2, STARTPOS=3, POSITION=4, MOVES=5, MOVE=6, FEN=7, SLASH=8, 
		WHITE=9, KING_WHITE=10, KING_BLACK=11, QUEEN_WHITE=12, QUEEN_BLACK=13, 
		ROOK_WHITE=14, ROOK_BLACK=15, KNIGHT_WHITE=16, KNIGHT_BLACK=17, BISHOP_WHITE=18, 
		BISHOP_BLACK=19, PAWN_WHITE=20, PAWN_BLACK=21, FILE=22, NUMBER=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "WS", "STARTPOS", "POSITION", "MOVES", "MOVE", "FEN", "SLASH", 
			"WHITE", "KING_WHITE", "KING_BLACK", "QUEEN_WHITE", "QUEEN_BLACK", "ROOK_WHITE", 
			"ROOK_BLACK", "KNIGHT_WHITE", "KNIGHT_BLACK", "BISHOP_WHITE", "BISHOP_BLACK", 
			"PAWN_WHITE", "PAWN_BLACK", "FILE", "NUMBER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", null, "'startpos'", "'position'", "'moves'", null, "'fen'", 
			"'/'", "'w'", "'K'", "'k'", "'Q'", "'q'", "'R'", "'r'", "'N'", "'n'", 
			"'B'", "'b'", "'P'", "'p'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "WS", "STARTPOS", "POSITION", "MOVES", "MOVE", "FEN", "SLASH", 
			"WHITE", "KING_WHITE", "KING_BLACK", "QUEEN_WHITE", "QUEEN_BLACK", "ROOK_WHITE", 
			"ROOK_BLACK", "KNIGHT_WHITE", "KNIGHT_BLACK", "BISHOP_WHITE", "BISHOP_BLACK", 
			"PAWN_WHITE", "PAWN_BLACK", "FILE", "NUMBER"
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


	public InputLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Input.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0017|\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0004\u00013\b\u0001\u000b\u0001\f\u00014\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0004\u0016y\b\u0016\u000b\u0016\f\u0016z\u0000\u0000\u0017\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017\u0001"+
		"\u0000\u0004\u0003\u0000\t\n\r\r  \u0001\u0000ah\u0001\u000018\u0001\u0000"+
		"09}\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0001/\u0001\u0000\u0000\u0000\u00032\u0001\u0000\u0000\u0000\u00058"+
		"\u0001\u0000\u0000\u0000\u0007A\u0001\u0000\u0000\u0000\tJ\u0001\u0000"+
		"\u0000\u0000\u000bP\u0001\u0000\u0000\u0000\rU\u0001\u0000\u0000\u0000"+
		"\u000fY\u0001\u0000\u0000\u0000\u0011[\u0001\u0000\u0000\u0000\u0013]"+
		"\u0001\u0000\u0000\u0000\u0015_\u0001\u0000\u0000\u0000\u0017a\u0001\u0000"+
		"\u0000\u0000\u0019c\u0001\u0000\u0000\u0000\u001be\u0001\u0000\u0000\u0000"+
		"\u001dg\u0001\u0000\u0000\u0000\u001fi\u0001\u0000\u0000\u0000!k\u0001"+
		"\u0000\u0000\u0000#m\u0001\u0000\u0000\u0000%o\u0001\u0000\u0000\u0000"+
		"\'q\u0001\u0000\u0000\u0000)s\u0001\u0000\u0000\u0000+u\u0001\u0000\u0000"+
		"\u0000-x\u0001\u0000\u0000\u0000/0\u0005-\u0000\u00000\u0002\u0001\u0000"+
		"\u0000\u000013\u0007\u0000\u0000\u000021\u0001\u0000\u0000\u000034\u0001"+
		"\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u000067\u0006\u0001\u0000\u00007\u0004\u0001\u0000"+
		"\u0000\u000089\u0005s\u0000\u00009:\u0005t\u0000\u0000:;\u0005a\u0000"+
		"\u0000;<\u0005r\u0000\u0000<=\u0005t\u0000\u0000=>\u0005p\u0000\u0000"+
		">?\u0005o\u0000\u0000?@\u0005s\u0000\u0000@\u0006\u0001\u0000\u0000\u0000"+
		"AB\u0005p\u0000\u0000BC\u0005o\u0000\u0000CD\u0005s\u0000\u0000DE\u0005"+
		"i\u0000\u0000EF\u0005t\u0000\u0000FG\u0005i\u0000\u0000GH\u0005o\u0000"+
		"\u0000HI\u0005n\u0000\u0000I\b\u0001\u0000\u0000\u0000JK\u0005m\u0000"+
		"\u0000KL\u0005o\u0000\u0000LM\u0005v\u0000\u0000MN\u0005e\u0000\u0000"+
		"NO\u0005s\u0000\u0000O\n\u0001\u0000\u0000\u0000PQ\u0007\u0001\u0000\u0000"+
		"QR\u0007\u0002\u0000\u0000RS\u0007\u0001\u0000\u0000ST\u0007\u0002\u0000"+
		"\u0000T\f\u0001\u0000\u0000\u0000UV\u0005f\u0000\u0000VW\u0005e\u0000"+
		"\u0000WX\u0005n\u0000\u0000X\u000e\u0001\u0000\u0000\u0000YZ\u0005/\u0000"+
		"\u0000Z\u0010\u0001\u0000\u0000\u0000[\\\u0005w\u0000\u0000\\\u0012\u0001"+
		"\u0000\u0000\u0000]^\u0005K\u0000\u0000^\u0014\u0001\u0000\u0000\u0000"+
		"_`\u0005k\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ab\u0005Q\u0000\u0000"+
		"b\u0018\u0001\u0000\u0000\u0000cd\u0005q\u0000\u0000d\u001a\u0001\u0000"+
		"\u0000\u0000ef\u0005R\u0000\u0000f\u001c\u0001\u0000\u0000\u0000gh\u0005"+
		"r\u0000\u0000h\u001e\u0001\u0000\u0000\u0000ij\u0005N\u0000\u0000j \u0001"+
		"\u0000\u0000\u0000kl\u0005n\u0000\u0000l\"\u0001\u0000\u0000\u0000mn\u0005"+
		"B\u0000\u0000n$\u0001\u0000\u0000\u0000op\u0005b\u0000\u0000p&\u0001\u0000"+
		"\u0000\u0000qr\u0005P\u0000\u0000r(\u0001\u0000\u0000\u0000st\u0005p\u0000"+
		"\u0000t*\u0001\u0000\u0000\u0000uv\u0007\u0001\u0000\u0000v,\u0001\u0000"+
		"\u0000\u0000wy\u0007\u0003\u0000\u0000xw\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{.\u0001\u0000\u0000\u0000\u0003\u00004z\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}