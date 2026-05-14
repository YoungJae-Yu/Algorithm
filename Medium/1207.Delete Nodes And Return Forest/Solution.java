import java.util.*;

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int val : to_delete) {
            deleteSet.add(val);
        }
        
        List<TreeNode> result = new ArrayList<>();
        
        dfs(root, true, deleteSet, result);
        
        return result;
    }
    
    private TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> deleteSet, List<TreeNode> result) {
        if (node == null) return null;
        
        boolean shouldDelete = deleteSet.contains(node.val);
        
        if (isRoot && !shouldDelete) {
            result.add(node);
        }
        
        node.left = dfs(node.left, shouldDelete, deleteSet, result);
        node.right = dfs(node.right, shouldDelete, deleteSet, result);
        
        return shouldDelete ? null : node;
    }
}