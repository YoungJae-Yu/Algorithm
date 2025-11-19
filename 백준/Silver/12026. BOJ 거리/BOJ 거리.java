import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        int INF = Integer.MAX_VALUE / 4;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = INF;
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;
            char cur = s.charAt(i);
            char need = (cur == 'B') ? 'O' : (cur == 'O') ? 'J' : 'B';
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == need) {
                    int cost = (j - i) * (j - i);
                    if (dp[j] > dp[i] + cost) dp[j] = dp[i] + cost;
                }
            }
        }
        System.out.println(dp[n - 1] == INF ? -1 : dp[n - 1]);
    }
}