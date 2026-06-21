# 397. Integer Replacement

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/integer-replacement/ |

## 문제

Given a positive integer n, you can apply one of the following operations:

	If n is even, replace n with n / 2.
	If n is odd, replace n with either n + 1 or n - 1.

Return the minimum number of operations needed for n to become 1.

 
Example 1:

Input: n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1

Example 2:

Input: n = 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1

Example 3:

Input: n = 4
Output: 2

 
Constraints:

	1 <= n <= 231 - 1

## 풀이

```java
class Solution {
    public int integerReplacement(int n) {
        long num = n;
        int count = 0;
        
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num == 3 || ((num >> 1) & 1) == 0) {
                num -= 1;
            } else {
                num += 1;
            }
            count++;
        }
        
        return count;
    }
}
```
