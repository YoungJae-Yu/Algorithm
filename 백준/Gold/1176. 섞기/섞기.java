import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] h = new int[N];
        for (int i = 0; i < N; i++) h[i] = Integer.parseInt(br.readLine());
        int full = (1 << N) - 1;
        long[][] dp = new long[1 << N][N];
        for (int i = 0; i < N; i++) dp[1 << i][i] = 1;
        for (int mask = 0; mask <= full; mask++) {
            for (int last = 0; last < N; last++) {
                long cur = dp[mask][last];
                if (cur == 0) continue;
                for (int nxt = 0; nxt < N; nxt++) {
                    if ((mask & (1 << nxt)) != 0) continue;
                    if (Math.abs(h[last] - h[nxt]) > K) {
                        dp[mask | (1 << nxt)][nxt] += cur;
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < N; i++) ans += dp[full][i];
        System.out.println(ans);
    }
}