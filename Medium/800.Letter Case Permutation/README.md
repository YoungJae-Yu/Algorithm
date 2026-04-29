# 800. Letter Case Permutation

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/letter-case-permutation/ |

## 문제

Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 
Example 1:

Input: s = &quot;a1b2&quot;
Output: [&quot;a1b2&quot;,&quot;a1B2&quot;,&quot;A1b2&quot;,&quot;A1B2&quot;]

Example 2:

Input: s = &quot;3z4&quot;
Output: [&quot;3z4&quot;,&quot;3Z4&quot;]

 
Constraints:

	1 <= s.length <= 12
	s consists of lowercase English letters, uppercase English letters, and digits.

## 풀이

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    private void backtrack(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        backtrack(chars, index + 1, result);

        if (Character.isLetter(chars[index])) {
            chars[index] ^= 32;
            backtrack(chars, index + 1, result);
            chars[index] ^= 32;
        }
    }
}
```
