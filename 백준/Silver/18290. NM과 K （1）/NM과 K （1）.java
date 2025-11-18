import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] a;
    static boolean[][] used;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }
        used = new boolean[N][M];
        dfs(0, 0, 0);
        System.out.println(max);
    }
    static void dfs(int idx, int cnt, int sum) {
        if (cnt == K) {
            if (sum > max) max = sum;
            return;
        }
        int total = N * M;
        for (int i = idx; i < total; i++) {
            int r = i / M;
            int c = i % M;
            if (canSelect(r, c)) {
                used[r][c] = true;
                dfs(i + 1, cnt + 1, sum + a[r][c]);
                used[r][c] = false;
            }
        }
    }
    static boolean canSelect(int r, int c) {
        if (used[r][c]) return false;
        if (r > 0 && used[r - 1][c]) return false;
        if (r < N - 1 && used[r + 1][c]) return false;
        if (c > 0 && used[r][c - 1]) return false;
        if (c < M - 1 && used[r][c + 1]) return false;
        return true;
    }
}