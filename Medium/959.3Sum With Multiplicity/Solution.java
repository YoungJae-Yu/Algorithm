class Solution {
    public int threeSumMulti(int[] arr, int target) {
        final int MOD = 1_000_000_007;
        long[] cnt = new long[101];
        for (int v : arr) cnt[v]++;
        long ans = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < j || k > 100) continue;
                if (i == j && j == k) {
                    ans += cnt[i] * (cnt[i] - 1) % MOD * (cnt[i] - 2) % MOD * inv6(MOD) % MOD;
                } else if (i == j) {
                    ans += cnt[i] * (cnt[i] - 1) % MOD * inv2(MOD) % MOD * cnt[k] % MOD;
                } else if (j == k) {
                    ans += cnt[i] * cnt[j] % MOD * (cnt[j] - 1) % MOD * inv2(MOD) % MOD;
                } else {
                    ans += cnt[i] * cnt[j] % MOD * cnt[k] % MOD;
                }
                ans %= MOD;
            }
        }
        return (int) ((ans % MOD + MOD) % MOD);
    }
    
    private long inv2(int mod) {
        return modpow(2, mod - 2, mod);
    }
    
    private long inv6(int mod) {
        return modpow(6, mod - 2, mod);
    }
    
    private long modpow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}