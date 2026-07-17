# 1275. Validate Binary Tree Nodes

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/validate-binary-tree-nodes/ |

## 문제

You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.

 
Example 1:

Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
Output: true

Example 2:

Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
Output: false

Example 3:

Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
Output: false

 
Constraints:

	n == leftChild.length == rightChild.length
	1 <= n <= 104
	-1 <= leftChild[i], rightChild[i] <= n - 1

## 풀이

```java
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        for (int i = 0; i < n; i++) {
            int[] children = {leftChild[i], rightChild[i]};
            for (int child : children) {
                if (child == -1) continue;
                if (parent[child] != -1) return false;
                parent[child] = i;
            }
        }
        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                if (root != -1) return false;
                root = i;
            }
        }
        
        if (root == -1) return false;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        visited[root] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int[] children = {leftChild[node], rightChild[node]};
            for (int child : children) {
                if (child == -1) continue;
                if (visited[child]) return false;
                visited[child] = true;
                queue.offer(child);
                count++;
            }
        }
        
        return count == n;
    }
}
```
