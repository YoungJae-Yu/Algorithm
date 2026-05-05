# 647. Palindromic Substrings

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/palindromic-substrings/ |

## 문제

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 
Example 1:

Input: s = &quot;abc&quot;
Output: 3
Explanation: Three palindromic strings: &quot;a&quot;, &quot;b&quot;, &quot;c&quot;.

Example 2:

Input: s = &quot;aaa&quot;
Output: 6
Explanation: Six palindromic strings: &quot;a&quot;, &quot;a&quot;, &quot;a&quot;, &quot;aa&quot;, &quot;aa&quot;, &quot;aaa&quot;.

 
Constraints:

	1 <= s.length <= 1000
	s consists of lowercase English letters.

## 풀이

```java
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        
        return count;
    }
}
```
