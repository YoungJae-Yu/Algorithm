import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] a;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        a = new int[N][N];
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] > maxH) maxH = a[i][j];
            }
        }
        int ans = 0;
        for (int water = 0; water <= maxH; water++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c] && a[r][c] > water) {
                        bfs(r, c, water);
                        count++;
                    }
                }
            }
            if (count > ans) ans = count;
        }
        System.out.println(ans);
    }
    static void bfs(int sr, int sc, int water) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sr][sc] = true;
        q.add(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (a[nr][nc] <= water) continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}