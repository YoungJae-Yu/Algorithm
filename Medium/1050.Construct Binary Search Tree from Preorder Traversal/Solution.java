class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index++]);
        node.left = build(preorder, node.val);
        node.right = build(preorder, bound);
        return node;
    }
}