package practiceDesignQuestions.TicTacToe;

public class PlayGame {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initializeGame();
        GameStatus status = game.startGame();
        System.out.print("\n===>>> GAME OVER: ");
        switch (status) {
            case WIN:
                System.out.print(game.winner.name + " won the game");
                break;
            case DRAW:
                System.out.print(" Its a Draw!");
                break;
            default:
                System.out.print(" Game Ends");
                break;
        }
    }
}
