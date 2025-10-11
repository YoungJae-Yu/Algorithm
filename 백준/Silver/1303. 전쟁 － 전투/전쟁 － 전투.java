import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[M][N];
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) map[i][j] = line.charAt(j);
        }
        boolean[][] visited = new boolean[M][N];
        int white = 0;
        int blue = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                char team = map[i][j];
                visited[i][j] = true;
                q.clear();
                q.add(new int[]{i, j});
                int cnt = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.removeFirst();
                    cnt++;
                    int y = cur[0], x = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                        if (visited[ny][nx]) continue;
                        if (map[ny][nx] != team) continue;
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
                if (team == 'W') white += cnt * cnt;
                else blue += cnt * cnt;
            }
        }
        System.out.println(white + " " + blue);
    }
}