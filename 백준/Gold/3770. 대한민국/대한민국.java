import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
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
            do {
                c = read();
            } while (c <= 32 && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > 32 && c != -1) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    static class Fenwick {
        long[] tree;

        Fenwick(int n) {
            tree = new long[n + 2];
        }

        void add(int idx, long val) {
            int n = tree.length - 1;
            while (idx <= n) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        long sum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += tree[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int k = fs.nextInt();

            long[] roads = new long[k];
            int[] west = new int[k];

            for (int i = 0; i < k; i++) {
                int east = fs.nextInt();
                int w = fs.nextInt();
                roads[i] = (((long) east) << 32) | (w & 0xffffffffL);
                west[i] = w;
            }

            Arrays.sort(roads);
            Arrays.sort(west);

            int size = 0;
            for (int i = 0; i < k; i++) {
                if (i == 0 || west[i] != west[i - 1]) {
                    west[size++] = west[i];
                }
            }

            Fenwick bit = new Fenwick(size + 2);
            long ans = 0;
            long seen = 0;

            for (int i = 0; i < k; i++) {
                int w = (int) roads[i];
                int idx = Arrays.binarySearch(west, 0, size, w) + 1;
                ans += seen - bit.sum(idx);
                bit.add(idx, 1);
                seen++;
            }

            sb.append("Test case ").append(tc).append(": ").append(ans).append('\n');
        }

        System.out.print(sb);
    }
}