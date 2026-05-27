# 72. Edit Distance

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/edit-distance/ |

## 문제

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

	Insert a character
	Delete a character
	Replace a character

 
Example 1:

Input: word1 = &quot;horse&quot;, word2 = &quot;ros&quot;
Output: 3
Explanation: 
horse -> rorse (replace &#39;h&#39; with &#39;r&#39;)
rorse -> rose (remove &#39;r&#39;)
rose -> ros (remove &#39;e&#39;)

Example 2:

Input: word1 = &quot;intention&quot;, word2 = &quot;execution&quot;
Output: 5
Explanation: 
intention -> inention (remove &#39;t&#39;)
inention -> enention (replace &#39;i&#39; with &#39;e&#39;)
enention -> exention (replace &#39;n&#39; with &#39;x&#39;)
exention -> exection (replace &#39;n&#39; with &#39;c&#39;)
exection -> execution (insert &#39;u&#39;)

 
Constraints:

	0 <= word1.length, word2.length <= 500
	word1 and word2 consist of lowercase English letters.

## 풀이

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[n];
    }
}
```
