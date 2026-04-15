# 516. Longest Palindromic Subsequence

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/longest-palindromic-subsequence/ |

## 문제

Given a string s, find the longest palindromic subsequence&#39;s length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 
Example 1:

Input: s = &quot;bbbab&quot;
Output: 4
Explanation: One possible longest palindromic subsequence is &quot;bbbb&quot;.

Example 2:

Input: s = &quot;cbbd&quot;
Output: 2
Explanation: One possible longest palindromic subsequence is &quot;bb&quot;.

 
Constraints:

	1 <= s.length <= 1000
	s consists only of lowercase English letters.

## 풀이

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] dpPrev = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = dpPrev[j - 1] + 2;
                } else {
                    dp[j] = Math.max(dpPrev[j], dp[j - 1]);
                }
            }
            int[] temp = dpPrev;
            dpPrev = dp;
            dp = temp;
        }
        
        return dpPrev[n - 1];
    }
}
```
