# 1308. Smallest String With Swaps

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/smallest-string-with-swaps/ |

## 문제

You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.

 
Example 1:

Input: s = &quot;dcab&quot;, pairs = [[0,3],[1,2]]
Output: &quot;bacd&quot;
Explaination: 
Swap s[0] and s[3], s = &quot;bcad&quot;
Swap s[1] and s[2], s = &quot;bacd&quot;

Example 2:

Input: s = &quot;dcab&quot;, pairs = [[0,3],[1,2],[0,2]]
Output: &quot;abcd&quot;
Explaination: 
Swap s[0] and s[3], s = &quot;bcad&quot;
Swap s[0] and s[2], s = &quot;acbd&quot;
Swap s[1] and s[2], s = &quot;abcd&quot;

Example 3:

Input: s = &quot;cba&quot;, pairs = [[0,1],[1,2]]
Output: &quot;abc&quot;
Explaination: 
Swap s[0] and s[1], s = &quot;bca&quot;
Swap s[1] and s[2], s = &quot;bac&quot;
Swap s[0] and s[1], s = &quot;abc&quot;

 
Constraints:

	1 <= s.length <= 10^5
	0 <= pairs.length <= 10^5
	0 <= pairs[i][0], pairs[i][1] < s.length
	s only contains lower case English letters.

## 풀이

```java
class Solution {
    private int[] parent;
    private int[] rank;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (var pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
        
        char[] result = new char[n];
        
        for (var entry : groups.entrySet()) {
            List<Integer> indices = entry.getValue();
            List<Character> chars = new ArrayList<>();
            
            for (int idx : indices) {
                chars.add(s.charAt(idx));
            }
            
            Collections.sort(indices);
            Collections.sort(chars);
            
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = chars.get(i);
            }
        }
        
        return new String(result);
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) return;
        
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
```
