import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        long[][] dp = new long[65][10];
        for (int d = 0; d <= 9; d++) dp[1][d] = 1;
        for (int len = 2; len <= 64; len++) {
            for (int d = 0; d <= 9; d++) {
                long sum = 0;
                for (int k = d; k <= 9; k++) sum += dp[len-1][k];
                dp[len][d] = sum;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long ans = 0;
            for (int d = 0; d <= 9; d++) ans += dp[n][d];
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}