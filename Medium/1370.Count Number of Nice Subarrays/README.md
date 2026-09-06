# 1370. Count Number of Nice Subarrays

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/count-number-of-nice-subarrays/ |

## 문제

Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 
Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.

Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16

 
Constraints:

	1 <= nums.length <= 50000
	1 <= nums[i] <= 10^5
	1 <= k <= nums.length

## 풀이

```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int oddCount = 0;
        int result = 0;
        for (int num : nums) {
            if ((num & 1) == 1) {
                oddCount++;
            }
            if (oddCount >= k) {
                result += count[oddCount - k];
            }
            count[oddCount]++;
        }
        return result;
    }
}
```
