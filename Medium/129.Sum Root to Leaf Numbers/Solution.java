class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;
        
        int newSum = currentSum * 10 + node.val;
        
        if (node.left == null && node.right == null) return newSum;
        
        return dfs(node.left, newSum) + dfs(node.right, newSum);
    }
}