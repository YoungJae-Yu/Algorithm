import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int half = M / 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < half; j++) {
                char left = board[i][j];
                char right = board[i][M - 1 - j];
                if (left != '.') {
                    board[i][M - 1 - j] = left;
                } else if (right != '.') {
                    board[i][j] = right;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(board[i]).append('\n');
        }
        System.out.print(sb);
    }
}
