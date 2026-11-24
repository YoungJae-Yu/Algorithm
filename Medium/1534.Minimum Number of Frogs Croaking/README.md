# 1534. Minimum Number of Frogs Croaking

https://leetcode.com/problems/minimum-number-of-frogs-croaking/

You are given the string croakOfFrogs, which represents a combination of the string &quot;croak&quot; from different frogs, that is, multiple frogs can croak at the same time, so multiple &quot;croak&quot; are mixed.

Return the minimum number of different frogs to finish all the croaks in the given string.

A valid &quot;croak&quot; means a frog is printing five letters &#39;c&#39;, &#39;r&#39;, &#39;o&#39;, &#39;a&#39;, and &#39;k&#39; sequentially. The frogs have to print all five letters to finish a croak. If the given string is not a combination of a valid &quot;croak&quot; return -1.

 
Example 1:

Input: croakOfFrogs = &quot;croakcroak&quot;
Output: 1 
Explanation: One frog yelling &quot;croak&quot; twice.

Example 2:

Input: croakOfFrogs = &quot;crcoakroak&quot;
Output: 2 
Explanation: The minimum number of frogs is two. 
The first frog could yell &quot;crcoakroak&quot;.
The second frog could yell later &quot;crcoakroak&quot;.

Example 3:

Input: croakOfFrogs = &quot;croakcrook&quot;
Output: -1
Explanation: The given string is an invalid combination of &quot;croak&quot; from different frogs.

 
Constraints:

	1 <= croakOfFrogs.length <= 105
	croakOfFrogs is either &#39;c&#39;, &#39;r&#39;, &#39;o&#39;, &#39;a&#39;, or &#39;k&#39;.

```java
class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] cnt = new int[5];
        int active = 0, max = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            int idx = "croak".indexOf(ch);
            if (idx < 0) return -1;
            if (idx == 0) {
                cnt[0]++;
                active++;
                if (active > max) max = active;
            } else {
                if (cnt[idx - 1] == 0) return -1;
                cnt[idx - 1]--;
                if (idx == 4) active--;
                else cnt[idx]++;
            }
        }
        return active == 0 ? max : -1;
    }
}
```
