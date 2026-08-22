# 1243. Sum of Nodes with Even-Valued Grandparent

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/ |

## 문제

Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

A grandparent of a node is the parent of its parent if it exists.

 
Example 1:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

Example 2:

Input: root = [1]
Output: 0

 
Constraints:

	The number of nodes in the tree is in the range [1, 104].
	1 <= Node.val <= 100

## 풀이

```java
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }

    private int dfs(TreeNode node, TreeNode parent, TreeNode grandparent) {
        if (node == null) return 0;
        
        int sum = (grandparent != null && grandparent.val % 2 == 0) ? node.val : 0;
        sum += dfs(node.left, node, parent);
        sum += dfs(node.right, node, parent);
        
        return sum;
    }
}
```
