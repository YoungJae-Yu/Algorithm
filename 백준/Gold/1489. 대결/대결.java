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
            } while (c <= ' ');

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

    static int hungarian(int[][] cost) {
        int n = cost.length - 1;
        int[] u = new int[n + 1];
        int[] v = new int[n + 1];
        int[] p = new int[n + 1];
        int[] way = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[0] = i;
            int j0 = 0;
            int[] minv = new int[n + 1];
            boolean[] used = new boolean[n + 1];
            Arrays.fill(minv, Integer.MAX_VALUE);

            do {
                used[j0] = true;
                int i0 = p[j0];
                int delta = Integer.MAX_VALUE;
                int j1 = 0;

                for (int j = 1; j <= n; j++) {
                    if (!used[j]) {
                        int cur = cost[i0][j] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0;
                        }
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }

                for (int j = 0; j <= n; j++) {
                    if (used[j]) {
                        u[p[j]] += delta;
                        v[j] -= delta;
                    } else {
                        minv[j] -= delta;
                    }
                }

                j0 = j1;
            } while (p[j0] != 0);

            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }

        int total = 0;
        int[] match = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            match[p[j]] = j;
        }
        for (int i = 1; i <= n; i++) {
            total += cost[i][match[i]];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        for (int i = 1; i <= n; i++) a[i] = fs.nextInt();
        for (int i = 1; i <= n; i++) b[i] = fs.nextInt();

        int[][] cost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int score;
                if (a[i] > b[j]) score = 2;
                else if (a[i] == b[j]) score = 1;
                else score = 0;
                cost[i][j] = 2 - score;
            }
        }

        int minCost = hungarian(cost);
        int answer = 2 * n - minCost;
        System.out.println(answer);
    }
}