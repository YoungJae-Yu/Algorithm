# 152. Maximum Product Subarray

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/maximum-product-subarray/ |

## 문제

Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.

 
Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 
Constraints:

	1 <= nums.length <= 2 * 104
	-10 <= nums[i] <= 10
	The product of any subarray of nums is guaranteed to fit in a 32-bit integer.

## 풀이

```java
class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = maxEndingHere;
            
            maxEndingHere = Math.max(num, Math.max(num * maxEndingHere, num * minEndingHere));
            minEndingHere = Math.min(num, Math.min(num * tempMax, num * minEndingHere));
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
```
