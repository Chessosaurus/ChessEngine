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
STARTPOS : 'startpos';
POSITION : 'position';
MOVES : 'moves';
MOVE : [a-h][1-8][a-h][1-8];
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
FILE : [a-h];
NUMBER : [0-9]+;


start : POSITION FEN rows info
        | POSITION STARTPOS moves;

moves : MOVES whitemove;

whitemove: move
            | move blackmove;

blackmove: move
            | move whitemove;
move : MOVE | MOVE promotable;

//move : FILE NUMBER FILE NUMBER
//        | FILE NUMBER FILE NUMBER promotable;

promotable : queen | rook | knight | bishop;

rows
@init{rowCount = 0;} : (row SLASH)+ row {lineCount == 8}?;

row : single_row {lineCount++;};

single_row
@init{rowCount = 0;} : (slot)+ {rowCount == 8}?;

slot : piece | num;

piece : piece_all{rowCount++;};

num : NUMBER{rowCount+=Integer.valueOf($text);};

info : color castleOptions square half full;

color : WHITE | BISHOP_BLACK;

castleOptions : '-' | (king_white?)(queen_white?)(king_black?)(queen_black?);

square : '-' | FILE NUMBER;

half : NUMBER;

full : NUMBER;

piece_all: piece_white | piece_black;

piece_white :
    king_white
    | queen_white
    | rook_white
    | knight_white
    | bishop_white
    | pawn_white;
             
piece_black :
    king_black
    | queen_black
    | rook_black
    | knight_black
    | bishop_black
    | pawn_black; 

//king : king_white |king_black;
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

//pawn : pawn_white | pawn_black;
pawn_white: PAWN_WHITE;
pawn_black : PAWN_BLACK;