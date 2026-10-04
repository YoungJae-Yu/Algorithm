# 1273. Compare Strings by Frequency of the Smallest Character

https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

Let the function f(s) be the frequency of the lexicographically smallest character in a non-empty string s. For example, if s = &quot;dcce&quot; then f(s) = 2 because the lexicographically smallest character is &#39;c&#39;, which has a frequency of 2.

You are given an array of strings words and another array of query strings queries. For each query queries[i], count the number of words in words such that f(queries[i]) < f(W) for each W in words.

Return an integer array answer, where each answer[i] is the answer to the ith query.

 
Example 1:

Input: queries = [&quot;cbd&quot;], words = [&quot;zaaaz&quot;]
Output: [1]
Explanation: On the first query we have f(&quot;cbd&quot;) = 1, f(&quot;zaaaz&quot;) = 3 so f(&quot;cbd&quot;) < f(&quot;zaaaz&quot;).

Example 2:

Input: queries = [&quot;bbb&quot;,&quot;cc&quot;], words = [&quot;a&quot;,&quot;aa&quot;,&quot;aaa&quot;,&quot;aaaa&quot;]
Output: [1,2]
Explanation: On the first query only f(&quot;bbb&quot;) < f(&quot;aaaa&quot;). On the second query both f(&quot;aaa&quot;) and f(&quot;aaaa&quot;) are both > f(&quot;cc&quot;).

 
Constraints:

	1 <= queries.length <= 2000
	1 <= words.length <= 2000
	1 <= queries[i].length, words[i].length <= 10
	queries[i][j], words[i][j] consist of lowercase English letters.

```java
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = words.length;
        int[] wf = new int[n];
        for (int i = 0; i < n; i++) wf[i] = f(words[i]);
        java.util.Arrays.sort(wf);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int qf = f(queries[i]);
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (wf[mid] <= qf) lo = mid + 1;
                else hi = mid;
            }
            ans[i] = n - lo;
        }
        return ans;
    }

    private int f(String s) {
        char min = 'z' + 1;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c < min) {
                min = c;
                count = 1;
            } else if (c == min) {
                count++;
            }
        }
        return count;
    }
}
```
