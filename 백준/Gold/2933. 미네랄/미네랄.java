import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int turn = 0; turn < N; turn++) {
            int h = Integer.parseInt(st.nextToken());
            int row = R - h;
            boolean removed = false;
            if (turn % 2 == 0) {
                for (int c = 0; c < C; c++) {
                    if (map[row][c] == 'x') {
                        map[row][c] = '.';
                        removed = true;
                        break;
                    }
                }
            } else {
                for (int c = C - 1; c >= 0; c--) {
                    if (map[row][c] == 'x') {
                        map[row][c] = '.';
                        removed = true;
                        break;
                    }
                }
            }
            if (!removed) continue;
            boolean[][] grounded = new boolean[R][C];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            for (int c = 0; c < C; c++) {
                if (map[R-1][c] == 'x' && !grounded[R-1][c]) {
                    grounded[R-1][c] = true;
                    q.add(new int[]{R-1, c});
                }
            }
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = cur[0] + dr[k];
                    int nc = cur[1] + dc[k];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (!grounded[nr][nc] && map[nr][nc] == 'x') {
                        grounded[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            boolean[][] floating = new boolean[R][C];
            ArrayList<int[]> floats = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'x' && !grounded[i][j]) {
                        floating[i][j] = true;
                        floats.add(new int[]{i, j});
                    }
                }
            }
            if (floats.isEmpty()) continue;
            int drop = Integer.MAX_VALUE;
            for (int[] p : floats) {
                int r = p[0], c = p[1];
                int rr = r + 1;
                while (rr < R && (map[rr][c] == '.' || floating[rr][c])) rr++;
                drop = Math.min(drop, rr - r - 1);
            }
            for (int[] p : floats) map[p[0]][p[1]] = '.';
            for (int[] p : floats) map[p[0] + drop][p[1]] = 'x';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) sb.append(map[i]).append('\n');
        System.out.print(sb.toString());
    }
}