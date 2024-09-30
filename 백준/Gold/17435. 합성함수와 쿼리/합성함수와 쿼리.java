import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_K = 60;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        dp = new int[MAX_K + 1][m + 1];

        // 함수 f(x) 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            dp[0][i] = Integer.parseInt(st.nextToken());
        }

        // dp[k][x] 계산: f를 2^k번 적용한 결과
        for (int k = 1; k <= MAX_K; k++) {
            for (int x = 1; x <= m; x++) {
                dp[k][x] = dp[k - 1][dp[k - 1][x]];
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int currentX = x;

            for (int k = MAX_K; k >= 0; k--) {
                if ((n & (1L << k)) != 0) {
                    currentX = dp[k][currentX];
                }
            }

            sb.append(currentX).append('\n');
        }

        System.out.print(sb);
    }
}
