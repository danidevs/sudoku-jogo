import java.util.Random;
import java.util.Scanner;

public class Sudoku {
    private static final int SIZE = 9;
    private static final int[][] board = new int[SIZE][SIZE];
    
    public static void main(String[] args) {
        generateBoard();
        playGame();
    }
    
    private static void generateBoard() {
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (rand.nextInt(100) < 30) { // 30% de células preenchidas
                    board[i][j] = rand.nextInt(9) + 1;
                }
            }
        }
    }
    
    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("- - - + - - - + - - -");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print((board[i][j] == 0 ? "." : board[i][j]) + " ");
            }
            System.out.println();
        }
    }
    
    private static void playGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printBoard();
                System.out.print("Digite linha (1-9), coluna (1-9) e número (1-9) ou 0 para sair: ");
                int row = scanner.nextInt() - 1;
                if (row == -1) break;
                int col = scanner.nextInt() - 1;
                int num = scanner.nextInt();
                
                if (isValidMove(row, col, num)) {
                    board[row][col] = num;
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            }
        }
    }
    
    private static boolean isValidMove(int row, int col, int num) {
        if (board[row][col] != 0) return false; // Verifica se a célula já está preenchida
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) return false; // Linha e coluna
        }
        int boxRow = (row / 3) * 3, boxCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRow + i][boxCol + j] == num) return false; // Subgrade 3x3
            }
        }
        return true;
    }
}
