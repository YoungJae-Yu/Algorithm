import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_000L;

    public static long[] fib(long n) {
        if (n == 0) return new long[]{0, 1};
        long[] p = fib(n >> 1);
        long a = p[0];
        long b = p[1];
        long c = (a * ((2 * b % MOD - a + MOD) % MOD)) % MOD;
        long d = (a * a % MOD + b * b % MOD) % MOD;
        if ((n & 1) == 0) return new long[]{c, d};
        else return new long[]{d, (c + d) % MOD};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long fb2 = fib(b + 2)[0];
        long fa1 = fib(a + 1)[0];
        long ans = (fb2 - fa1 + MOD) % MOD;
        System.out.println(ans);
    }
}