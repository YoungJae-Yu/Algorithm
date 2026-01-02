import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        int ry=0, rx=0, by=0, bx=0;
        for (int i=0;i<N;i++) {
            String s = br.readLine();
            for (int j=0;j<M;j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j]=='R') { ry=i; rx=j; board[i][j]='.'; }
                if (board[i][j]=='B') { by=i; bx=j; board[i][j]='.'; }
            }
        }
        visited = new boolean[N][M][N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{ry,rx,by,bx,0});
        visited[ry][rx][by][bx] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cry = cur[0], crx = cur[1], cby = cur[2], cbx = cur[3], cd = cur[4];
            for (int dir=0; dir<4; dir++) {
                int nry = cry, nrx = crx, rstep = 0;
                while (true) {
                    int nny = nry + dy[dir], nnx = nrx + dx[dir];
                    if (board[nny][nnx] == '#') break;
                    nry = nny; nrx = nnx; rstep++;
                    if (board[nry][nrx] == 'O') break;
                }
                int nby = cby, nbx = cbx, bstep = 0;
                while (true) {
                    int nny = nby + dy[dir], nnx = nbx + dx[dir];
                    if (board[nny][nnx] == '#') break;
                    nby = nny; nbx = nnx; bstep++;
                    if (board[nby][nbx] == 'O') break;
                }
                if (board[nby][nbx] == 'O') continue;
                if (board[nry][nrx] == 'O') {
                    System.out.println(cd+1);
                    return;
                }
                if (nry==nby && nrx==nbx) {
                    if (rstep > bstep) {
                        nry -= dy[dir];
                        nrx -= dx[dir];
                    } else {
                        nby -= dy[dir];
                        nbx -= dx[dir];
                    }
                }
                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    q.offer(new int[]{nry,nrx,nby,nbx,cd+1});
                }
            }
        }
        System.out.println(-1);
    }
}