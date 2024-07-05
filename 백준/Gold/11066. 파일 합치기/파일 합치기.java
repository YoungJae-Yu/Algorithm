import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int K = scanner.nextInt(); // 파일의 수
            int[] files = new int[K];
            for (int i = 0; i < K; i++) {
                files[i] = scanner.nextInt();
            }

            System.out.println(minCostToMergeFiles(files));
        }
    }

    public static int minCostToMergeFiles(int[] files) {
        int K = files.length;
        int[][] dp = new int[K][K];
        int[] sum = new int[K + 1];

        // 누적합 계산
        for (int i = 1; i <= K; i++) {
            sum[i] = sum[i - 1] + files[i - 1];
        }

        // DP 테이블 초기화 및 계산
        for (int length = 2; length <= K; length++) { // 부분 파일의 길이
            for (int i = 0; i <= K - length; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
                }
            }
        }

        return dp[0][K - 1];
    }
}