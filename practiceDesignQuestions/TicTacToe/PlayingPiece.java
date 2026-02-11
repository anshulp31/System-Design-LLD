package practiceDesignQuestions.TicTacToe;

public class PlayingPiece {
    private PieceType type;

    public PlayingPiece(PieceType _type) {
        type = _type;
    }

    public PieceType getPieceType() {
        return type;
    }
}
