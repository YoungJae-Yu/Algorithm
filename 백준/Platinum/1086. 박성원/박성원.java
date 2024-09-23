import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, K;
    static String[] nums;
    static int[] modK;
    static int[] len;
    static int[] pow10modK;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new String[N];
        for(int i = 0; i < N; i++) {
            nums[i] = br.readLine();
        }
        K = Integer.parseInt(br.readLine());

        modK = new int[N];
        len = new int[N];
        pow10modK = new int[N];

        for(int i = 0; i < N; i++) {
            len[i] = nums[i].length();
            modK[i] = mod(nums[i], K);
            pow10modK[i] = modPow(10, len[i], K);
        }

        int size = 1 << N;
        dp = new long[size][K];
        dp[0][0] = 1L;

        for(int mask = 0; mask < size; mask++) {
            for(int rem = 0; rem < K; rem++) {
                if(dp[mask][rem] == 0) continue;
                for(int i = 0; i < N; i++) {
                    if((mask & (1 << i)) == 0) {
                        int newMask = mask | (1 << i);
                        int newRem = (rem * pow10modK[i] + modK[i]) % K;
                        dp[newMask][newRem] += dp[mask][rem];
                    }
                }
            }
        }

        long numerator = dp[size - 1][0];
        BigInteger numeratorBI = BigInteger.valueOf(numerator);
        BigInteger denominator = factorial(N);

        BigInteger gcd = numeratorBI.gcd(denominator);
        numeratorBI = numeratorBI.divide(gcd);
        denominator = denominator.divide(gcd);

        System.out.println(numeratorBI + "/" + denominator);
    }

    static int mod(String s, int mod) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            result = (result * 10 + (s.charAt(i) - '0')) % mod;
        }
        return result;
    }

    static int modPow(int base, int exp, int mod) {
        int result = 1;
        base %= mod;
        while(exp > 0) {
            if((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for(int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}