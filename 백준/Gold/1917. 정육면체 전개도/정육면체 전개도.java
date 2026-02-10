import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[6][6];
    static boolean[][] visited = new boolean[6][6];
    static boolean[] used = new boolean[6];
    static int cntVisited;
    static boolean valid;
    static int top, bottom, north, south, west, east;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < 3; tc++) {
            for (int i = 0; i < 6; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 6; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = false;
                }
            }
            int ones = 0;
            int sr = -1, sc = -1;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] == 1) {
                        ones++;
                        if (sr == -1) { sr = i; sc = j; }
                    }
                }
            }
            if (ones != 6) {
                sb.append("no\n");
                continue;
            }
            Arrays.fill(used, false);
            top = 5; bottom = 0; north = 1; south = 4; west = 2; east = 3;
            cntVisited = 0;
            valid = true;
            visited[sr][sc] = true;
            used[bottom] = true;
            cntVisited = 1;
            dfs(sr, sc);
            if (valid && cntVisited == 6) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int r, int c) {
        if (!valid) return;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= 6 || nc < 0 || nc >= 6) continue;
            if (map[nr][nc] == 0 || visited[nr][nc]) continue;
            roll(d);
            if (used[bottom]) {
                roll(opposite(d));
                valid = false;
                return;
            } else {
                used[bottom] = true;
                visited[nr][nc] = true;
                cntVisited++;
                dfs(nr, nc);
                if (!valid) {
                    roll(opposite(d));
                    return;
                }
                roll(opposite(d));
            }
        }
    }

    static int opposite(int d) {
        if (d == 0) return 1;
        if (d == 1) return 0;
        if (d == 2) return 3;
        return 2;
    }

    static void roll(int d) {
        int tmp;
        if (d == 0) {
            tmp = top;
            top = south;
            south = bottom;
            bottom = north;
            north = tmp;
        } else if (d == 1) {
            tmp = top;
            top = north;
            north = bottom;
            bottom = south;
            south = tmp;
        } else if (d == 2) {
            tmp = top;
            top = east;
            east = bottom;
            bottom = west;
            west = tmp;
        } else {
            tmp = top;
            top = west;
            west = bottom;
            bottom = east;
            east = tmp;
        }
    }
}