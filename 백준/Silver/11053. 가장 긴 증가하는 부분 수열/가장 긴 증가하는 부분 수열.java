import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N]; // dp[i]: arr[i]를 마지막으로 하는 LIS 길이
        Arrays.fill(dp, 1); // 초기값 1로 설정

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) { // arr[j]가 arr[i]보다 작다면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp[i] 갱신
                }
            }
        }

        int maxLen = Arrays.stream(dp).max().getAsInt();
        System.out.println(maxLen);
    }
}
