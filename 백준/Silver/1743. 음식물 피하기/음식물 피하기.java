import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] a = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            a[r][c] = 1;
        }
        int max = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 1 && !visited[i][j]) {
                    int cnt = 0;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        cnt++;
                        int cr = cur[0], cc = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int nr = cr + dr[d], nc = cc + dc[d];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && a[nr][nc] == 1) {
                                visited[nr][nc] = true;
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    if (cnt > max) max = cnt;
                }
            }
        }
        System.out.println(max);
    }
}