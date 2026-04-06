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

    static int n, m;
    static long[][] ps;
    static long[] dp;
    static int hs, ws;
    static final long INF = Long.MAX_VALUE / 4;

    static int idx(int y, int x, int h, int w) {
        return (((y * m + x) * hs + h) * ws + w);
    }

    static long sum(int y, int x, int h, int w) {
        return ps[y + h][x + w] - ps[y][x + w] - ps[y + h][x] + ps[y][x];
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        m = fs.nextInt();

        ps = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long v = fs.nextInt();
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + v;
            }
        }

        hs = n + 1;
        ws = m + 1;
        dp = new long[n * m * hs * ws];

        for (int h = 1; h <= n; h++) {
            for (int w = 1; w <= m; w++) {
                for (int y = 0; y + h <= n; y++) {
                    for (int x = 0; x + w <= m; x++) {
                        int cur = idx(y, x, h, w);
                        if (h == 1 && w == 1) {
                            dp[cur] = 0;
                            continue;
                        }

                        long total = sum(y, x, h, w);
                        long best = INF;

                        if (h == 1) {
                            for (int cut = 1; cut < w; cut++) {
                                long cand = dp[idx(y, x, h, cut)] + dp[idx(y, x + cut, h, w - cut)];
                                if (cand < best) best = cand;
                            }
                        } else if (w == 1) {
                            for (int cut = 1; cut < h; cut++) {
                                long cand = dp[idx(y, x, cut, w)] + dp[idx(y + cut, x, h - cut, w)];
                                if (cand < best) best = cand;
                            }
                        } else {
                            for (int cut = 1; cut < h; cut++) {
                                long cand = dp[idx(y, x, cut, w)] + dp[idx(y + cut, x, h - cut, w)];
                                if (cand < best) best = cand;
                            }
                            for (int cut = 1; cut < w; cut++) {
                                long cand = dp[idx(y, x, h, cut)] + dp[idx(y, x + cut, h, w - cut)];
                                if (cand < best) best = cand;
                            }
                        }

                        dp[cur] = best + total;
                    }
                }
            }
        }

        System.out.println(dp[idx(0, 0, n, m)]);
    }
}