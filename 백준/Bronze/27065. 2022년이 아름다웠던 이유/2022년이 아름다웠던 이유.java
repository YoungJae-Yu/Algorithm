import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] nums = new int[T];
        int max = 0;
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[] dp = new int[max + 1];

        for (int i = 2; i <= max; i++) {
            int sum = 0;
            boolean flag = true;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                    if (dp[j] > 0) {
                        flag = false;
                    }
                }
            }
            if (sum > i) {
                dp[i] = flag ? 2 : 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            if (dp[n] == 2) {
                sb.append("Good Bye\n");
            } else {
                sb.append("BOJ 2022\n");
            }
        }
        System.out.print(sb.toString());
    }
}