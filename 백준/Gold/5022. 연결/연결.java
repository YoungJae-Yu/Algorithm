import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] A = new int[2][2];
    static int[][] B = new int[2][2];
    static final int INF = 1_000_000_000;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Result {
        int dist;
        ArrayList<int[]> path;

        Result(int dist, ArrayList<int[]> path) {
            this.dist = dist;
            this.path = path;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            B[i][0] = Integer.parseInt(st.nextToken());
            B[i][1] = Integer.parseInt(st.nextToken());
        }

        int ans1 = solveOrder(A[0], A[1], B[0], B[1]);
        int ans2 = solveOrder(B[0], B[1], A[0], A[1]);

        int ans = Math.min(ans1, ans2);
        System.out.println(ans >= INF ? "IMPOSSIBLE" : ans);
    }

    static int solveOrder(int[] firstS, int[] firstE, int[] otherS, int[] otherE) {
        boolean[][] blocked = new boolean[N + 1][M + 1];

        Result first = bfs(firstS, firstE, blocked, otherS, otherE);
        if (first == null) return INF;

        for (int[] p : first.path) {
            blocked[p[0]][p[1]] = true;
        }

        Result second = bfs(otherS, otherE, blocked, null, null);
        if (second == null) return INF;

        return first.dist + second.dist;
    }

    static Result bfs(int[] start, int[] end, boolean[][] blocked, int[] forbid1, int[] forbid2) {
        boolean[][] visited = new boolean[N + 1][M + 1];
        int[][] px = new int[N + 1][M + 1];
        int[][] py = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(px[i], -1);
            Arrays.fill(py[i], -1);
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        px[start[0]][start[1]] = start[0];
        py[start[0]][start[1]] = start[1];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == end[0] && y == end[1]) break;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx > N || ny < 0 || ny > M) continue;
                if (blocked[nx][ny]) continue;
                if (forbid1 != null && nx == forbid1[0] && ny == forbid1[1]) continue;
                if (forbid2 != null && nx == forbid2[0] && ny == forbid2[1]) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                px[nx][ny] = x;
                py[nx][ny] = y;
                q.offer(new int[]{nx, ny});
            }
        }

        if (!visited[end[0]][end[1]]) return null;

        ArrayList<int[]> path = new ArrayList<>();
        int x = end[0], y = end[1];
        while (true) {
            path.add(new int[]{x, y});
            if (x == start[0] && y == start[1]) break;
            int tx = px[x][y];
            int ty = py[x][y];
            x = tx;
            y = ty;
        }

        int dist = path.size() - 1;
        return new Result(dist, path);
    }
}