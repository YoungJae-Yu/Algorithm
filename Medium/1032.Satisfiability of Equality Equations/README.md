# 1032. Satisfiability of Equality Equations

https://leetcode.com/problems/satisfiability-of-equality-equations/

You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: &quot;xi==yi&quot; or &quot;xi!=yi&quot;.Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

 
Example 1:

Input: equations = [&quot;a==b&quot;,&quot;b!=a&quot;]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.

Example 2:

Input: equations = [&quot;b==a&quot;,&quot;a==b&quot;]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.

 
Constraints:

	1 <= equations.length <= 500
	equations[i].length == 4
	equations[i][0] is a lowercase letter.
	equations[i][1] is either &#39;=&#39; or &#39;!&#39;.
	equations[i][2] is &#39;=&#39;.
	equations[i][3] is a lowercase letter.

```java
class Solution {
    private int[] parent = new int[26];

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                int a = find(e.charAt(0) - 'a');
                int b = find(e.charAt(3) - 'a');
                if (a != b) {
                    parent[a] = b;
                }
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!') {
                if (find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
```
