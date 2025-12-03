import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] small = new int[N+4];
        int[] big = new int[N+4];
        for (int i = 1; i <= N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            small[i] = Integer.parseInt(st.nextToken());
            big[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine().trim());
        int INF = 1_000_000_000;
        int[][] dp = new int[N+4][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = dp[i][1] = INF;
        }
        dp[1][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int used = 0; used <= 1; used++) {
                if (dp[i][used] == INF) continue;
                if (i + 1 <= N) dp[i+1][used] = Math.min(dp[i+1][used], dp[i][used] + small[i]);
                if (i + 2 <= N) dp[i+2][used] = Math.min(dp[i+2][used], dp[i][used] + big[i]);
                if (used == 0 && i + 3 <= N) dp[i+3][1] = Math.min(dp[i+3][1], dp[i][used] + K);
            }
        }
        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}