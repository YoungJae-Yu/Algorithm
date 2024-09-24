import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // Red
            cost[i][1] = Integer.parseInt(st.nextToken()); // Green
            cost[i][2] = Integer.parseInt(st.nextToken()); // Blue
        }
        
        int result = INF;
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N+1][3];
            for (int i = 0; i < 3; i++) {
                if (i == firstColor) {
                    dp[1][i] = cost[1][i];
                } else {
                    dp[1][i] = INF;
                }
            }
            
            for (int i = 2; i <= N; i++) {
                dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }
            
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == firstColor) continue;
                result = Math.min(result, dp[N][lastColor]);
            }
        }
        
        System.out.println(result);
    }
}