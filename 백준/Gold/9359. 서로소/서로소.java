import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());
            List<Long> primes = factorDistinctPrimes(N);
            long ans = countCoprimeUpTo(B, primes) - countCoprimeUpTo(A - 1, primes);
            sb.append("Case #").append(tc).append(": ").append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }

    static List<Long> factorDistinctPrimes(long n) {
        List<Long> res = new ArrayList<>();
        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                res.add(p);
                while (n % p == 0) n /= p;
            }
        }
        if (n > 1) res.add(n);
        return res;
    }

    static long countCoprimeUpTo(long x, List<Long> primes) {
        if (x <= 0) return 0;
        int k = primes.size();
        if (k == 0) return x;
        long notCoprime = 0;
        int limit = 1 << k;
        for (int mask = 1; mask < limit; mask++) {
            long prod = 1;
            int bits = Integer.bitCount(mask);
            boolean overflow = false;
            for (int i = 0; i < k; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (prod > Long.MAX_VALUE / primes.get(i)) { overflow = true; break; }
                    prod *= primes.get(i);
                }
            }
            if (overflow) continue;
            if ((bits & 1) == 1) notCoprime += x / prod;
            else notCoprime -= x / prod;
        }
        return x - notCoprime;
    }
}