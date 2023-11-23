grammar Input;
//EXAMPLE FEN
//position fen 8/8/8/8/8/8/8/8 w - - 10 51
//EXAMPLE MOVES
//position startpos moves e2e4 e5e6 e7e8q b2b7

@parser::members{
int lineCount = 0;
int rowCount = 0;
}
WS : [ \t\n\r]+ -> skip;
FILE : [1-8];
STARTPOS : 'startpos';
POSITION : 'position';
MOVES : 'moves';
FEN : 'fen';
SLASH : '/';
WHITE : 'w';
//BLACK : 'b'; creates Problems with the black bishop
KING_WHITE : 'K';
KING_BLACK : 'k';
QUEEN_WHITE : 'Q';
QUEEN_BLACK : 'q';
ROOK_WHITE : 'R' ;
ROOK_BLACK : 'r';
KNIGHT_WHITE : 'N';
KNIGHT_BLACK : 'n';
BISHOP_WHITE : 'B' ;
BISHOP_BLACK : 'b';
PAWN_WHITE : 'P';
PAWN_BLACK : 'p';
RANK : [a-h];
NUMBER : [0-9]+;


start : POSITION FEN rows info
        | POSITION STARTPOS moves;

moves : MOVES whitemove;

whitemove: move
            | move blackmove;

blackmove: move
            | move whitemove;

move : RANK FILE RANK FILE
        | RANK FILE RANK FILE promotable;

promotable : queen_black | rook_black | knight_black | bishop_black;

rows
@init{rowCount = 0;} : (row SLASH)+ row {lineCount == 8}?;

row : single_row {lineCount++;};

single_row
@init{rowCount = 0;} : (piece |num)+ {rowCount == 8}?;

piece : piece_all{rowCount++;};

num : FILE{rowCount+=Integer.valueOf($text);};

info : color castleOptions square half full;

color : WHITE | BISHOP_BLACK;

castleOptions : '-' | (king_white?)(queen_white?)(king_black?)(queen_black?);

square : '-' | RANK FILE;

half : NUMBER;

full : NUMBER;

piece_all : king
        | queen
        | rook
        | knight
        | bishop
        | pawn;

king : king_white |king_black;
king_white : KING_WHITE;
king_black : KING_BLACK;

queen : queen_white | queen_black;
queen_white : QUEEN_WHITE;
queen_black : QUEEN_BLACK;

rook : rook_white | rook_black;
rook_white : ROOK_WHITE;
rook_black : ROOK_BLACK;

knight : knight_white | knight_black;
knight_white: KNIGHT_WHITE;
knight_black: KNIGHT_BLACK;

bishop : bishop_white | bishop_black;
bishop_white : BISHOP_WHITE;
bishop_black : BISHOP_BLACK;

pawn : pawn_white | pawn_black;
pawn_white: PAWN_WHITE;
pawn_black : PAWN_BLACK;