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
    private int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return max;
    }

    private void dfs(TreeNode node, int min, int max) {
        if (node == null) return;
        this.max = Math.max(this.max, Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }
}