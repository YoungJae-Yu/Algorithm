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

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] w = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            w[i] = fs.nextInt();
            total += w[i];
        }

        int k = n / 2;
        boolean[][] dp = new boolean[k + 1][total + 1];
        dp[0][0] = true;

        for (int weight : w) {
            for (int cnt = k; cnt >= 1; cnt--) {
                for (int sum = total; sum >= weight; sum--) {
                    if (dp[cnt - 1][sum - weight]) {
                        dp[cnt][sum] = true;
                    }
                }
            }
        }

        int bestSum = 0;
        int bestDiff = Integer.MAX_VALUE;

        for (int sum = 0; sum <= total; sum++) {
            if (dp[k][sum]) {
                int diff = Math.abs(total - 2 * sum);
                if (diff < bestDiff) {
                    bestDiff = diff;
                    bestSum = sum;
                }
            }
        }

        int a = bestSum;
        int b = total - bestSum;

        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        System.out.println(a + " " + b);
    }
}