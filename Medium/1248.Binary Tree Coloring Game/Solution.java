/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int leftCount, rightCount, parentCount;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = find(root, x);
        leftCount = count(xNode.left);
        rightCount = count(xNode.right);
        parentCount = n - leftCount - rightCount - 1;

        int max = Math.max(parentCount, Math.max(leftCount, rightCount));
        return max > n - max;
    }

    private TreeNode find(TreeNode node, int x) {
        if (node == null) return null;
        if (node.val == x) return node;
        TreeNode left = find(node.left, x);
        if (left != null) return left;
        return find(node.right, x);
    }

    private int count(TreeNode node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}