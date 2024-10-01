import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] parent;
    static int[] depth;
    static ArrayList<ArrayList<Integer>> adj;
    static final int LOG = 17; // 2^17 > 100000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        depth = new int[N + 1];
        parent = new int[N + 1][LOG];
        dfs(1, 0); // 루트는 1, 부모는 0으로 설정

        // 희소 배열 세팅
        for (int i = 1; i < LOG; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }

        System.out.print(sb.toString());
    }

    // DFS로 깊이와 부모 계산
    static void dfs(int node, int par) {
        depth[node] = depth[par] + 1;
        parent[node][0] = par;

        for (int next : adj.get(node)) {
            if (next != par) {
                dfs(next, node);
            }
        }
    }

    // LCA 계산
    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 깊이를 맞춰줌
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[a] - (1 << i) >= depth[b]) {
                a = parent[a][i];
            }
        }

        if (a == b) return a;

        // 이진 거듭제곱 점프
        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }
}