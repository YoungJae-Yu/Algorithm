import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[N+1][10][1<<10];
        for (int d = 1; d <= 9; d++) {
            dp[1][d][1<<d] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int last = 0; last <= 9; last++) {
                for (int mask = 0; mask < (1<<10); mask++) {
                    long ways = dp[len-1][last][mask];
                    if (ways == 0) continue;

                    if (last > 0) {
                        int next = last - 1;
                        int used = mask | (1 << next);
                        dp[len][next][used] = (dp[len][next][used] + ways) % MOD;
                    }
                    if (last < 9) {
                        int next = last + 1;
                        int used = mask | (1 << next);
                        dp[len][next][used] = (dp[len][next][used] + ways) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        int full = (1<<10) - 1;
        for (int d = 0; d <= 9; d++) {
            ans = (ans + dp[N][d][full]) % MOD;
        }
        System.out.println(ans);
    }
}