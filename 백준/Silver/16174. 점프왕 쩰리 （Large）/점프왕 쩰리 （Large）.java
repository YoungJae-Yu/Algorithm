import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        boolean success = false;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (a[x][y] == -1) { success = true; break; }
            int jump = a[x][y];
            int nx = x + jump;
            int ny = y + jump;
            if (nx < n && !visited[nx][y]) { visited[nx][y] = true; q.add(new int[]{nx, y}); }
            if (ny < n && !visited[x][ny]) { visited[x][ny] = true; q.add(new int[]{x, ny}); }
        }
        System.out.println(success ? "HaruHaru" : "Hing");
    }
}