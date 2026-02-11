package practiceDesignQuestions.TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player> players;
    Board gameBoard;
    Player winner;

    public void initializeGame() {
        players = new LinkedList<>();

        PlayingPiece crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player 1", crossPiece);
        players.add(player1);

        PlayingPiece circlePiece = new PlayingPieceO();
        Player player2 = new Player("Player 2", circlePiece);   
        players.add(player2);

        gameBoard = new Board(3);

    }

    public GameStatus startGame() {

        boolean noWinner = true;
        while (noWinner) {

            // Remove the player whose turn is and also put the player in the list back
            Player currentPlayer = players.removeFirst();

            // Get the free space from the board
            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            // Read the user input
            System.out.print("Player: " + currentPlayer.name + " - Please enter [row, column]: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);


            // Place the piece in the board
            boolean validMove = gameBoard.addPiece(inputRow, inputColumn, currentPlayer.piece);
            if (!validMove) {
                System.out.println("Incorrect position chosen, try again!");
                players.addFirst(currentPlayer); // Add the player back to the queue(in the front)
                continue;
            }
            players.addLast(currentPlayer); // Add the player to the end of the queue

            // Check if the valid move is a winning move or not
            boolean isWinner = checkForWinner(inputRow, inputColumn, currentPlayer.piece.getPieceType());
            if (isWinner) {
                gameBoard.printBoard();
                winner = currentPlayer;
                return GameStatus.WIN;
            }
        }

        return GameStatus.DRAW;
    }

      public boolean checkForWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Check Row
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].getPieceType() != pieceType) {
                rowMatch = false;
                break;
            }
        }

        // Check Column
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column].getPieceType() != pieceType) {
                columnMatch = false;
                break;
            }
        }

        // Check Diagonally
        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // Check Anti-Diagonally
        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


}
