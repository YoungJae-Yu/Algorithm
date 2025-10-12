import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] a = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) a[i][j] = s.charAt(j);
        }
        boolean[][] vis = new boolean[R][C];
        int totalSheep = 0, totalWolf = 0;
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (vis[i][j] || a[i][j] == '#') continue;
                int sheep = 0, wolf = 0;
                vis[i][j] = true;
                q.add(new int[]{i, j});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];
                    if (a[x][y] == 'o') sheep++;
                    else if (a[x][y] == 'v') wolf++;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d], ny = y + dy[d];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                        if (vis[nx][ny] || a[nx][ny] == '#') continue;
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
                if (sheep > wolf) totalSheep += sheep;
                else totalWolf += wolf;
            }
        }
        System.out.println(totalSheep + " " + totalWolf);
    }
}