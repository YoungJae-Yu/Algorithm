class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        morrisInorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void morrisInorder(TreeNode root) {
        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.left == null) {
                processNode(curr);
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    processNode(curr);
                    curr = curr.right;
                }
            }
        }
    }

    private void processNode(TreeNode node) {
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;
    }
}