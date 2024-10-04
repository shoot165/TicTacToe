import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    private static char player = 'X'; 
    private static char computer = 'O'; 
    // You play O, computer plays as X
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printBoard();
        while (true) {
            playerMove(scanner);
            if (isGameFinished(player)) {
                break;
            }
            computerMove();
            if (isGameFinished(computer)) {
                break;
            }
        }
        scanner.close();
    }

    private static void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }

    private static void playerMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Your turn. Enter the row and the column (0, 1 or 2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && col >= 0 && row < 3 && col < 3 && board[row][col] == ' ') {
                board[row][col] = player;
                break;
            } else {
                System.out.println("Wrong, try again.");
            }
        }
        printBoard();
    }

    private static void computerMove() {
        Random rand = new Random();
        int row, col;
        while (true) {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
            if (board[row][col] == ' ') {
                board[row][col] = computer;
                break;
            }
        }
        System.out.println("The computer made a move");
        printBoard();
    }

    private static boolean isGameFinished(char currentPlayer) {
        if (hasPlayerWon(currentPlayer)) {
            if (currentPlayer == player) {
                System.out.println("Congrats, You won!");
            } else {
                System.out.println("Computer won:(");
            }
            return true;
        }
        if (isBoardFull()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    private static boolean hasPlayerWon(char currentPlayer) {
        // Checking rows, lines and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
