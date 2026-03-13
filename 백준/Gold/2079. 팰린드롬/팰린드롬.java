import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int i = 0; i < n; i++) isPal[i][i] = true;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) isPal[i][j] = true;
                    else isPal[i][j] = isPal[i+1][j-1];
                } else {
                    isPal[i][j] = false;
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE / 2;
            for (int j = 0; j <= i; j++) {
                if (isPal[j][i]) {
                    if (j == 0) dp[i] = 1;
                    else dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }
        System.out.println(dp[n-1]);
    }
}