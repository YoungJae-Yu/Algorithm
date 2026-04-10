import java.io.BufferedInputStream;
import java.io.IOException;

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

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= 32 && c != -1);

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > 32 && c != -1) {
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
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int r = m / 2;

        long[][] need = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                need[i][j] = -fs.nextLong();
            }
        }

        long[][] diff = new long[n + 1][n + 1];
        long[][] cover = new long[n][n];
        long[][] ans = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long cur = diff[i][j];
                if (i > 0) cur += cover[i - 1][j];
                if (j > 0) cur += cover[i][j - 1];
                if (i > 0 && j > 0) cur -= cover[i - 1][j - 1];

                if (i <= n - m && j <= n - m) {
                    long add = need[i][j] - cur;
                    ans[i + r][j + r] = add;

                    diff[i][j] += add;
                    diff[i + m][j] -= add;
                    diff[i][j + m] -= add;
                    diff[i + m][j + m] += add;

                    cur += add;
                }

                cover[i][j] = cur;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}