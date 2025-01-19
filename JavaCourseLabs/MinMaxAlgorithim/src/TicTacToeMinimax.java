import java.util.HashMap;
import java.util.Scanner;
import minmaxalgorithim.AdversarialSearchTicTacToe;

public class TicTacToeMinimax {
    private static final String USER = "O";
    private static final String AI = "X";
    private static final String EMPTY = "-";

    // Memoization map for caching Minimax results
    private static final HashMap<String, Integer> memo = new HashMap<>();

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        // Initialize the board for a new game
        String[] board = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        AdversarialSearchTicTacToe adsTicTacToe = new AdversarialSearchTicTacToe();

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("You are 'O'. The AI is 'X'. Enter a number (0-8) to make your move.");

        // Main game loop
        while (true) {
            drawBoard(board);

            // User's turn
            int userMove = getUserMove(board, scanner);
            board[userMove] = USER;

            if (isGameOver(board)) {
                break;
            }

            // AI's turn
            int aiMove = getBestMove(board);
            board[aiMove] = AI;
            System.out.println("AI chose position: " + aiMove);

            if (isGameOver(board)) {
                break;
            }
        }

        drawBoard(board);
        printResult(board);

        // Retry option
        System.out.print("Play again? (yes/no): ");
        String retry = scanner.nextLine().trim().toLowerCase();
        
    }
}


    private static void drawBoard(String[] board) {
        for (int i = 0; i < 9; i += 3) {
            System.out.println(board[i] + " " + board[i + 1] + " " + board[i + 2]);
        }
    }

    private static int getUserMove(String[] board, Scanner scanner) {
        while (true) {
            System.out.print("Enter your move (0-8): ");
            int move = scanner.nextInt();
            if (move >= 0 && move < 9 && board[move].equals(EMPTY)) {
                return move;
            }
            System.out.println("Invalid move. Try again.");
        }
    }

    private static boolean isGameOver(String[] board) {
        return getWinner(board) != null || !hasEmptyCells(board);
    }

    private static void printResult(String[] board) {
        String winner = getWinner(board);
        if (winner == null) {
            System.out.println("It's a draw!");
        } else if (winner.equals(USER)) {
            System.out.println("Congratulations! You win!");
        } else {
            System.out.println("AI wins!");
        }
    }

    private static String getWinner(String[] board) {
        String[][] winningLines = {
                {board[0], board[1], board[2]},
                {board[3], board[4], board[5]},
                {board[6], board[7], board[8]},
                {board[0], board[3], board[6]},
                {board[1], board[4], board[7]},
                {board[2], board[5], board[8]},
                {board[0], board[4], board[8]},
                {board[2], board[4], board[6]}
        };

        for (String[] line : winningLines) {
            if (line[0].equals(line[1]) && line[1].equals(line[2]) && !line[0].equals(EMPTY)) {
                return line[0];
            }
        }
        return null;
    }

    private static boolean hasEmptyCells(String[] board) {
        for (String cell : board) {
            if (cell.equals(EMPTY)) {
                return true;
            }
        }
        return false;
    }

    private static int getBestMove(String[] board) {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int i = 0; i < 9; i++) {
            if (board[i].equals(EMPTY)) {
                board[i] = AI; // Simulate AI move
                int score = minimax(board, false); // Call Minimax for user's turn
                board[i] = EMPTY; // Undo move
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }

    private static int minimax(String[] board, boolean isMaximizing) {
        String winner = getWinner(board);
        if (winner != null) {
            return winner.equals(AI) ? 1 : -1;
        }
        if (!hasEmptyCells(board)) {
            return 0; // Draw
        }

        String boardState = String.join("", board);
        if (memo.containsKey(boardState)) {
            return memo.get(boardState); // Return cached result
        }

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 9; i++) {
            if (board[i].equals(EMPTY)) {
                board[i] = isMaximizing ? AI : USER; // Simulate move
                int score = minimax(board, !isMaximizing);
                board[i] = EMPTY; // Undo move
                bestScore = isMaximizing ? Math.max(bestScore, score) : Math.min(bestScore, score);
            }
        }

        memo.put(boardState, bestScore); // Cache the result
        return bestScore;
    }
}
