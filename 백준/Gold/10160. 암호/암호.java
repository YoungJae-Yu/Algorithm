import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1000000009L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] dp = new long[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = (dp[i - 1] * K) % MOD;
            if (i >= 5) dp[i] = (dp[i] - 2 * dp[i - 5]) % MOD;
            if (i >= 7) dp[i] = (dp[i] + dp[i - 7]) % MOD;
            if (dp[i] < 0) dp[i] += MOD;
        }
        System.out.println(dp[N]);
    }
}