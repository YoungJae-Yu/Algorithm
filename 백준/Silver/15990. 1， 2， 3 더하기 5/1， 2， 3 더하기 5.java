import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        int[] qs = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            qs[i] = Integer.parseInt(br.readLine().trim());
            if (qs[i] > max) max = qs[i];
        }

        final long MOD = 1_000_000_009L;
        long[][] dp = new long[max + 1][4];

        if (max >= 1) dp[1][1] = 1;
        if (max >= 2) dp[2][2] = 1;
        if (max >= 3) {
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
        }

        for (int n = 4; n <= max; n++) {
            dp[n][1] = (dp[n-1][2] + dp[n-1][3]) % MOD;
            dp[n][2] = (dp[n-2][1] + dp[n-2][3]) % MOD;
            dp[n][3] = (dp[n-3][1] + dp[n-3][2]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = qs[i];
            long ans = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}