import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        final int MOD = 10007;
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= N; i++) {
            int[] ndp = new int[10];
            ndp[0] = dp[0] % MOD;
            for (int j = 1; j < 10; j++) {
                ndp[j] = (ndp[j - 1] + dp[j]) % MOD;
            }
            dp = ndp;
        }
        int ans = 0;
        for (int v : dp) ans = (ans + v) % MOD;
        System.out.println(ans);
    }
}