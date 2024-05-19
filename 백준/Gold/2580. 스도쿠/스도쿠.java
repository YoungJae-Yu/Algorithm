import java.util.Scanner;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        solve(0, 0);
    }

    public static boolean solve(int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return true; // 스도쿠가 완성되었을 때 true를 반환
        }

        if (board[row][col] != 0) {
            return solve(row, col + 1);
        } else {
            for (int num = 1; num <= 9; num++) {
                if (isValidPlacement(row, col, num)) {
                    board[row][col] = num;
                    if (solve(row, col + 1)) {
                        return true;
                    }
                    board[row][col] = 0; // 백트래킹
                }
            }
        }
        return false;
    }

    public static boolean isValidPlacement(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}