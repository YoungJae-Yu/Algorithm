# 103. Binary Tree Zigzag Level Order Traversal

https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Given the root of a binary tree, return the zigzag level order traversal of its nodes&#39; values. (i.e., from left to right, then right to left for the next level and alternate between).

 
Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 
Constraints:

	The number of nodes in the tree is in the range [0, 2000].
	-100 <= Node.val <= 100

```java
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean rev = false;
        while (!q.isEmpty()) {
            int n = q.size();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                arr[rev ? n - 1 - i : i] = node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(Arrays.asList(arr));
            rev = !rev;
        }
        return res;
    }
}
```
