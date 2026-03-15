import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1000000007L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        if (m == 0) {
            System.out.println(1);
            return;
        }
        long N = n;
        long ans = 1;
        for (long p = 2; p * p <= N; p += (p==2?1:2)) {
            if (N % p == 0) {
                long cnt = 0;
                while (N % p == 0) {
                    N /= p;
                    cnt++;
                }
                long exp = cnt * m;
                long numerator = modPow(p, exp + 1) - 1;
                if (numerator < 0) numerator += MOD;
                long denomInv = modInverse(p - 1);
                long term = numerator * denomInv % MOD;
                ans = ans * term % MOD;
            }
            if (p == 2) p = 2;
        }
        if (N > 1) {
            long p = N;
            long cnt = 1;
            long exp = cnt * m;
            long numerator = modPow(p, exp + 1) - 1;
            if (numerator < 0) numerator += MOD;
            long denomInv = modInverse(p - 1);
            long term = numerator * denomInv % MOD;
            ans = ans * term % MOD;
        }
        System.out.println(ans % MOD);
    }
    static long modPow(long a, long e) {
        long res = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return res;
    }
    static long modInverse(long a) {
        return modPow(a, MOD - 2);
    }
}