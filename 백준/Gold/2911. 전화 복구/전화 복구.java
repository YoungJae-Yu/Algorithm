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

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            long p = fs.nextLong();
            long c = fs.nextLong();
            arr[i] = (p << 32) | (c & 0xffffffffL);
        }

        Arrays.sort(arr);

        long ans = 0;
        long prev = 0;

        for (int i = 0; i < n; i++) {
            long c = arr[i] & 0xffffffffL;
            if (c > prev) ans += c - prev;
            prev = c;
        }

        System.out.println(ans);
    }
}