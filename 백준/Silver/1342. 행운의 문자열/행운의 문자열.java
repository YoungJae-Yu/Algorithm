import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[] arr;
    static long[][] dp;
    static int ALL;
    static long solve(int mask, int last) {
        if (mask == ALL) return 1;
        long res = dp[mask][last+1];
        if (res != -1) return res;
        res = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                if (last != -1 && arr[i] == arr[last]) continue;
                if (i > 0 && arr[i] == arr[i - 1] && ((mask & (1 << (i - 1))) == 0)) continue;
                res += solve(mask | (1 << i), i);
            }
        }
        dp[mask][last+1] = res;
        return res;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        n = s.length();
        arr = s.toCharArray();
        Arrays.sort(arr);
        ALL = (1 << n) - 1;
        dp = new long[1 << n][n + 1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        System.out.println(solve(0, -1));
    }
}