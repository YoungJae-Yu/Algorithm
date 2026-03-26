import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 10000;
    static final int OFFSET = 1100;
    static final int SIZE = 2200;

    static int[][] board = new int[SIZE][SIZE];
    static int[] answer = new int[MAX + 1];
    static int[] count = new int[6];

    static int[] dy = {-1, 1, 2, 1, -1, -2};
    static int[] dx = {-1, -1, 0, 1, 1, 0};

    public static void main(String[] args) throws Exception {
        precompute();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(answer[n]).append('\n');
        }

        System.out.print(sb);
    }

    static void precompute() {
        int y = OFFSET;
        int x = OFFSET;
        int dir = 5;

        board[y][x] = 1;
        answer[1] = 1;
        count[1]++;

        y = y - 1;
        x = x + 1;
        board[y][x] = 2;
        answer[2] = 2;
        count[2]++;

        for (int idx = 3; idx <= MAX; idx++) {
            int nd = (dir + 1) % 6;
            int ny = y + dy[nd];
            int nx = x + dx[nd];

            if (board[ny][nx] != 0) {
                ny = y + dy[dir];
                nx = x + dx[dir];
                nd = dir;
            }

            y = ny;
            x = nx;
            dir = nd;

            boolean[] used = new boolean[6];
            for (int d = 0; d < 6; d++) {
                int ay = y + dy[d];
                int ax = x + dx[d];
                used[board[ay][ax]] = true;
            }

            int best = -1;
            for (int num = 1; num <= 5; num++) {
                if (!used[num]) {
                    if (best == -1 || count[num] < count[best]) {
                        best = num;
                    }
                }
            }

            board[y][x] = best;
            answer[idx] = best;
            count[best]++;
        }
    }
}