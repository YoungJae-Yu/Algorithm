import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[][] dp = new long[2][C + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            int cur = i & 1;
            int prev = cur ^ 1;
            dp[cur][0] = 1;

            for (int j = 1; j <= C; j++) {
                long value = dp[cur][j - 1] + dp[prev][j];
                if (j >= i) value -= dp[prev][j - i];
                value %= MOD;
                if (value < 0) value += MOD;
                dp[cur][j] = value;
            }
        }

        System.out.println(dp[N & 1][C]);
    }
}