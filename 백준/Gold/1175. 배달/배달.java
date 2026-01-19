import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, dir, mask, dist;
        Node(int x, int y, int dir, int mask, int dist) {
            this.x = x; this.y = y; this.dir = dir; this.mask = mask; this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] a = new char[N][M];
        int sx = 0, sy = 0;
        int[][] c = new int[2][2];
        int cidx = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] == 'S') { sx = i; sy = j; }
                if (a[i][j] == 'C') { c[cidx][0] = i; c[cidx][1] = j; cidx++; }
            }
        }
        boolean[][][][] visited = new boolean[N][M][5][4];
        int[][] dirs = { {-1,0}, {0,1}, {1,0}, {0,-1} };
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(sx, sy, 4, 0, 0));
        visited[sx][sy][4][0] = true;
        int ans = -1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.mask == 3) { ans = cur.dist; break; }
            for (int d = 0; d < 4; d++) {
                if (cur.dir != 4 && cur.dir == d) continue;
                int nx = cur.x + dirs[d][0], ny = cur.y + dirs[d][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (a[nx][ny] == '#') continue;
                int nmask = cur.mask;
                if (a[nx][ny] == 'C') {
                    if (nx == c[0][0] && ny == c[0][1]) nmask |= 1;
                    else if (nx == c[1][0] && ny == c[1][1]) nmask |= 2;
                }
                if (!visited[nx][ny][d][nmask]) {
                    visited[nx][ny][d][nmask] = true;
                    q.add(new Node(nx, ny, d, nmask, cur.dist + 1));
                }
            }
        }
        System.out.println(ans);
    }
}