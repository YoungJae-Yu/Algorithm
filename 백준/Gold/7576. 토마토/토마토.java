import java.io.*;
import java.util.*;

public class Main {
    static int[][] box;
    static int[][] days;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        days = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    days[i][j] = 0;
                } else if (box[i][j] == 0) {
                    days[i][j] = -1;
                }
            }
        }

        bfs(queue);

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (days[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, days[i][j]);
            }
        }

        System.out.println(result);
    }

    static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (box[nx][ny] == 0 && days[nx][ny] == -1) {
                        queue.offer(new int[]{nx, ny});
                        box[nx][ny] = 1;
                        days[nx][ny] = days[x][y] + 1;
                    }
                }
            }
        }
    }
}