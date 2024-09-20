import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 100000000;
    static int N;
    static int[][] dist;
    static int[][] via;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        via = new int[N + 1][N + 1];

        // Initialize distance matrix
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Read edges
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (dist[a][b] > c) {
                dist[a][b] = c;
                via[a][b] = 0;
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 1; j <= N; j++) {
                    if (dist[k][j] == INF) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        via[i][j] = k;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // Output distance matrix
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        // Output paths
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == INF || i == j) {
                    sb.append("0\n");
                } else {
                    List<Integer> path = getPath(i, j);
                    sb.append(path.size()).append(" ");
                    for (int node : path) {
                        sb.append(node).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.print(sb.toString());
    }

    static List<Integer> getPath(int i, int j) {
        if (dist[i][j] == INF) {
            return new ArrayList<>();
        }
        List<Integer> path = new ArrayList<>();
        dfs(i, j, path);
        return path;
    }

    static void dfs(int i, int j, List<Integer> path) {
        if (via[i][j] == 0) {
            path.add(i);
            if (i != j) {
                path.add(j);
            }
        } else {
            dfs(i, via[i][j], path);
            path.remove(path.size() - 1);
            dfs(via[i][j], j, path);
        }
    }
}