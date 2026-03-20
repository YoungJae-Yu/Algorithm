import java.io.*;
import java.util.*;

public class Main {
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

    static void orShift(long[] src, long[] dst, int shift, int words) {
        int wordShift = shift >>> 6;
        int bitShift = shift & 63;
        if (wordShift >= words) return;

        if (bitShift == 0) {
            for (int i = 0; i < words - wordShift; i++) {
                dst[i + wordShift] |= src[i];
            }
        } else {
            int right = 64 - bitShift;
            for (int i = 0; i < words; i++) {
                long v = src[i];
                if (v == 0) continue;
                int j = i + wordShift;
                if (j < words) dst[j] |= v << bitShift;
                if (j + 1 < words) dst[j + 1] |= v >>> right;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = fs.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int[] scores = new int[m];
            for (int i = 0; i < m; i++) scores[i] = fs.nextInt();

            int maxScore = n;
            int words = (n >> 6) + 1;

            long[][] dp = new long[maxScore + 1][words];
            boolean[] alive = new boolean[maxScore + 1];

            dp[0][0] = 1L;
            alive[0] = true;

            for (int s = 0; s <= maxScore; s++) {
                if (!alive[s]) continue;
                long[] src = dp[s];

                for (int x : scores) {
                    int ns = s + x;
                    if (ns > maxScore) continue;
                    orShift(src, dp[ns], ns, words);
                    alive[ns] = true;
                }
            }

            int word = n >> 6;
            int bit = n & 63;
            int ans = -1;

            for (int s = maxScore; s >= 0; s--) {
                if (((dp[s][word] >>> bit) & 1L) != 0) {
                    ans = s;
                    break;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}