import java.io.*;
import java.util.*;

public class Main {
    static int[] vals;
    static int[][] dp;

    static int solve(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int d = vals[j] - vals[i];
        long next = (long)vals[j] + d;
        if (next > Integer.MAX_VALUE) {
            dp[i][j] = 2;
            return 2;
        }
        int k = Arrays.binarySearch(vals, (int)next);
        if (k >= 0) dp[i][j] = solve(j, k) + 1;
        else dp[i][j] = 2;
        return dp[i][j];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxFreq) maxFreq = f;
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }
        ArrayList<Integer> list = new ArrayList<>(freq.keySet());
        Collections.sort(list);
        int m = list.size();
        vals = new int[m];
        for (int i = 0; i < m; i++) vals[i] = list.get(i);
        dp = new int[m][m];
        int ans = Math.max(1, maxFreq);
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int len = solve(i, j);
                if (len > ans) ans = len;
            }
        }
        System.out.println(ans);
    }
}