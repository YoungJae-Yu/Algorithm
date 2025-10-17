import java.io.*;
import java.util.*;

public class Main {
    static int R, C, K, ans = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited[R-1][0] = true;
        dfs(R-1, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int r, int c, int len) {
        if (len > K) return;
        if (r == 0 && c == C-1) {
            if (len == K) ans++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc] == 'T') continue;
            visited[nr][nc] = true;
            dfs(nr, nc, len + 1);
            visited[nr][nc] = false;
        }
    }
}