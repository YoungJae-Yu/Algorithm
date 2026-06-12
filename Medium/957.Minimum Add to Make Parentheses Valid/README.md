# 957. Minimum Add to Make Parentheses Valid

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/ |

## 문제

A parentheses string is valid if and only if:

	It is the empty string,
	It can be written as AB (A concatenated with B), where A and B are valid strings, or
	It can be written as (A), where A is a valid string.

You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

	For example, if s = &quot;()))&quot;, you can insert an opening parenthesis to be &quot;(()))&quot; or a closing parenthesis to be &quot;())))&quot;.

Return the minimum number of moves required to make s valid.

 
Example 1:

Input: s = &quot;())&quot;
Output: 1

Example 2:

Input: s = &quot;(((&quot;
Output: 3

 
Constraints:

	1 <= s.length <= 1000
	s[i] is either &#39;(&#39; or &#39;)&#39;.

## 풀이

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        
        return open + close;
    }
}
```
