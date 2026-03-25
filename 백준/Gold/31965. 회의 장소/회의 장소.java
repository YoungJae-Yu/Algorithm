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

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);
            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    static int n, q;
    static long[] x, pref;

    static int lowerBound(long val) {
        int l = 1, r = n + 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (x[m] < val) l = m + 1;
            else r = m;
        }
        return l;
    }

    static int upperBound(long val) {
        int l = 1, r = n + 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (x[m] <= val) l = m + 1;
            else r = m;
        }
        return l;
    }

    static long cost(int l, int r, int k) {
        long left = x[k] * (k - l) - (pref[k - 1] - pref[l - 1]);
        long right = (pref[r] - pref[k]) - x[k] * (r - k);
        return left + right;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = fs.nextInt();
        q = fs.nextInt();

        x = new long[n + 1];
        pref = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            x[i] = fs.nextLong();
            pref[i] = pref[i - 1] + x[i];
        }

        while (q-- > 0) {
            long lVal = fs.nextLong();
            long rVal = fs.nextLong();

            int l = lowerBound(lVal);
            int r = upperBound(rVal) - 1;

            if (l > r) {
                sb.append(0).append('\n');
                continue;
            }

            if (l == r) {
                sb.append(0).append('\n');
                continue;
            }

            int m = (l + r) >>> 1;
            long maxCost = Math.max(cost(l, r, l), cost(l, r, r));
            long minCost = cost(l, r, m);

            sb.append(maxCost - minCost).append('\n');
        }

        System.out.print(sb);
    }
}