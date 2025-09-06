import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] a = new int[2][n + 1];
            for (int r = 0; r < 2; r++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= n; i++) a[r][i] = Integer.parseInt(st.nextToken());
            }
            if (n == 0) {
                sb.append(0).append('\n');
                continue;
            }
            int[][] dp = new int[2][n + 1];
            dp[0][1] = a[0][1];
            dp[1][1] = a[1][1];
            if (n >= 2) {
                dp[0][2] = dp[1][1] + a[0][2];
                dp[1][2] = dp[0][1] + a[1][2];
            }
            for (int i = 3; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + a[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + a[1][i];
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, Math.max(dp[0][i], dp[1][i]));
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}