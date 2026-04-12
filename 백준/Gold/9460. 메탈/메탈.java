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

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, k;
    static Point[] points;

    static boolean possible(long cost2) {
        int cnt = 1;
        long minY = points[0].y;
        long maxY = points[0].y;

        for (int i = 1; i < n; i++) {
            long y = points[i].y;
            long newMin = Math.min(minY, y);
            long newMax = Math.max(maxY, y);

            if (newMax - newMin > cost2) {
                cnt++;
                minY = y;
                maxY = y;
            } else {
                minY = newMin;
                maxY = newMax;
            }
        }

        return cnt <= k;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            k = fs.nextInt();
            points = new Point[n];

            long minY = Long.MAX_VALUE;
            long maxY = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                long x = fs.nextLong();
                long y = fs.nextLong();
                points[i] = new Point(x, y);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }

            Arrays.sort(points, (a, b) -> {
                if (a.x == b.x) return Long.compare(a.y, b.y);
                return Long.compare(a.x, b.x);
            });

            long lo = 0;
            long hi = maxY - minY;

            while (lo < hi) {
                long mid = (lo + hi) >>> 1;
                if (possible(mid)) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            if ((lo & 1L) == 0) {
                sb.append(lo / 2).append(".0\n");
            } else {
                sb.append(lo / 2).append(".5\n");
            }
        }

        System.out.print(sb);
    }
}