import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long INF = 1000000000000000000L;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    sum += dp[i - j];
                    if (sum > INF) sum = INF;
                }
            }
            dp[i] = sum;
        }
        if (dp[n] < k) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int remain = n;
        while (remain > 0) {
            for (int x = 1; x <= 3; x++) {
                if (remain - x < 0) continue;
                long cnt = dp[remain - x];
                if (k <= cnt) {
                    if (sb.length() > 0) sb.append('+');
                    sb.append(x);
                    remain -= x;
                    break;
                } else {
                    k -= cnt;
                }
            }
        }
        System.out.println(sb.toString());
    }
}