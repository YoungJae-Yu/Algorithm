# 357. Count Numbers with Unique Digits

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/count-numbers-with-unique-digits/ |

## 문제

Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.

 
Example 1:

Input: n = 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 &le; x < 100, excluding 11,22,33,44,55,66,77,88,99

Example 2:

Input: n = 0
Output: 1

 
Constraints:

	0 <= n <= 8

## 풀이

```java
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        int result = 10;
        int availableDigits = 9;
        int currentCount = 9;
        
        for (int i = 2; i <= n; i++) {
            currentCount *= availableDigits;
            result += currentCount;
            availableDigits--;
        }
        
        return result;
    }
}
```
