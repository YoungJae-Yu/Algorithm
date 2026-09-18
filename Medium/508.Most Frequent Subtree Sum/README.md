# 508. Most Frequent Subtree Sum

https://leetcode.com/problems/most-frequent-subtree-sum/

Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).

 
Example 1:

Input: root = [5,2,-3]
Output: [2,-3,4]

Example 2:

Input: root = [5,2,-5]
Output: [2]

 
Constraints:

	The number of nodes in the tree is in the range [1, 104].
	-105 <= Node.val <= 105

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private java.util.Map<Integer, Integer> count = new java.util.HashMap<>();
    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        java.util.List<Integer> result = new java.util.ArrayList<>();
        for (java.util.Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) res[i] = result.get(i);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int sum = node.val + dfs(node.left) + dfs(node.right);
        int freq = count.merge(sum, 1, Integer::sum);
        maxFreq = Math.max(maxFreq, freq);
        return sum;
    }
}
```
