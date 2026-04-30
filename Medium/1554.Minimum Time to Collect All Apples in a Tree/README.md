# 1554. Minimum Time to Collect All Apples in a Tree

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/ |

## 문제

Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.

 
Example 1:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8 
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  

Example 2:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  

Example 3:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
Output: 0

 
Constraints:

	1 <= n <= 105
	edges.length == n - 1
	edges[i].length == 2
	0 <= ai < bi <= n - 1
	hasApple.length == n

## 풀이

```java
import java.util.*;

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(0, -1, graph, hasApple);
    }

    private int dfs(int node, int parent, List<List<Integer>> graph, List<Boolean> hasApple) {
        int totalTime = 0;
        for (int child : graph.get(node)) {
            if (child == parent) continue;
            int childTime = dfs(child, node, graph, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}
```
