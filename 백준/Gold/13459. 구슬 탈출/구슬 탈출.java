import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'R') { rx = i; ry = j; board[i][j] = '.'; }
                if (board[i][j] == 'B') { bx = i; by = j; board[i][j] = '.'; }
            }
        }
        visited = new boolean[N][M][N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int crx = cur[0], cry = cur[1], cbx = cur[2], cby = cur[3], dist = cur[4];
            if (dist >= 10) continue;
            for (int d = 0; d < 4; d++) {
                int[] rMoved = move(crx, cry, dx[d], dy[d]);
                int[] bMoved = move(cbx, cby, dx[d], dy[d]);
                int nrx = rMoved[0], nry = rMoved[1], rcnt = rMoved[2];
                int nbx = bMoved[0], nby = bMoved[1], bcnt = bMoved[2];
                if (board[nbx][nby] == 'O') continue;
                if (board[nrx][nry] == 'O') {
                    System.out.println(1);
                    return;
                }
                if (nrx == nbx && nry == nby) {
                    if (rcnt > bcnt) {
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new int[]{nrx, nry, nbx, nby, dist + 1});
                }
            }
        }
        System.out.println(0);
    }

    static int[] move(int x, int y, int dx, int dy) {
        int cnt = 0;
        while (true) {
            int nx = x + dx;
            int ny = y + dy;
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
            if (board[nx][ny] == '#') break;
            x = nx; y = ny; cnt++;
            if (board[x][y] == 'O') break;
        }
        return new int[]{x, y, cnt};
    }
}