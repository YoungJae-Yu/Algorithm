import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] memory = new int[N];
        int[] cost = new int[N];
        for (int i = 0; i < N; i++) {
            memory[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
        }
        int sumCost = 0;
        for (int i = 0; i < N; i++) {
            sumCost += cost[i];
        }
        int[] dp = new int[sumCost + 1];
        for (int i = 0; i < N; i++) {
            for (int j = sumCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= sumCost; i++) {
            if (dp[i] >= M) {
                answer = Math.min(answer, i);
            }
        }
        System.out.println(answer);
    }
}