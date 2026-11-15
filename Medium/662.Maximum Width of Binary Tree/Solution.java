import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Long> idx = new ArrayDeque<>();
        nodes.add(root);
        idx.add(0L);
        long best = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            long first = idx.peekFirst();
            long last = first;
            for (int i = 0; i < size; i++) {
                TreeNode n = nodes.poll();
                long id = idx.poll() - first;
                last = id;
                if (n.left != null) {
                    nodes.add(n.left);
                    idx.add(2 * id);
                }
                if (n.right != null) {
                    nodes.add(n.right);
                    idx.add(2 * id + 1);
                }
            }
            best = Math.max(best, last + 1);
        }
        return (int) best;
    }
}