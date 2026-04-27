# 481. Magical String

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/magical-string/ |

## 문제

A magical string s consists of only &#39;1&#39; and &#39;2&#39; and obeys the following rule:

	Concatenating the sequence of lengths of its consecutive groups of identical characters &#39;1&#39; and &#39;2&#39; generates the string s itself.

The first few elements of s is s = &quot;1221121221221121122&hellip;&hellip;&quot;. If we group the consecutive 1&#39;s and 2&#39;s in s, it will be &quot;1 22 11 2 1 22 1 22 11 2 11 22 ......&quot; and counting the occurrences of 1&#39;s or 2&#39;s in each group yields the sequence &quot;1 2 2 1 1 2 1 2 2 1 2 2 ......&quot;.

You can see that concatenating the occurrence sequence gives us s itself.

Given an integer n, return the number of 1&#39;s in the first n number in the magical string s.

 
Example 1:

Input: n = 6
Output: 3
Explanation: The first 6 elements of magical string s is &quot;122112&quot; and it contains three 1&#39;s, so return 3.

Example 2:

Input: n = 1
Output: 1

 
Constraints:

	1 <= n <= 105

## 풀이

```java
class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] s = new int[n + 1];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int head = 2;
        int tail = 3;
        int num = 1;
        int count = 1;

        while (tail < n) {
            int repeat = s[head++];
            for (int i = 0; i < repeat && tail < n; i++) {
                s[tail++] = num;
            }
            num = num == 1 ? 2 : 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 1) result++;
        }
        return result;
    }
}
```
