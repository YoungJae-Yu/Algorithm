# 1320. Remove All Adjacent Duplicates in String II

https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 
Example 1:

Input: s = &quot;abcd&quot;, k = 2
Output: &quot;abcd&quot;
Explanation: There&#39;s nothing to delete.

Example 2:

Input: s = &quot;deeedbbcccbdaa&quot;, k = 3
Output: &quot;aa&quot;
Explanation: 
First delete &quot;eee&quot; and &quot;ccc&quot;, get &quot;ddbbbdaa&quot;
Then delete &quot;bbb&quot;, get &quot;dddaa&quot;
Finally delete &quot;ddd&quot;, get &quot;aa&quot;

Example 3:

Input: s = &quot;pbbcggttciiippooaais&quot;, k = 2
Output: &quot;ps&quot;

 
Constraints:

	1 <= s.length <= 105
	2 <= k <= 104
	s only contains lowercase English letters.

```java
class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        char[] chars = new char[n];
        int[] counts = new int[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            chars[top] = c;
            counts[top] = (top > 0 && chars[top - 1] == c) ? counts[top - 1] + 1 : 1;
            if (counts[top] == k) {
                top -= k - 1;
            } else {
                top++;
            }
        }
        return new String(chars, 0, top);
    }
}
```
