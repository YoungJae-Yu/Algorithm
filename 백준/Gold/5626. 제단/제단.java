import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MOD = 1000000007;
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            int limit = Math.min(i, (N - 1) - i);
            if (a[i] > limit) {
                System.out.println(0);
                return;
            }
        }
        int maxCol = (N / 2) + 2;
        int[][] dp = new int[2][maxCol];
        dp[0][0] = 1;
        for (int i = 1; i < N; i++) {
            int cur = i & 1;
            int prev = 1 - cur;
            Arrays.fill(dp[cur], 0);
            int len = Math.min(i, (N - 1) - i);
            int prevLen = Math.min(i - 1, (N - 1) - (i - 1));
            if (a[i] == -1) {
                for (int h = 0; h <= len; h++) {
                    long sum = 0;
                    for (int d = -1; d <= 1; d++) {
                        int adj = h + d;
                        if (adj < 0 || adj > prevLen) continue;
                        sum += dp[prev][adj];
                    }
                    dp[cur][h] = (int)(sum % MOD);
                }
            } else {
                int h = a[i];
                long sum = 0;
                for (int d = -1; d <= 1; d++) {
                    int adj = h + d;
                    if (adj < 0 || adj > prevLen) continue;
                    sum += dp[prev][adj];
                }
                dp[cur][h] = (int)(sum % MOD);
            }
        }
        System.out.println(dp[(N - 1) & 1][0]);
    }
}