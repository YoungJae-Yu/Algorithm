# 967. Minimum Falling Path Sum

https://leetcode.com/problems/minimum-falling-path-sum/

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 
Example 1:

Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.

Example 2:

Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.

 
Constraints:

	n == matrix.length == matrix[i].length
	1 <= n <= 100
	-100 <= matrix[i][j] <= 100

```java
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = matrix[0].clone();
        for (int i = 1; i < n; i++) {
            int[] next = new int[n];
            for (int j = 0; j < n; j++) {
                int best = dp[j];
                if (j > 0) best = Math.min(best, dp[j - 1]);
                if (j < n - 1) best = Math.min(best, dp[j + 1]);
                next[j] = matrix[i][j] + best;
            }
            dp = next;
        }
        int result = dp[0];
        for (int v : dp) result = Math.min(result, v);
        return result;
    }
}
```
