import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int count = countPaint(board, i, j);
                minCount = Math.min(minCount, count);
            }
        }

        System.out.println(minCount);
    }

    private static int countPaint(char[][] board, int x, int y) {
        int countW = 0;
        int countB = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) { // 짝수번째 칸
                    if (board[i][j] == 'B') {
                        countW++;
                    } else {
                        countB++;
                    }
                } else { // 홀수번째 칸
                    if (board[i][j] == 'W') {
                        countW++;
                    } else {
                        countB++;
                    }
                }
            }
        }

        return Math.min(countW, countB);
    }
}
