class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int min, int max) {
        if (index == preorder.length) return null;
        
        int val = preorder[index];
        if (val < min || val > max) return null;
        
        TreeNode node = new TreeNode(val);
        index++;
        
        node.left = build(preorder, min, val - 1);
        node.right = build(preorder, val + 1, max);
        
        return node;
    }
}