import java.io.*;
import java.util.*;

public class Main {
    static int sum, w, size;

    static void shiftOr(long[] dest, int dOff, long[] src, int sOff, int len, int shift) {
        if (shift == 0) {
            for (int i = 0; i < len; i++) {
                dest[dOff + i] |= src[sOff + i];
            }
            return;
        }

        int word = shift >>> 6;
        int bit = shift & 63;

        for (int i = len - 1; i >= 0; i--) {
            long val = src[sOff + i];
            if (val == 0) continue;

            int j = i + word;
            if (j < len) dest[dOff + j] |= val << bit;
            if (bit != 0 && j + 1 < len) dest[dOff + j + 1] |= val >>> (64 - bit);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            sum += a[i];
        }

        w = (sum >> 6) + 1;
        size = (sum + 1) * w;

        long[] dp = new long[size];
        dp[0] = 1L;

        for (int v : a) {
            long[] next = new long[size];
            System.arraycopy(dp, 0, next, 0, size);

            for (int x = 0; x + v <= sum; x++) {
                int srcOff = x * w;
                int to1Off = (x + v) * w;
                for (int i = 0; i < w; i++) {
                    next[to1Off + i] |= dp[srcOff + i];
                }
                shiftOr(next, srcOff, dp, srcOff, w, v);
            }

            dp = next;
        }

        int ans = 0;
        for (int x = 0; x <= sum; x++) {
            int off = x * w;
            for (int i = 0; i < w; i++) {
                long bits = dp[off + i];
                while (bits != 0) {
                    long low = bits & -bits;
                    int b = Long.numberOfTrailingZeros(bits);
                    int y = (i << 6) + b;
                    if (y <= sum) {
                        int z = sum - x - y;
                        if (z >= 0 && x >= z && y >= z) {
                            ans = Math.max(ans, z);
                        }
                    }
                    bits ^= low;
                }
            }
        }

        System.out.println(ans);
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
            } while (c <= 32);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}