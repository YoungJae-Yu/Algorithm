import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] weight;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[][] dp;
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        weight = new int[n + 1];
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            weight[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1);

        int maxWeight = Math.max(dp[1][0], dp[1][1]);
        System.out.println(maxWeight);

        visited = new boolean[n + 1]; // 다시 초기화
        result = new ArrayList<>();
        if (dp[1][0] > dp[1][1]) {
            getResult(1, 0);
        } else {
            getResult(1, 1);
        }
        
        result.sort(null);
        for (int node : result) {
            System.out.print(node + " ");
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = weight[node];

        for (int next : tree[node]) {
            if (!visited[next]) {
                dfs(next);
                dp[node][0] += Math.max(dp[next][0], dp[next][1]);
                dp[node][1] += dp[next][0];
            }
        }
    }

    static void getResult(int node, int include) {
        visited[node] = true;
        if (include == 1) {
            result.add(node);
        }

        for (int next : tree[node]) {
            if (!visited[next]) {
                if (include == 1) {
                    getResult(next, 0);
                } else {
                    if (dp[next][0] > dp[next][1]) {
                        getResult(next, 0);
                    } else {
                        getResult(next, 1);
                    }
                }
            }
        }
    }
}