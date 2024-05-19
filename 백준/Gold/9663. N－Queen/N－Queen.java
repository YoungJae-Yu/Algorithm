import java.util.Scanner;

public class Main {
    static int N;
    static int[] board;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N]; // board[i] = j는 i번째 행의 j번째 열에 퀸이 위치함을 의미한다.

        placeQueen(0);
        System.out.println(count);
    }

    // 현재 row에 퀸을 배치하는 모든 경우를 시도한다.
    public static void placeQueen(int row) {
        if (row == N) { // 모든 퀸이 배치된 경우
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            board[row] = col; // row번째 행의 col번째 열에 퀸을 배치한다.
            if (isPossible(row)) { // 현재 배치가 가능한지 확인한다.
                placeQueen(row + 1); // 다음 행에 퀸을 배치한다.
            }
        }
    }

    // 현재 row의 배치가 가능한지 검사한다.
    public static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 위치하거나 대각선에 위치하는 경우 배치가 불가능하다.
            if (board[row] == board[i] || Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}