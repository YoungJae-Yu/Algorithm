import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < M; j++) a[i][j] = s.charAt(j) - '0';
        }
        int ans = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int h = 1; h <= 9; h++) {
            boolean[][] vis = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!vis[i][j] && a[i][j] < h) {
                        ArrayDeque<int[]> q = new ArrayDeque<>();
                        vis[i][j] = true;
                        q.add(new int[]{i, j});
                        boolean touch = false;
                        int cnt = 0;
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            cnt++;
                            int r = cur[0], c = cur[1];
                            if (r == 0 || r == N - 1 || c == 0 || c == M - 1) touch = true;
                            for (int d = 0; d < 4; d++) {
                                int nr = r + dr[d], nc = c + dc[d];
                                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !vis[nr][nc] && a[nr][nc] < h) {
                                    vis[nr][nc] = true;
                                    q.add(new int[]{nr, nc});
                                }
                            }
                        }
                        if (!touch) ans += cnt;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}