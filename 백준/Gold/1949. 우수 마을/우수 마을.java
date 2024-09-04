import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] population;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        population = new int[N + 1];
        tree = new ArrayList[N + 1];
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        // 인구 입력
        for (int i = 1; i <= N; i++) {
            population[i] = sc.nextInt();
            tree[i] = new ArrayList<>();
        }

        // 트리 구조 입력
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        // 루트 노드를 1로 두고 DFS 탐색
        dfs(1);

        // 1번 마을을 우수 마을로 선택하지 않거나, 선택한 경우 중 큰 값
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    // DFS를 통한 DP 계산
    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0; // 현재 노드를 우수 마을로 선택하지 않은 경우
        dp[node][1] = population[node]; // 현재 노드를 우수 마을로 선택한 경우

        for (int next : tree[node]) {
            if (!visited[next]) {
                dfs(next);
                dp[node][0] += Math.max(dp[next][0], dp[next][1]); // 자식 노드를 선택했을 때의 최대값
                dp[node][1] += dp[next][0]; // 자식 노드를 선택하지 않은 경우만 가능
            }
        }
    }
}