import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0; // 이 노드가 얼리 어답터가 아닐 때
        dp[node][1] = 1; // 이 노드가 얼리 어답터일 때

        for (int next : tree[node]) {
            if (!visited[next]) {
                dfs(next);
                dp[node][0] += dp[next][1];
                dp[node][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}