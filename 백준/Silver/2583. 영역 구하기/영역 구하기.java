import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] filled = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    filled[y][x] = true;
                }
            }
        }
        List<Integer> areas = new ArrayList<>();
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!filled[i][j]) {
                    int area = 0;
                    Deque<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    filled[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        area++;
                        int cy = cur[0], cx = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int ny = cy + dy[d];
                            int nx = cx + dx[d];
                            if (ny >= 0 && ny < M && nx >= 0 && nx < N && !filled[ny][nx]) {
                                filled[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                    areas.add(area);
                }
            }
        }
        Collections.sort(areas);
        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append('\n');
        for (int v : areas) sb.append(v).append(' ');
        System.out.println(sb.toString().trim());
    }
}