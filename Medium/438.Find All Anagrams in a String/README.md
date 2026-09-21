# 438. Find All Anagrams in a String

https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given two strings s and p, return an array of all the start indices of p&#39;s anagrams in s. You may return the answer in any order.

 
Example 1:

Input: s = &quot;cbaebabacd&quot;, p = &quot;abc&quot;
Output: [0,6]
Explanation:
The substring with start index = 0 is &quot;cba&quot;, which is an anagram of &quot;abc&quot;.
The substring with start index = 6 is &quot;bac&quot;, which is an anagram of &quot;abc&quot;.

Example 2:

Input: s = &quot;abab&quot;, p = &quot;ab&quot;
Output: [0,1,2]
Explanation:
The substring with start index = 0 is &quot;ab&quot;, which is an anagram of &quot;ab&quot;.
The substring with start index = 1 is &quot;ba&quot;, which is an anagram of &quot;ab&quot;.
The substring with start index = 2 is &quot;ab&quot;, which is an anagram of &quot;ab&quot;.

 
Constraints:

	1 <= s.length, p.length <= 3 * 104
	s and p consist of lowercase English letters.

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (m > n) return result;
        int[] pCount = new int[26], sCount = new int[26];
        for (int i = 0; i < m; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCount, sCount)) result.add(0);
        for (int i = m; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - m) - 'a']--;
            if (Arrays.equals(pCount, sCount)) result.add(i - m + 1);
        }
        return result;
    }
}
```
