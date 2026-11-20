# 769. Largest Plus Sign

https://leetcode.com/problems/largest-plus-sign/

You are given an integer n. You have an n x n binary grid grid with all values initially 1&#39;s except for some indices given in the array mines. The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.

Return the order of the largest axis-aligned plus sign of 1&#39;s contained in grid. If there is none, return 0.

An axis-aligned plus sign of 1&#39;s of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right, and made of 1&#39;s. Note that there could be 0&#39;s or 1&#39;s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1&#39;s.

 
Example 1:

Input: n = 5, mines = [[4,2]]
Output: 2
Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.

Example 2:

Input: n = 1, mines = [[0,0]]
Output: 0
Explanation: There is no plus sign, so return 0.

 
Constraints:

	1 <= n <= 500
	1 <= mines.length <= 5000
	0 <= xi, yi < n
	All the pairs (xi, yi) are unique.

```java
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        boolean[][] z = new boolean[n][n];
        for (int[] m : mines) z[m[0]][m[1]] = true;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                c = z[i][j] ? 0 : c + 1;
                d[i][j] = c;
            }
            c = 0;
            for (int j = n - 1; j >= 0; j--) {
                c = z[i][j] ? 0 : c + 1;
                d[i][j] = Math.min(d[i][j], c);
            }
        }
        int best = 0;
        for (int j = 0; j < n; j++) {
            int c = 0;
            for (int i = 0; i < n; i++) {
                c = z[i][j] ? 0 : c + 1;
                d[i][j] = Math.min(d[i][j], c);
            }
            c = 0;
            for (int i = n - 1; i >= 0; i--) {
                c = z[i][j] ? 0 : c + 1;
                d[i][j] = Math.min(d[i][j], c);
                best = Math.max(best, d[i][j]);
            }
        }
        return best;
    }
}
```
