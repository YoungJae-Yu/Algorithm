import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cost = new int[N];
        long sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
            sum += cost[i];
            if (cost[i] > max) max = cost[i];
        }

        long left = max;
        long right = sum;
        long answer = sum;

        while (left <= right) {
            long mid = (left + right) / 2;
            int required = 1;
            long cur = 0;
            for (int i = 0; i < N; i++) {
                if (cur + cost[i] > mid) {
                    required++;
                    cur = cost[i];
                } else {
                    cur += cost[i];
                }
            }
            if (required <= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}