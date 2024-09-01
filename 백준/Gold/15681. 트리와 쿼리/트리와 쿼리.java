import java.util.*;
import java.io.*;

public class Main {
    static int[] subtreeSize;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드의 수
        int r = Integer.parseInt(st.nextToken()); // 루트 노드
        int q = Integer.parseInt(st.nextToken()); // 쿼리의 수

        tree = new ArrayList[n + 1];
        subtreeSize = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int queryNode = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[queryNode]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        subtreeSize[node] = 1; // 자기 자신을 포함

        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
                subtreeSize[node] += subtreeSize[child];
            }
        }
    }
}