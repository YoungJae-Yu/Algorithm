import java.io.*;
import java.util.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }
        if (n == 1) {
            System.out.printf(Locale.US, "%.10f\n", 0.0);
            return;
        }
        double[][] dist = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Math.hypot(x[i] - x[j], y[i] - y[j]);
            }
        }
        int M = 1 << n;
        double INF = 1e18;
        double[][] dp = new double[M][n];
        for (int i = 0; i < M; i++) Arrays.fill(dp[i], INF);
        dp[1][0] = 0.0;
        for (int mask = 1; mask < M; mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue;
                double cur = dp[mask][u];
                if (cur >= INF) continue;
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue;
                    int next = mask | (1 << v);
                    double nv = cur + dist[u][v];
                    if (dp[next][v] > nv) dp[next][v] = nv;
                }
            }
        }
        double ans = INF;
        int full = M - 1;
        for (int u = 0; u < n; u++) {
            if (dp[full][u] < INF) {
                ans = Math.min(ans, dp[full][u] + dist[u][0]);
            }
        }
        System.out.printf(Locale.US, "%.10f\n", ans);
    }
}