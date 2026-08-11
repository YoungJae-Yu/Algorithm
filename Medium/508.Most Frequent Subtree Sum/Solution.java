import java.util.*;

class Solution {
    private final Map<Integer, Integer> freqMap = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        int maxFreq = Collections.max(freqMap.values());

        return freqMap.entrySet().stream()
                .filter(e -> e.getValue() == maxFreq)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int sum = node.val + dfs(node.left) + dfs(node.right);
        freqMap.merge(sum, 1, Integer::sum);
        return sum;
    }
}