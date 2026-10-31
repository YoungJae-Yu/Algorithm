# 1171. Shortest Path in Binary Matrix

https://leetcode.com/problems/shortest-path-in-binary-matrix/

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

	All the visited cells of the path are 0.
	All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.

 
Example 1:

Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1

 
Constraints:

	n == grid.length
	n == grid[i].length
	1 <= n <= 100
	grid[i][j] is 0 or 1

```java
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;
        int[] queue = new int[n * n];
        int head = 0, tail = 0;
        queue[tail++] = 0;
        grid[0][0] = 1;
        int dist = 1;
        while (head < tail) {
            int size = tail - head;
            dist++;
            for (int s = 0; s < size; s++) {
                int cur = queue[head++];
                int r = cur / n, c = cur % n;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nr = r + dr, nc = c + dc;
                        if (nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 1) continue;
                        if (nr == n - 1 && nc == n - 1) return dist;
                        grid[nr][nc] = 1;
                        queue[tail++] = nr * n + nc;
                    }
                }
            }
        }
        return -1;
    }
}
```
