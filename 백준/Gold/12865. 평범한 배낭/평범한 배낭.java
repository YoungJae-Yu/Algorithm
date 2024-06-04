import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품의 개수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] dp = new int[N + 1][K + 1]; // dp[i][j]: i번째 물건까지 고려하여 무게 j를 채웠을 때 최대 가치
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // 냅색 알고리즘 (Knapsack Algorithm)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j < weights[i]) { // 현재 물건을 담을 수 없을 때
                    dp[i][j] = dp[i - 1][j]; // 이전 물건까지 고려한 가치를 그대로 사용
                } else { // 현재 물건을 담을 수 있을 때
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                    // 1. 현재 물건을 담지 않은 경우: dp[i - 1][j]
                    // 2. 현재 물건을 담은 경우: dp[i - 1][j - weights[i]] + values[i]
                }
            }
        }

        System.out.println(dp[N][K]); // 모든 물건을 고려하고 최대 무게 K를 채웠을 때 최대 가치 출력
    }
}
