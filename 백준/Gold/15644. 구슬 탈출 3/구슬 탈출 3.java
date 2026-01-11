import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[] dirChar = {'L','R','U','D'};

    static class Node {
        int rx, ry, bx, by, d;
        String path;
        Node(int rx, int ry, int bx, int by, int d, String path) {
            this.rx = rx; this.ry = ry; this.bx = bx; this.by = by; this.d = d; this.path = path;
        }
    }

    static int[] move(int x, int y, int dir) {
        int steps = 0;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (board[nx][ny] == '#') break;
            x = nx; y = ny; steps++;
            if (board[x][y] == 'O') break;
        }
        return new int[]{x, y, steps};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        int rx=0, ry=0, bx=0, by=0;
        for (int i=0;i<N;i++) {
            String s = br.readLine();
            for (int j=0;j<M;j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'R') { rx = i; ry = j; board[i][j] = '.'; }
                if (board[i][j] == 'B') { bx = i; by = j; board[i][j] = '.'; }
            }
        }

        visited = new boolean[N][M][N][M];
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(rx, ry, bx, by, 0, ""));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.d >= 10) continue;
            for (int dir=0; dir<4; dir++) {
                int[] nr = move(cur.rx, cur.ry, dir);
                int[] nb = move(cur.bx, cur.by, dir);

                int nrx = nr[0], nry = nr[1], rsteps = nr[2];
                int nbx = nb[0], nby = nb[1], bsteps = nb[2];

                if (board[nbx][nby] == 'O') continue;
                if (board[nrx][nry] == 'O') {
                    System.out.println(cur.d + 1);
                    System.out.println(cur.path + dirChar[dir]);
                    return;
                }

                if (nrx == nbx && nry == nby) {
                    if (rsteps > bsteps) {
                        nrx -= dx[dir];
                        nry -= dy[dir];
                    } else {
                        nbx -= dx[dir];
                        nby -= dy[dir];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new Node(nrx, nry, nbx, nby, cur.d + 1, cur.path + dirChar[dir]));
                }
            }
        }

        System.out.println(-1);
    }
}