# 300. Longest Increasing Subsequence

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/longest-increasing-subsequence/ |

## 문제

Given an integer array nums, return the length of the longest strictly increasing subsequence.

 
Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

 
Constraints:

	1 <= nums.length <= 2500
	-104 <= nums[i] <= 104

 
Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

## 풀이

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        
        for (int num : nums) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (left == size) {
                size++;
            }
        }
        
        return size;
    }
}
```
