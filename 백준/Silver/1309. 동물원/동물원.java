import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        final int MOD = 9901;
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[][] dp = new int[n + 1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = ((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }
        int ans = 0;
        for (int j = 0; j < 3; j++) ans = (ans + dp[n][j]) % MOD;
        System.out.println(ans);
    }
}