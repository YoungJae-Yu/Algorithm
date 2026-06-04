# 1030. Smallest String Starting From Leaf

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/smallest-string-starting-from-leaf/ |

## 문제

You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters &#39;a&#39; to &#39;z&#39;.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

	For example, &quot;ab&quot; is lexicographically smaller than &quot;aba&quot;.

A leaf of a node is a node that has no children.

 
Example 1:

Input: root = [0,1,2,3,4,3,4]
Output: &quot;dba&quot;

Example 2:

Input: root = [25,1,3,1,3,0,2]
Output: &quot;adz&quot;

Example 3:

Input: root = [2,2,1,null,1,0,null,0]
Output: &quot;abc&quot;

 
Constraints:

	The number of nodes in the tree is in the range [1, 8500].
	0 <= Node.val <= 25

## 풀이

```java
class Solution {
    private String smallest = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) {
            String current = sb.reverse().toString();
            if (smallest == null || current.compareTo(smallest) < 0) {
                smallest = current;
            }
            sb.reverse();
        } else {
            dfs(node.left, sb);
            dfs(node.right, sb);
        }

        sb.deleteCharAt(sb.length() - 1);
    }
}
```
