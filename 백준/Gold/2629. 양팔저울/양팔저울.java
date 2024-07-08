import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] marbles = new int[M];
        for (int i = 0; i < M; i++) {
            marbles[i] = sc.nextInt();
        }
        
        boolean[][] dp = new boolean[N + 1][40001];
        dp[0][0] = true;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 40000; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    dp[i][j + weights[i - 1]] = true;
                    dp[i][Math.abs(j - weights[i - 1])] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int marble : marbles) {
            if (marble > 40000) {
                sb.append("N ");
            } else {
                sb.append(dp[N][marble] ? "Y " : "N ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}