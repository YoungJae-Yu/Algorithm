import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] price;
    static int[][][] dp;
    static int ALL;

    static int dfs(int cur, int visited, int pre) {
        if (visited == ALL) return 1;
        int cached = dp[cur][visited][pre];
        if (cached != 0) return cached;
        int res = 1;
        for (int nxt = 0; nxt < N; nxt++) {
            if ((visited & (1 << nxt)) != 0) continue;
            if (nxt == cur) continue;
            int p = price[cur][nxt];
            if (p >= pre) {
                res = Math.max(res, dfs(nxt, visited | (1 << nxt), p) + 1);
            }
        }
        dp[cur][visited][pre] = res;
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        price = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < N; j++) price[i][j] = s.charAt(j) - '0';
        }
        ALL = (1 << N) - 1;
        dp = new int[N][1 << N][10];
        System.out.println(dfs(0, 1, 0));
    }
}