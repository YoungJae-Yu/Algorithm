import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 행렬의 개수
        int[][] matrices = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            matrices[i][0] = scanner.nextInt(); // 행의 수
            matrices[i][1] = scanner.nextInt(); // 열의 수
        }
        
        System.out.println(minCostToMultiplyMatrices(matrices));
    }

    public static int minCostToMultiplyMatrices(int[][] matrices) {
        int N = matrices.length;
        int[][] dp = new int[N][N];

        for (int length = 2; length <= N; length++) {
            for (int i = 0; i <= N - length; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + matrices[i][0] * matrices[k][1] * matrices[j][1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][N - 1];
    }
}