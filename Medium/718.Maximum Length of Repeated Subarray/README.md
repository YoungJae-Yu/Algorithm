# 718. Maximum Length of Repeated Subarray

https://leetcode.com/problems/maximum-length-of-repeated-subarray/

Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

 
Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].

Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
Explanation: The repeated subarray with maximum length is [0,0,0,0,0].

 
Constraints:

	1 <= nums1.length, nums2.length <= 1000
	0 <= nums1[i], nums2[i] <= 100

```java
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] dp = new int[m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = prev + 1;
                    if (dp[j] > max) max = dp[j];
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return max;
    }
}
```
