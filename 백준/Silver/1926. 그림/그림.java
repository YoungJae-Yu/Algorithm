import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }
        boolean[][] v = new boolean[n][m];
        int pictures = 0;
        int max = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && !v[i][j]) {
                    pictures++;
                    int area = 0;
                    v[i][j] = true;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        area++;
                        int x = cur[0], y = cur[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k], ny = y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && a[nx][ny] == 1 && !v[nx][ny]) {
                                v[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                    if (area > max) max = area;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pictures).append('\n').append(max).append('\n');
        System.out.print(sb.toString());
    }
}