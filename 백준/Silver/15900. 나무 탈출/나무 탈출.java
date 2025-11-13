import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static long sum = 0;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            adj[a].add(b); adj[b].add(a);
        }
        visited = new boolean[n + 1];
        dfs(1, 0);
        System.out.println((sum % 2 == 1) ? "Yes" : "No");
    }
    static void dfs(int node, int depth) {
        visited[node] = true;
        boolean leaf = true;
        for (int next : adj[node]) {
            if (!visited[next]) {
                leaf = false;
                dfs(next, depth + 1);
            }
        }
        if (leaf && node != 1) sum += depth;
    }
}