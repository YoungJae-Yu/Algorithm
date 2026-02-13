import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        @SuppressWarnings("unchecked")
        HashMap<Integer, Long>[] dp = new HashMap[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = new HashMap<>();
        }
        long answer = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int diff = arr[i] - arr[j];
                Long prev = dp[j].get(diff);
                if (prev == null) {
                    long pairSum = (long) arr[j] + arr[i];
                    Long exist = dp[i].get(diff);
                    if (exist == null || pairSum > exist) dp[i].put(diff, pairSum);
                } else {
                    long newSum = prev + arr[i];
                    Long exist = dp[i].get(diff);
                    if (exist == null || newSum > exist) dp[i].put(diff, newSum);
                    if (newSum > answer) answer = newSum;
                }
            }
        }
        System.out.println(answer);
    }
}