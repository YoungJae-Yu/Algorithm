import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, keys, d;
        Node(int r, int c, int keys, int d) { this.r = r; this.c = c; this.keys = keys; this.d = d; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] a = new char[N][M];
        int sr = -1, sc = -1;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] == '0') { sr = i; sc = j; a[i][j] = '.'; }
            }
        }
        boolean[][][] vis = new boolean[N][M][1<<6];
        ArrayDeque<Node> q = new ArrayDeque<>();
        vis[sr][sc][0] = true;
        q.add(new Node(sr, sc, 0, 0));
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int ans = -1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (a[cur.r][cur.c] == '1') { ans = cur.d; break; }
            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                char ch = a[nr][nc];
                if (ch == '#') continue;
                int nkeys = cur.keys;
                if (ch >= 'a' && ch <= 'f') {
                    nkeys = cur.keys | (1 << (ch - 'a'));
                }
                if (ch >= 'A' && ch <= 'F') {
                    int need = 1 << (ch - 'A');
                    if ((cur.keys & need) == 0) continue;
                }
                if (!vis[nr][nc][nkeys]) {
                    vis[nr][nc][nkeys] = true;
                    q.add(new Node(nr, nc, nkeys, cur.d + 1));
                }
            }
        }
        System.out.println(ans);
    }
}