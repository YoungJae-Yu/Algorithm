import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][n];
        dp[0][0] = 1L;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                int jump = a[i][j];
                if (jump == 0) continue;
                if (i + jump < n) dp[i + jump][j] += dp[i][j];
                if (j + jump < n) dp[i][j + jump] += dp[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}