package practiceDesignQuestions.TicTacToe;

public class Player {
    public String name;
    public PlayingPiece piece;

    public Player(String _name, PlayingPiece _piece) {
        name = _name;
        piece = _piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingPiece getPiece() {
        return piece;
    }

    public void setPlayingPiece(PlayingPiece piece) {
        this.piece = piece;
    }
}
