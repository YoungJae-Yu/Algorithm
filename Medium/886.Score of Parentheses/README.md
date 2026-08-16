# 886. Score of Parentheses

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/score-of-parentheses/ |

## 문제

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

	&quot;()&quot; has score 1.
	AB has score A + B, where A and B are balanced parentheses strings.
	(A) has score 2 * A, where A is a balanced parentheses string.

 
Example 1:

Input: s = &quot;()&quot;
Output: 1

Example 2:

Input: s = &quot;(())&quot;
Output: 2

Example 3:

Input: s = &quot;()()&quot;
Output: 2

 
Constraints:

	2 <= s.length <= 50
	s consists of only &#39;(&#39; and &#39;)&#39;.
	s is a balanced parentheses string.

## 풀이

```java
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int top = stack.pop();
                int prev = stack.pop();
                stack.push(prev + Math.max(2 * top, 1));
            }
        }
        
        return stack.pop();
    }
}
```
