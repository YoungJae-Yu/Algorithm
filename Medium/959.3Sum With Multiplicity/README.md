# 959. 3Sum With Multiplicity

https://leetcode.com/problems/3sum-with-multiplicity/

Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 109 + 7.

 
Example 1:

Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.

Example 2:

Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation: 
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.

Example 3:

Input: arr = [2,1,3], target = 6
Output: 1
Explanation: (1, 2, 3) occured one time in the array so we return 1.

 
Constraints:

	3 <= arr.length <= 3000
	0 <= arr[i] <= 100
	0 <= target <= 300

```java
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
```
