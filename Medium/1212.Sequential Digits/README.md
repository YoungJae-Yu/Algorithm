# 1212. Sequential Digits

https://leetcode.com/problems/sequential-digits/

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 
Example 1:
Input: low = 100, high = 300
Output: [123,234]
Example 2:
Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

 
Constraints:

	10 <= low <= high <= 10^9

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String s = "123456789";
        for (int len = 2; len <= 9; len++) {
            for (int start = 0; start + len <= 9; start++) {
                int num = Integer.parseInt(s.substring(start, start + len));
                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
```
