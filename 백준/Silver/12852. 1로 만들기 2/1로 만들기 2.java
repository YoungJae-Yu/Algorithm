import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        int[] path = new int[N + 1];

        dp[1] = 0; // 1을 1로 만드는 데 필요한 연산은 0번
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }

        System.out.println(dp[N]);

        // 경로 추적
        StringBuilder sb = new StringBuilder();
        int current = N;
        while (current != 0) {
            sb.append(current).append(" ");
            current = path[current];
        }

        System.out.println(sb.toString().trim());
    }
}