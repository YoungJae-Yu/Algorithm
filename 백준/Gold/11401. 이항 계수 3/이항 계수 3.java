import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long[] factorial = new long[N + 1];
        factorial[0] = 1;

        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        long numerator = factorial[N];
        long denominator = factorial[K] * factorial[N - K] % MOD;

        long result = numerator * modularExponentiation(denominator, MOD - 2, MOD) % MOD;
        System.out.println(result);
    }

    public static long modularExponentiation(long base, long exponent, long mod) {
        if (exponent == 0) {
            return 1;
        }
        
        long half = modularExponentiation(base, exponent / 2, mod);
        long result = (half * half) % mod;
        
        if (exponent % 2 != 0) {
            result = (result * base) % mod;
        }
        
        return result;
    }
}