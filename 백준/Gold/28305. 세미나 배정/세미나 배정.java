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

    static int n;
    static long t;
    static long[] a;

    static boolean possible(int k) {
        long[] s = new long[n];
        for (int i = 0; i < n; i++) {
            long l = Math.max(1L, a[i] - t + 1);
            long r = a[i];
            if (i < k) {
                s[i] = l;
            } else {
                s[i] = Math.max(l, s[i - k] + t);
            }
            if (s[i] > r) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        t = fs.nextLong();

        a = new long[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextLong();

        Arrays.sort(a);

        int lo = 1, hi = n, ans = n;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (possible(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }
}