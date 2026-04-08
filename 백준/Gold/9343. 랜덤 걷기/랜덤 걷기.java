import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    static final long MOD = 1_000_000_007L;
    static long[] fact;
    static long[] invFact;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        int[] arr = new int[t];
        int max = 0;

        for (int i = 0; i < t; i++) {
            arr[i] = fs.nextInt();
            if (arr[i] > max) max = arr[i];
        }

        precompute(2 * max);

        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            long ans = fact[2 * n];
            ans = ans * invFact[n] % MOD;
            ans = ans * invFact[n] % MOD;
            ans = ans * modPow(n + 1L, MOD - 2) % MOD;
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static void precompute(int size) {
        fact = new long[size + 1];
        invFact = new long[size + 1];

        fact[0] = 1;
        for (int i = 1; i <= size; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[size] = modPow(fact[size], MOD - 2);
        for (int i = size - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    static long modPow(long a, long e) {
        long result = 1;
        while (e > 0) {
            if ((e & 1) == 1) result = result * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return result;
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = new BufferedInputStream(is);
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
}