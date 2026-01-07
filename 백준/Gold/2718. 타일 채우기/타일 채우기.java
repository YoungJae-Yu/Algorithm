import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] qs = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            qs[i] = Integer.parseInt(br.readLine());
            if (qs[i] > max) max = qs[i];
        }
        int[] dp = new int[Math.max(4, max + 1)];
        dp[0] = 1;
        if (max >= 1) dp[1] = 1;
        if (max >= 2) dp[2] = 5;
        if (max >= 3) dp[3] = 11;
        for (int i = 4; i <= max; i++) {
            int res = dp[i - 1] + 4 * dp[i - 2];
            for (int k = 3; k <= i; k++) {
                if (k % 2 == 0) res += 3 * dp[i - k];
                else res += 2 * dp[i - k];
            }
            dp[i] = res;
        }
        StringBuilder sb = new StringBuilder();
        for (int v : qs) sb.append(dp[v]).append('\n');
        System.out.print(sb.toString());
    }
}