import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[4][4];
        int[][] dir = new int[4][4];
        int[][] fishPos = new int[17][2];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                board[i][j] = num;
                dir[i][j] = d;
                fishPos[num][0] = i;
                fishPos[num][1] = j;
            }
        }
        int initFish = board[0][0];
        int initDir = dir[0][0];
        board[0][0] = 0;
        fishPos[initFish][0] = -1;
        dfs(board, dir, fishPos, 0, 0, initDir, initFish);
        System.out.println(answer);
    }

    static void dfs(int[][] board, int[][] dir, int[][] fishPos, int sx, int sy, int sdir, int sum) {
        answer = Math.max(answer, sum);
        int[][] b = copyBoard(board);
        int[][] d = copyBoard(dir);
        int[][] fp = copyFishPos(fishPos);

        for (int f = 1; f <= 16; f++) {
            if (fp[f][0] == -1) continue;
            int r = fp[f][0];
            int c = fp[f][1];
            int cd = d[r][c];
            boolean moved = false;
            for (int k = 0; k < 8; k++) {
                int nd = (cd + k) % 8;
                int nr = r + dx[nd];
                int nc = c + dy[nd];
                if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
                if (nr == sx && nc == sy) continue;
                int targetFish = b[nr][nc];
                int targetDir = (targetFish == 0) ? -1 : d[nr][nc];
                b[nr][nc] = f;
                d[nr][nc] = nd;
                b[r][c] = targetFish;
                if (targetFish != 0) d[r][c] = targetDir;
                else d[r][c] = 0;
                fp[f][0] = nr;
                fp[f][1] = nc;
                if (targetFish != 0) {
                    fp[targetFish][0] = r;
                    fp[targetFish][1] = c;
                }
                moved = true;
                break;
            }
            if (!moved) {
                // 방향을 바꾸지 못하면 그대로
            }
        }

        for (int step = 1; step < 4; step++) {
            int nx = sx + dx[sdir] * step;
            int ny = sy + dy[sdir] * step;
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
            if (b[nx][ny] == 0) continue;
            int[][] nb = copyBoard(b);
            int[][] nd = copyBoard(d);
            int[][] nfp = copyFishPos(fp);
            int eat = nb[nx][ny];
            int ndir = nd[nx][ny];
            nb[sx][sy] = 0;
            nb[nx][ny] = 0;
            nfp[eat][0] = -1;
            dfs(nb, nd, nfp, nx, ny, ndir, sum + eat);
        }
    }

    static int[][] copyBoard(int[][] src) {
        int[][] t = new int[src.length][src[0].length];
        for (int i = 0; i < src.length; i++) System.arraycopy(src[i], 0, t[i], 0, src[0].length);
        return t;
    }

    static int[][] copyFishPos(int[][] src) {
        int[][] t = new int[src.length][2];
        for (int i = 0; i < src.length; i++) {
            t[i][0] = src[i][0];
            t[i][1] = src[i][1];
        }
        return t;
    }
}