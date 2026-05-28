# 419. Battleships in a Board

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/battleships-in-a-board/ |

## 문제

Given an m x n matrix board where each cell is a battleship &#39;X&#39; or empty &#39;.&#39;, return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

 
Example 1:

Input: board = [[&quot;X&quot;,&quot;.&quot;,&quot;.&quot;,&quot;X&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;X&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;X&quot;]]
Output: 2

Example 2:

Input: board = [[&quot;.&quot;]]
Output: 0

 
Constraints:

	m == board.length
	n == board[i].length
	1 <= m, n <= 200
	board[i][j] is either &#39;.&#39; or &#39;X&#39;.

 
Follow up: Could you do it in one-pass, using only O(1) extra memory and without modifying the values board?

## 풀이

```java
class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X'
                    && (i == 0 || board[i-1][j] == '.')
                    && (j == 0 || board[i][j-1] == '.')) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
```
