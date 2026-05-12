# 1007. Numbers With Same Consecutive Differences

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/numbers-with-same-consecutive-differences/ |

## 문제

Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.

Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.

 
Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Example 2:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

 
Constraints:

	2 <= n <= 9
	0 <= k <= 9

## 풀이

```java
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> current = new ArrayList<>();
        for (int d = 1; d <= 9; d++) {
            current.add(d);
        }
        
        for (int i = 1; i < n; i++) {
            List<Integer> next = new ArrayList<>();
            for (int num : current) {
                int lastDigit = num % 10;
                if (lastDigit + k <= 9) {
                    next.add(num * 10 + lastDigit + k);
                }
                if (k != 0 && lastDigit - k >= 0) {
                    next.add(num * 10 + lastDigit - k);
                }
            }
            current = next;
        }
        
        return current.stream().mapToInt(Integer::intValue).toArray();
    }
}
```
