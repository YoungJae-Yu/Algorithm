import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static char[][] board;
    static char[][] ans;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        n = Integer.parseInt(first[0]);
        m = Integer.parseInt(first[1]);

        board = new char[n][m];
        ans = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                ans[i][j] = '2';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    int ni = i + dy[d];
                    int nj = j + dx[d];
                    if (0 <= ni && ni < n && 0 <= nj && nj < m) {
                        board[ni][nj] = board[ni][nj] == 'B' ? 'W' : 'B';
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'B') {
                    ans[i][j] = '3';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('1').append('\n');
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.print(sb);
    }
}