import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class State {
        int rx, ry, bx, by, moves;
        State(int rx, int ry, int bx, int by, int moves) {
            this.rx = rx; this.ry = ry;
            this.bx = bx; this.by = by;
            this.moves = moves;
        }
    }

    static int[] move(int x, int y, int dx, int dy) {
        int cnt = 0;
        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx; y += dy;
            cnt++;
        }
        return new int[]{x, y, cnt};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        int rx=0, ry=0, bx=0, by=0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                }
                if (board[i][j] == 'B') {
                    bx = i; by = j;
                }
            }
        }

        visited = new boolean[N][M][N][M];
        Queue<State> q = new LinkedList<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.moves >= 10) continue;

            for (int d = 0; d < 4; d++) {
                int[] nr = move(cur.rx, cur.ry, dx[d], dy[d]);
                int[] nb = move(cur.bx, cur.by, dx[d], dy[d]);
                int nrx = nr[0], nry = nr[1];
                int nbx = nb[0], nby = nb[1];
                int rc = nr[2], bc = nb[2];

                if (board[nbx][nby] == 'O') continue;
                if (board[nrx][nry] == 'O') {
                    System.out.println(cur.moves + 1);
                    return;
                }

                if (nrx == nbx && nry == nby) {
                    if (rc > bc) {
                        nrx -= dx[d]; nry -= dy[d];
                    } else {
                        nbx -= dx[d]; nby -= dy[d];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new State(nrx, nry, nbx, nby, cur.moves + 1));
                }
            }
        }

        System.out.println(-1);
    }
}