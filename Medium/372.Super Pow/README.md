# 372. Super Pow

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/super-pow/ |

## 문제

Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 
Example 1:

Input: a = 2, b = [3]
Output: 8

Example 2:

Input: a = 2, b = [1,0]
Output: 1024

Example 3:

Input: a = 1, b = [4,3,3,8,5,2]
Output: 1

 
Constraints:

	1 <= a <= 231 - 1
	1 <= b.length <= 2000
	0 <= b[i] <= 9
	b does not contain leading zeros.

## 풀이

```java
class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        int result = 1;
        for (int digit : b) {
            result = powMod(result, 10) * powMod(a, digit) % MOD;
        }
        return result;
    }

    private int powMod(int base, int exp) {
        base %= MOD;
        int result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
```
