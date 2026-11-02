import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean rev = false;
        while (!q.isEmpty()) {
            int n = q.size();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                arr[rev ? n - 1 - i : i] = node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(Arrays.asList(arr));
            rev = !rev;
        }
        return res;
    }
}