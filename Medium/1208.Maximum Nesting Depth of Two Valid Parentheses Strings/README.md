# 1208. Maximum Nesting Depth of Two Valid Parentheses Strings

https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

A string is a valid parentheses string (denoted VPS) if and only if it consists of &quot;(&quot; and &quot;)&quot; characters only, and:

	It is the empty string, or
	It can be written as AB (A concatenated with B), where A and B are VPS&#39;s, or
	It can be written as (A), where A is a VPS.

We can similarly define the nesting depth depth(S) of any VPS S as follows:

	depth(&quot;&quot;) = 0
	depth(A + B) = max(depth(A), depth(B)), where A and B are VPS&#39;s
	depth(&quot;(&quot; + A + &quot;)&quot;) = 1 + depth(A), where A is a VPS.

For example, &quot;&quot;, &quot;()()&quot;, and &quot;()(()())&quot; are VPS&#39;s (with nesting depths 0, 1, and 2), and &quot;)(&quot; and &quot;(()&quot; are not VPS&#39;s.

Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS&#39;s (and A.length + B.length = seq.length). The subsequences may not necessarily be contiguous.

For example, for the sequence 123456789, one possible split is:

	
	A = {1, 3, 5, 7, 9},
	
	
	B = {2, 4, 6, 8}.
	

This corresponds to the output [0, 1, 0, 1, 0, 1, 0, 1, 0]  where 0 indicates membership in A and 1 indicates membership in B.

Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.

Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  Note that even though multiple answers may exist, you may return any of them.

 
Example 1:

Input: seq = &quot;(()())&quot;
Output: [0,1,1,1,1,0]

Example 2:

Input: seq = &quot;()(())()&quot;
Output: [0,0,0,1,1,0,1,1]

 
Constraints:

	1 <= seq.size <= 10000

```java
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                depth++;
                res[i] = depth % 2;
            } else {
                res[i] = depth % 2;
                depth--;
            }
        }
        return res;
    }
}
```
