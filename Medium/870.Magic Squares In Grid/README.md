# 870. Magic Squares In Grid

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/magic-squares-in-grid/ |

## 문제

A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?

Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.

 
Example 1:

Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
Output: 1
Explanation: 
The following subgrid is a 3 x 3 magic square:

while this one is not:

In total, there is only one magic square inside the given grid.

Example 2:

Input: grid = [[8]]
Output: 0

 
Constraints:

	row == grid.length
	col == grid[i].length
	1 <= row, col <= 10
	0 <= grid[i][j] <= 15

## 풀이

```java
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for (int r = 0; r <= rows - 3; r++) {
            for (int c = 0; c <= cols - 3; c++) {
                if (isMagic(grid, r, c)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isMagic(int[][] grid, int r, int c) {
        boolean[] seen = new boolean[10];
        
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }
        
        int target = 15;
        
        for (int i = r; i < r + 3; i++) {
            if (grid[i][c] + grid[i][c+1] + grid[i][c+2] != target) return false;
        }
        
        for (int j = c; j < c + 3; j++) {
            if (grid[r][j] + grid[r+1][j] + grid[r+2][j] != target) return false;
        }
        
        if (grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != target) return false;
        if (grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != target) return false;
        
        return true;
    }
}
```
