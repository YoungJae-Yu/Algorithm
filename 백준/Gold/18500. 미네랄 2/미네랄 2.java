import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) map[i][j] = line.charAt(j);
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < N; t++) {
            int h = Integer.parseInt(st.nextToken());
            int row = R - h;
            boolean destroyed = false;
            if (t % 2 == 0) {
                for (int j = 0; j < C; j++) {
                    if (map[row][j] == 'x') {
                        map[row][j] = '.';
                        destroyed = true;
                        break;
                    }
                }
            } else {
                for (int j = C - 1; j >= 0; j--) {
                    if (map[row][j] == 'x') {
                        map[row][j] = '.';
                        destroyed = true;
                        break;
                    }
                }
            }
            if (!destroyed) continue;
            visited = new boolean[R][C];
            Queue<int[]> q = new ArrayDeque<>();
            for (int j = 0; j < C; j++) {
                if (map[R - 1][j] == 'x' && !visited[R - 1][j]) {
                    visited[R - 1][j] = true;
                    q.offer(new int[]{R - 1, j});
                }
            }
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (!visited[nr][nc] && map[nr][nc] == 'x') {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            ArrayList<int[]> floating = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'x' && !visited[i][j]) {
                        floating.add(new int[]{i, j});
                        map[i][j] = '.';
                    }
                }
            }
            if (floating.isEmpty()) continue;
            int drop = Integer.MAX_VALUE;
            for (int[] cell : floating) {
                int r = cell[0];
                int c = cell[1];
                int nr = r + 1;
                int dCnt = 0;
                while (nr < R && map[nr][c] == '.') {
                    nr++;
                    dCnt++;
                }
                drop = Math.min(drop, dCnt);
            }
            for (int[] cell : floating) {
                int r = cell[0] + drop;
                int c = cell[1];
                map[r][c] = 'x';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) sb.append(map[i][j]);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}