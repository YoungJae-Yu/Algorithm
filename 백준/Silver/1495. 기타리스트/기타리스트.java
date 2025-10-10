import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int idx = 0;
        while (idx < N) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && idx < N) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] dp = new boolean[M + 1];
        if (S >= 0 && S <= M) dp[S] = true;
        for (int i = 0; i < N; i++) {
            boolean[] next = new boolean[M + 1];
            for (int v = 0; v <= M; v++) {
                if (dp[v]) {
                    int up = v + arr[i];
                    int down = v - arr[i];
                    if (up <= M) next[up] = true;
                    if (down >= 0) next[down] = true;
                }
            }
            dp = next;
        }
        int ans = -1;
        for (int v = M; v >= 0; v--) {
            if (dp[v]) {
                ans = v;
                break;
            }
        }
        System.out.println(ans);
    }
}