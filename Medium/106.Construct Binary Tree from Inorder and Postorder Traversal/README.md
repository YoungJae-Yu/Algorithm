# 106. Construct Binary Tree from Inorder and Postorder Traversal

https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 
Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]

 
Constraints:

	1 <= inorder.length <= 3000
	postorder.length == inorder.length
	-3000 <= inorder[i], postorder[i] <= 3000
	inorder and postorder consist of unique values.
	Each value of postorder also appears in inorder.
	inorder is guaranteed to be the inorder traversal of the tree.
	postorder is guaranteed to be the postorder traversal of the tree.

```java
class Solution {
    private int[] post;
    private int[] inorder;
    private int[] idx;
    private int pi;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.post = postorder;
        idx = new int[6001];
        for (int i = 0; i < inorder.length; i++) idx[inorder[i] + 3000] = i;
        pi = postorder.length - 1;
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int lo, int hi) {
        if (lo > hi) return null;
        int v = post[pi--];
        TreeNode node = new TreeNode(v);
        int m = idx[v + 3000];
        node.right = build(m + 1, hi);
        node.left = build(lo, m - 1);
        return node;
    }
}
```
