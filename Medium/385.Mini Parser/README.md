# 385. Mini Parser

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/mini-parser/ |

## 문제

Given a string s represents the serialization of a nested list, implement a parser to deserialize it and return the deserialized NestedInteger.

Each element is either an integer or a list whose elements may also be integers or other lists.

 
Example 1:

Input: s = &quot;324&quot;
Output: 324
Explanation: You should return a NestedInteger object which contains a single integer 324.

Example 2:

Input: s = &quot;[123,[456,[789]]]&quot;
Output: [123,[456,[789]]]
Explanation: Return a NestedInteger object containing a nested list with 2 elements:
1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789

 
Constraints:

	1 <= s.length <= 5 * 104
	s consists of digits, square brackets &quot;[]&quot;, negative sign &#39;-&#39;, and commas &#39;,&#39;.
	s is the serialization of valid NestedInteger.
	All the values in the input are in the range [-106, 106].

## 풀이

```java
class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }

        Deque<NestedInteger> stack = new ArrayDeque<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '[' -> {
                    stack.push(new NestedInteger());
                    start = i + 1;
                }
                case ']' -> {
                    if (i > start) {
                        stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(start, i))));
                    }
                    start = i + 1;
                    if (stack.size() > 1) {
                        NestedInteger top = stack.pop();
                        stack.peek().add(top);
                    }
                }
                case ',' -> {
                    if (i > start && s.charAt(start) != '[') {
                        stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(start, i))));
                    }
                    start = i + 1;
                }
            }
        }

        return stack.pop();
    }
}
```
