import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] a = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] vis = new boolean[M][N];
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        int count = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == 1 && !vis[i][j]) {
                    count++;
                    vis[i][j] = true;
                    q.clear();
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        for (int d = 0; d < 8; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !vis[nx][ny] && a[nx][ny] == 1) {
                                vis[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}