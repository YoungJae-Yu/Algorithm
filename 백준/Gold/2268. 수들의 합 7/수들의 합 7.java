import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] bit;
    static long[] arr;
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();
        N = fs.nextInt();
        M = fs.nextInt();
        bit = new long[N + 1];
        arr = new long[N + 1];
        for (int k = 0; k < M; k++) {
            int type = fs.nextInt();
            int i = fs.nextInt();
            int j = fs.nextInt();
            if (type == 0) {
                int l = Math.min(i, j);
                int r = Math.max(i, j);
                sb.append(prefixSum(r) - prefixSum(l - 1)).append('\n');
            } else {
                long diff = (long) j - arr[i];
                arr[i] = j;
                update(i, diff);
            }
        }
        System.out.print(sb.toString());
    }
    static void update(int idx, long diff) {
        while (idx <= N) {
            bit[idx] += diff;
            idx += idx & -idx;
        }
    }
    static long prefixSum(int idx) {
        long sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
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
        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
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
}