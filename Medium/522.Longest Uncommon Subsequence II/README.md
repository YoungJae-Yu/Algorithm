# 522. Longest Uncommon Subsequence II

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/longest-uncommon-subsequence-ii/ |

## 문제

Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

	For example, &quot;abc&quot; is a subsequence of &quot;aebdc&quot; because you can delete the underlined characters in &quot;aebdc&quot; to get &quot;abc&quot;. Other subsequences of &quot;aebdc&quot; include &quot;aebdc&quot;, &quot;aeb&quot;, and &quot;&quot; (empty string).

 
Example 1:
Input: strs = ["aba","cdc","eae"]
Output: 3
Example 2:
Input: strs = ["aaa","aaa","aa"]
Output: -1

 
Constraints:

	2 <= strs.length <= 50
	1 <= strs[i].length <= 10
	strs[i] consists of lowercase English letters.

## 풀이

```java
class Solution {
    public int findLUSlength(String[] strs) {
        int result = -1;
        
        for (int i = 0; i < strs.length; i++) {
            boolean isUncommon = true;
            
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }
            
            if (isUncommon) {
                result = Math.max(result, strs[i].length());
            }
        }
        
        return result;
    }
    
    private boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == s.length();
    }
}
```
