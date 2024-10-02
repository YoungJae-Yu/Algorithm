import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static ArrayList<int[]>[] adj;
    static int[][] parent, minDist, maxDist;
    static int[] depth;
    static final int INF = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = (int) (Math.log(N) / Math.log(2)) + 1;

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        parent = new int[N + 1][K];
        minDist = new int[N + 1][K];
        maxDist = new int[N + 1][K];
        depth = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(minDist[i], INF);
        }

        dfs(1, 0, 0);
        preprocess();

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int[] result = lca(u, v);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int node, int par, int dist) {
        depth[node] = depth[par] + 1;
        parent[node][0] = par;
        for (int[] next : adj[node]) {
            int nextNode = next[0];
            int weight = next[1];
            if (nextNode != par) {
                minDist[nextNode][0] = weight;
                maxDist[nextNode][0] = weight;
                dfs(nextNode, node, weight);
            }
        }
    }

    static void preprocess() {
        for (int j = 1; j < K; j++) {
            for (int i = 1; i <= N; i++) {
                if (parent[i][j - 1] != 0) {
                    parent[i][j] = parent[parent[i][j - 1]][j - 1];
                    minDist[i][j] = Math.min(minDist[i][j - 1], minDist[parent[i][j - 1]][j - 1]);
                    maxDist[i][j] = Math.max(maxDist[i][j - 1], maxDist[parent[i][j - 1]][j - 1]);
                }
            }
        }
    }

    static int[] lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int minAns = INF;
        int maxAns = 0;

        for (int i = K - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                minAns = Math.min(minAns, minDist[u][i]);
                maxAns = Math.max(maxAns, maxDist[u][i]);
                u = parent[u][i];
            }
        }

        if (u == v) {
            return new int[]{minAns, maxAns};
        }

        for (int i = K - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                minAns = Math.min(minAns, Math.min(minDist[u][i], minDist[v][i]));
                maxAns = Math.max(maxAns, Math.max(maxDist[u][i], maxDist[v][i]));
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        minAns = Math.min(minAns, Math.min(minDist[u][0], minDist[v][0]));
        maxAns = Math.max(maxAns, Math.max(maxDist[u][0], maxDist[v][0]));

        return new int[]{minAns, maxAns};
    }
}