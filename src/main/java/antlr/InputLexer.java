// Generated from D:/_Studium/S5/ChessEngine/src/main/java/antlr\Input.g4 by ANTLR 4.12.0
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
		T__0=1, WS=2, STARTPOS=3, POSITION=4, MOVES=5, FEN=6, SLASH=7, WHITE=8, 
		KING_WHITE=9, KING_BLACK=10, QUEEN_WHITE=11, QUEEN_BLACK=12, ROOK_WHITE=13, 
		ROOK_BLACK=14, KNIGHT_WHITE=15, KNIGHT_BLACK=16, BISHOP_WHITE=17, BISHOP_BLACK=18, 
		PAWN_WHITE=19, PAWN_BLACK=20, FILE=21, NUMBER=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "WS", "STARTPOS", "POSITION", "MOVES", "FEN", "SLASH", "WHITE", 
			"KING_WHITE", "KING_BLACK", "QUEEN_WHITE", "QUEEN_BLACK", "ROOK_WHITE", 
			"ROOK_BLACK", "KNIGHT_WHITE", "KNIGHT_BLACK", "BISHOP_WHITE", "BISHOP_BLACK", 
			"PAWN_WHITE", "PAWN_BLACK", "FILE", "NUMBER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", null, "'startpos'", "'position'", "'moves'", "'fen'", "'/'", 
			"'w'", "'K'", "'k'", "'Q'", "'q'", "'R'", "'r'", "'N'", "'n'", "'B'", 
			"'b'", "'P'", "'p'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "WS", "STARTPOS", "POSITION", "MOVES", "FEN", "SLASH", "WHITE", 
			"KING_WHITE", "KING_BLACK", "QUEEN_WHITE", "QUEEN_BLACK", "ROOK_WHITE", 
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
		"\u0004\u0000\u0016u\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u00011\b"+
		"\u0001\u000b\u0001\f\u00012\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0004\u0015r\b\u0015\u000b\u0015\f\u0015s\u0000\u0000\u0016\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016\u0001\u0000\u0003"+
		"\u0003\u0000\t\n\r\r  \u0001\u0000ah\u0001\u000009v\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0001-\u0001\u0000\u0000\u0000\u00030\u0001\u0000\u0000\u0000"+
		"\u00056\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000\tH\u0001"+
		"\u0000\u0000\u0000\u000bN\u0001\u0000\u0000\u0000\rR\u0001\u0000\u0000"+
		"\u0000\u000fT\u0001\u0000\u0000\u0000\u0011V\u0001\u0000\u0000\u0000\u0013"+
		"X\u0001\u0000\u0000\u0000\u0015Z\u0001\u0000\u0000\u0000\u0017\\\u0001"+
		"\u0000\u0000\u0000\u0019^\u0001\u0000\u0000\u0000\u001b`\u0001\u0000\u0000"+
		"\u0000\u001db\u0001\u0000\u0000\u0000\u001fd\u0001\u0000\u0000\u0000!"+
		"f\u0001\u0000\u0000\u0000#h\u0001\u0000\u0000\u0000%j\u0001\u0000\u0000"+
		"\u0000\'l\u0001\u0000\u0000\u0000)n\u0001\u0000\u0000\u0000+q\u0001\u0000"+
		"\u0000\u0000-.\u0005-\u0000\u0000.\u0002\u0001\u0000\u0000\u0000/1\u0007"+
		"\u0000\u0000\u00000/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000034\u0001\u0000\u0000"+
		"\u000045\u0006\u0001\u0000\u00005\u0004\u0001\u0000\u0000\u000067\u0005"+
		"s\u0000\u000078\u0005t\u0000\u000089\u0005a\u0000\u00009:\u0005r\u0000"+
		"\u0000:;\u0005t\u0000\u0000;<\u0005p\u0000\u0000<=\u0005o\u0000\u0000"+
		"=>\u0005s\u0000\u0000>\u0006\u0001\u0000\u0000\u0000?@\u0005p\u0000\u0000"+
		"@A\u0005o\u0000\u0000AB\u0005s\u0000\u0000BC\u0005i\u0000\u0000CD\u0005"+
		"t\u0000\u0000DE\u0005i\u0000\u0000EF\u0005o\u0000\u0000FG\u0005n\u0000"+
		"\u0000G\b\u0001\u0000\u0000\u0000HI\u0005m\u0000\u0000IJ\u0005o\u0000"+
		"\u0000JK\u0005v\u0000\u0000KL\u0005e\u0000\u0000LM\u0005s\u0000\u0000"+
		"M\n\u0001\u0000\u0000\u0000NO\u0005f\u0000\u0000OP\u0005e\u0000\u0000"+
		"PQ\u0005n\u0000\u0000Q\f\u0001\u0000\u0000\u0000RS\u0005/\u0000\u0000"+
		"S\u000e\u0001\u0000\u0000\u0000TU\u0005w\u0000\u0000U\u0010\u0001\u0000"+
		"\u0000\u0000VW\u0005K\u0000\u0000W\u0012\u0001\u0000\u0000\u0000XY\u0005"+
		"k\u0000\u0000Y\u0014\u0001\u0000\u0000\u0000Z[\u0005Q\u0000\u0000[\u0016"+
		"\u0001\u0000\u0000\u0000\\]\u0005q\u0000\u0000]\u0018\u0001\u0000\u0000"+
		"\u0000^_\u0005R\u0000\u0000_\u001a\u0001\u0000\u0000\u0000`a\u0005r\u0000"+
		"\u0000a\u001c\u0001\u0000\u0000\u0000bc\u0005N\u0000\u0000c\u001e\u0001"+
		"\u0000\u0000\u0000de\u0005n\u0000\u0000e \u0001\u0000\u0000\u0000fg\u0005"+
		"B\u0000\u0000g\"\u0001\u0000\u0000\u0000hi\u0005b\u0000\u0000i$\u0001"+
		"\u0000\u0000\u0000jk\u0005P\u0000\u0000k&\u0001\u0000\u0000\u0000lm\u0005"+
		"p\u0000\u0000m(\u0001\u0000\u0000\u0000no\u0007\u0001\u0000\u0000o*\u0001"+
		"\u0000\u0000\u0000pr\u0007\u0002\u0000\u0000qp\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000t,\u0001\u0000\u0000\u0000\u0003\u00002s\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}