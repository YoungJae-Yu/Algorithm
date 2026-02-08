import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] cnt = new int[10001];
        int zeros = 0;
        List<Integer> list = new ArrayList<>();
        int totalMax = 0;
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine().trim());
            if (v == 0) {
                zeros++;
            } else {
                if (cnt[v] == 0) list.add(v);
                cnt[v]++;
                totalMax += v;
            }
        }
        final int MAX = 500000;
        boolean[] isComposite = new boolean[MAX + 1];
        if (MAX >= 0) {
            isComposite[0] = true;
            if (MAX >= 1) isComposite[1] = true;
        }
        for (int i = 2; i * i <= MAX; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= MAX; j += i) isComposite[j] = true;
            }
        }
        long[] dp = new long[MAX + 1];
        dp[0] = 1;
        int currMax = 0;
        for (int val : list) {
            int c = cnt[val];
            for (int j = currMax; j >= 0; j--) {
                long base = dp[j];
                if (base == 0) continue;
                int add = val;
                for (int k = 1; k <= c; k++) {
                    int nj = j + add * k;
                    if (nj > MAX) break;
                    dp[nj] += base;
                }
            }
            currMax += val * c;
            if (currMax > MAX) currMax = MAX;
        }
        long ans = 0;
        for (int s = 2; s <= MAX; s++) {
            if (!isComposite[s]) ans += dp[s];
        }
        ans *= (long)(zeros + 1);
        System.out.print(ans);
    }
}