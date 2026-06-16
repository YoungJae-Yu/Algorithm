# 991. Array of Doubled Pairs

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/array-of-doubled-pairs/ |

## 문제

Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.

 
Example 1:

Input: arr = [3,1,3,6]
Output: false

Example 2:

Input: arr = [2,1,2,6]
Output: false

Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].

 
Constraints:

	2 <= arr.length <= 3 * 104
	arr.length is even.
	-105 <= arr[i] <= 105

## 풀이

```java
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int x : arr) {
            count.merge(x, 1, Integer::sum);
        }
        
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            
            int target = x < 0 ? x / 2 : x * 2;
            
            if (x < 0 && x % 2 != 0) return false;
            
            int need = count.get(x);
            int available = count.getOrDefault(target, 0);
            
            if (available < need) return false;
            
            count.put(target, available - need);
        }
        
        return true;
    }
}
```
