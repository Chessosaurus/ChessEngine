package chessosaurus.base;

public enum Color {
    BLACK,
    WHITE;

    public Color getOpposite(){
        return switch(this){
            case BLACK -> WHITE;
            case WHITE -> BLACK;
        };
    }
}
