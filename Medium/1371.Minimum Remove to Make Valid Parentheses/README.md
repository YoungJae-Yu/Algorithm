# 1371. Minimum Remove to Make Valid Parentheses

https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

Given a string s of &#39;(&#39; , &#39;)&#39; and lowercase English characters.

Your task is to remove the minimum number of parentheses ( &#39;(&#39; or &#39;)&#39;, in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

	It is the empty string, contains only lowercase characters, or
	It can be written as AB (A concatenated with B), where A and B are valid strings, or
	It can be written as (A), where A is a valid string.

 
Example 1:

Input: s = &quot;lee(t(c)o)de)&quot;
Output: &quot;lee(t(c)o)de&quot;
Explanation: &quot;lee(t(co)de)&quot; , &quot;lee(t(c)ode)&quot; would also be accepted.

Example 2:

Input: s = &quot;a)b(c)d&quot;
Output: &quot;ab(c)d&quot;

Example 3:

Input: s = &quot;))((&quot;
Output: &quot;&quot;
Explanation: An empty string is also valid.

 
Constraints:

	1 <= s.length <= 105
	s[i] is either &#39;(&#39; , &#39;)&#39;, or lowercase English letter.

```java
class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        boolean[] remove = new boolean[n];
        int[] stack = new int[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack[top++] = i;
            } else if (c == ')') {
                if (top > 0) {
                    top--;
                } else {
                    remove[i] = true;
                }
            }
        }
        while (top > 0) {
            remove[stack[--top]] = true;
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (!remove[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
```
