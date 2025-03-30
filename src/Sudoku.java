import java.util.Random;

public class Sudoku {
    private static final int SIZE = 9;
    private static final int[][] board = new int[SIZE][SIZE];
    
    public static void main(String[] args) {
        generateBoard();
        printBoard();
    }
    
    private static void generateBoard() {
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (rand.nextInt(100) < 30) { // 30% de celulas preenchidas
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
}
