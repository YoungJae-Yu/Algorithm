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