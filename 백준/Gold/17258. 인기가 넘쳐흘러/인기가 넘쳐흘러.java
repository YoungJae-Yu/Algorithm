import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, T;
    static int[] people;
    static int[] memo;

    static int solve(int idx, int k, int pre) {
        if (idx == N + 1) return 0;

        int pos = ((idx * (K + 1)) + k) * (T + 1) + pre;
        if (memo[pos] != -1) return memo[pos];

        int cur = people[idx];
        int ans;

        if (cur >= T) {
            ans = solve(idx + 1, k, 0) + 1;
        } else if (cur + pre >= T) {
            ans = solve(idx + 1, k, pre) + 1;
        } else {
            ans = solve(idx + 1, k, pre);

            int need = T - (cur + pre);
            if (need <= k) {
                ans = Math.max(ans, solve(idx + 1, k - need, pre + need) + 1);
            }
        }

        memo[pos] = ans;
        return ans;
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        M = fs.nextInt();
        K = fs.nextInt();
        T = fs.nextInt();

        int[] diff = new int[N + 3];

        for (int i = 0; i < M; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            diff[a]++;
            diff[b]--;
        }

        people = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            people[i] = people[i - 1] + diff[i];
        }

        memo = new int[(N + 2) * (K + 1) * (T + 1)];
        Arrays.fill(memo, -1);

        System.out.println(solve(1, K, 0));
    }
}