# 3. Longest Substring Without Repeating Characters

https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string s, find the length of the longest substring without duplicate characters.

 
Example 1:

Input: s = &quot;abcabcbb&quot;
Output: 3
Explanation: The answer is &quot;abc&quot;, with the length of 3. Note that &quot;bca&quot; and &quot;cab&quot; are also correct answers.

Example 2:

Input: s = &quot;bbbbb&quot;
Output: 1
Explanation: The answer is &quot;b&quot;, with the length of 1.

Example 3:

Input: s = &quot;pwwkew&quot;
Output: 3
Explanation: The answer is &quot;wke&quot;, with the length of 3.
Notice that the answer must be a substring, &quot;pwke&quot; is a subsequence and not a substring.

 
Constraints:

	0 <= s.length <= 105
	s consists of English letters, digits, symbols and spaces.

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int best = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) & 127;
            if (last[c] > start) start = last[c];
            last[c] = i + 1;
            best = Math.max(best, i + 1 - start);
        }
        return best;
    }
}
```
