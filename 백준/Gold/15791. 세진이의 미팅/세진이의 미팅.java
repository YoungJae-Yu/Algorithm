import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1000000007L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        if (m > n) {
            System.out.println(0);
            return;
        }
        if (m == 0) {
            System.out.println(1);
            return;
        }
        long r = m;
        if (r > n - r) r = n - r;
        long num = 1;
        for (long i = 0; i < r; i++) {
            num = num * ((n - i) % MOD) % MOD;
        }
        long den = 1;
        for (long i = 1; i <= r; i++) {
            den = den * (i % MOD) % MOD;
        }
        long inv = modPow(den, MOD - 2);
        System.out.println(num * inv % MOD);
    }
    static long modPow(long a, long e) {
        long res = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }
}