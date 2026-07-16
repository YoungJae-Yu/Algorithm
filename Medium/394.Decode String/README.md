# 394. Decode String

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/decode-string/ |

## 문제

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 
Example 1:

Input: s = &quot;3[a]2[bc]&quot;
Output: &quot;aaabcbc&quot;

Example 2:

Input: s = &quot;3[a2[c]]&quot;
Output: &quot;accaccacc&quot;

Example 3:

Input: s = &quot;2[abc]3[cd]ef&quot;
Output: &quot;abcabccdcdcdef&quot;

 
Constraints:

	1 <= s.length <= 30
	s consists of lowercase English letters, digits, and square brackets &#39;[]&#39;.
	s is guaranteed to be a valid input.
	All the integers in s are in the range [1, 300].

## 풀이

```java
class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                decoded.append(current.toString().repeat(repeat));
                current = decoded;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}
```
