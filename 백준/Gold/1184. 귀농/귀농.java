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

    static long[][] ps;
    static int n;

    static long sum(int r1, int c1, int r2, int c2) {
        if (r1 > r2 || c1 > c2) return 0;
        return ps[r2][c2] - ps[r1 - 1][c2] - ps[r2][c1 - 1] + ps[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();

        long[][] a = new long[n + 1][n + 1];
        ps = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = fs.nextInt();
                ps[i][j] = a[i][j] + ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
            }
        }

        long ans = 0;

        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= n; c++) {
                HashMap<Long, Integer> map = new HashMap<>();

                for (int tr = 1; tr <= r; tr++) {
                    for (int lc = 1; lc <= c; lc++) {
                        long v = sum(tr, lc, r, c);
                        map.put(v, map.getOrDefault(v, 0) + 1);
                    }
                }

                for (int br = r + 1; br <= n; br++) {
                    for (int rc = c + 1; rc <= n; rc++) {
                        long v = sum(r + 1, c + 1, br, rc);
                        ans += map.getOrDefault(v, 0);
                    }
                }

                map.clear();

                for (int tr = 1; tr <= r; tr++) {
                    for (int rc = c + 1; rc <= n; rc++) {
                        long v = sum(tr, c + 1, r, rc);
                        map.put(v, map.getOrDefault(v, 0) + 1);
                    }
                }

                for (int br = r + 1; br <= n; br++) {
                    for (int lc = 1; lc <= c; lc++) {
                        long v = sum(r + 1, lc, br, c);
                        ans += map.getOrDefault(v, 0);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}