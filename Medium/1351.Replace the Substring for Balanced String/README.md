# 1351. Replace the Substring for Balanced String

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/replace-the-substring-for-balanced-string/ |

## 문제

You are given a string s of length n containing only four kinds of characters: &#39;Q&#39;, &#39;W&#39;, &#39;E&#39;, and &#39;R&#39;.

A string is said to be balanced if each of its characters appears n / 4 times where n is the length of the string.

Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced. If s is already balanced, return 0.

 
Example 1:

Input: s = &quot;QWER&quot;
Output: 0
Explanation: s is already balanced.

Example 2:

Input: s = &quot;QQWE&quot;
Output: 1
Explanation: We need to replace a &#39;Q&#39; to &#39;R&#39;, so that &quot;RQWE&quot; (or &quot;QRWE&quot;) is balanced.

Example 3:

Input: s = &quot;QQQW&quot;
Output: 2
Explanation: We can replace the first &quot;QQ&quot; to &quot;ER&quot;. 

 
Constraints:

	n == s.length
	4 <= n <= 105
	n is a multiple of 4.
	s contains only &#39;Q&#39;, &#39;W&#39;, &#39;E&#39;, and &#39;R&#39;.

## 풀이

```java
class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;
        
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        if (count['Q'] == target && count['W'] == target && 
            count['E'] == target && count['R'] == target) {
            return 0;
        }
        
        int result = n;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            count[s.charAt(right)]--;
            
            while (left <= right && 
                   count['Q'] <= target && count['W'] <= target && 
                   count['E'] <= target && count['R'] <= target) {
                result = Math.min(result, right - left + 1);
                count[s.charAt(left)]++;
                left++;
            }
        }
        
        return result;
    }
}
```
