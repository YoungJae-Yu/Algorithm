# 768. Partition Labels

https://leetcode.com/problems/partition-labels/

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string &quot;ababcc&quot; can be partitioned into [&quot;abab&quot;, &quot;cc&quot;], but partitions such as [&quot;aba&quot;, &quot;bcc&quot;] or [&quot;ab&quot;, &quot;ab&quot;, &quot;cc&quot;] are invalid.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 
Example 1:

Input: s = &quot;ababcbacadefegdehijhklij&quot;
Output: [9,7,8]
Explanation:
The partition is &quot;ababcbaca&quot;, &quot;defegde&quot;, &quot;hijhklij&quot;.
This is a partition so that each letter appears in at most one part.
A partition like &quot;ababcbacadefegde&quot;, &quot;hijhklij&quot; is incorrect, because it splits s into less parts.

Example 2:

Input: s = &quot;eccbbbbdec&quot;
Output: [10]

 
Constraints:

	1 <= s.length <= 500
	s consists of lowercase English letters.

```java
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
```
