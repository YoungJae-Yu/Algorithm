class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;
    }
    
    private Result helper(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result left = helper(node.left);
        Result right = helper(node.right);
        if (left.depth == right.depth) return new Result(node, left.depth + 1);
        if (left.depth > right.depth) return new Result(left.node, left.depth + 1);
        return new Result(right.node, right.depth + 1);
    }
    
    private static class Result {
        TreeNode node;
        int depth;
        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}