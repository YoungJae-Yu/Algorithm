# 827. Expressive Words

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/expressive-words/ |

## 문제

Sometimes people repeat letters to represent extra feeling. For example:

	&quot;hello&quot; -> &quot;heeellooo&quot;
	&quot;hi&quot; -> &quot;hiiii&quot;

In these strings like &quot;heeellooo&quot;, we have groups of adjacent letters that are all the same: &quot;h&quot;, &quot;eee&quot;, &quot;ll&quot;, &quot;ooo&quot;.

You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal to s by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is three or more.

	For example, starting with &quot;hello&quot;, we could do an extension on the group &quot;o&quot; to get &quot;hellooo&quot;, but we cannot get &quot;helloo&quot; since the group &quot;oo&quot; has a size less than three. Also, we could do another extension like &quot;ll&quot; -> &quot;lllll&quot; to get &quot;helllllooo&quot;. If s = &quot;helllllooo&quot;, then the query word &quot;hello&quot; would be stretchy because of these two extension operations: query = &quot;hello&quot; -> &quot;hellooo&quot; -> &quot;helllllooo&quot; = s.

Return the number of query strings that are stretchy.

 
Example 1:

Input: s = &quot;heeellooo&quot;, words = [&quot;hello&quot;, &quot;hi&quot;, &quot;helo&quot;]
Output: 1
Explanation: 
We can extend &quot;e&quot; and &quot;o&quot; in the word &quot;hello&quot; to get &quot;heeellooo&quot;.
We can&#39;t extend &quot;helo&quot; to get &quot;heeellooo&quot; because the group &quot;ll&quot; is not size 3 or more.

Example 2:

Input: s = &quot;zzzzzyyyyy&quot;, words = [&quot;zzyy&quot;,&quot;zy&quot;,&quot;zyy&quot;]
Output: 3

 
Constraints:

	1 <= s.length, words.length <= 100
	1 <= words[i].length <= 100
	s and words[i] consist of lowercase letters.

## 풀이

```java
class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStretchy(s, word)) count++;
        }
        return count;
    }

    private boolean isStretchy(String s, String word) {
        int i = 0, j = 0;
        int sLen = s.length(), wLen = word.length();

        while (i < sLen && j < wLen) {
            if (s.charAt(i) != word.charAt(j)) return false;

            int sCount = 1, wCount = 1;
            while (i + sCount < sLen && s.charAt(i + sCount) == s.charAt(i)) sCount++;
            while (j + wCount < wLen && word.charAt(j + wCount) == word.charAt(j)) wCount++;

            if (sCount < wCount) return false;
            if (sCount != wCount && sCount < 3) return false;

            i += sCount;
            j += wCount;
        }

        return i == sLen && j == wLen;
    }
}
```
