# 1529. Max Difference You Can Get From Changing an Integer

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/ |

## 문제

You are given an integer num. You will apply the following steps to num two separate times:

	Pick a digit x (0 <= x <= 9).
	Pick another digit y (0 <= y <= 9). Note y can be equal to x.
	Replace all the occurrences of x in the decimal representation of num by y.

Let a and b be the two results from applying the operation to num independently.

Return the max difference between a and b.

Note that neither a nor b may have any leading zeros, and must not be 0.

 
Example 1:

Input: num = 555
Output: 888
Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
The second time pick x = 5 and y = 1 and store the new integer in b.
We have now a = 999 and b = 111 and max difference = 888

Example 2:

Input: num = 9
Output: 8
Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
The second time pick x = 9 and y = 1 and store the new integer in b.
We have now a = 9 and b = 1 and max difference = 8

 
Constraints:

	1 <= num <= 108

## 풀이

```java
class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        
        String maxStr = s;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxStr = s.replace(c, '9');
                break;
            }
        }
        
        String minStr = s;
        char first = s.charAt(0);
        if (first != '1') {
            minStr = s.replace(first, '1');
        } else {
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') {
                    minStr = s.replace(c, '0');
                    break;
                }
            }
        }
        
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
```
