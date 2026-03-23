import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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

    static long sumDigitsFrom0To(long n) {
        if (n < 0) return 0L;

        long sum = 0L;
        for (long p = 1; p <= n; p *= 10) {
            long higher = n / (p * 10);
            long cur = (n / p) % 10;
            long lower = n % p;

            sum += higher * 45L * p;
            sum += cur * (cur - 1) / 2 * p;
            sum += cur * (lower + 1);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            long ans = sumDigitsFrom0To(b) - sumDigitsFrom0To(a - 1);
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}