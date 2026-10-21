# 757. Pyramid Transition Matrix

https://leetcode.com/problems/pyramid-transition-matrix/

You are stacking blocks to form a pyramid. Each block has a color, which is represented by a single letter. Each row of blocks contains one less block than the row beneath it and is centered on top.

To make the pyramid aesthetically pleasing, there are only specific triangular patterns that are allowed. A triangular pattern consists of a single block stacked on top of two blocks. The patterns are given as a list of three-letter strings allowed, where the first two characters of a pattern represent the left and right bottom blocks respectively, and the third character is the top block.

	For example, &quot;ABC&quot; represents a triangular pattern with a &#39;C&#39; block stacked on top of an &#39;A&#39; (left) and &#39;B&#39; (right) block. Note that this is different from &quot;BAC&quot; where &#39;B&#39; is on the left bottom and &#39;A&#39; is on the right bottom.

You start with a bottom row of blocks bottom, given as a single string, that you must use as the base of the pyramid.

Given bottom and allowed, return true if you can build the pyramid all the way to the top such that every triangular pattern in the pyramid is in allowed, or false otherwise.

 
Example 1:

Input: bottom = &quot;BCD&quot;, allowed = [&quot;BCC&quot;,&quot;CDE&quot;,&quot;CEA&quot;,&quot;FFF&quot;]
Output: true
Explanation: The allowed triangular patterns are shown on the right.
Starting from the bottom (level 3), we can build &quot;CE&quot; on level 2 and then build &quot;A&quot; on level 1.
There are three triangular patterns in the pyramid, which are &quot;BCC&quot;, &quot;CDE&quot;, and &quot;CEA&quot;. All are allowed.

Example 2:

Input: bottom = &quot;AAAA&quot;, allowed = [&quot;AAB&quot;,&quot;AAC&quot;,&quot;BCD&quot;,&quot;BBE&quot;,&quot;DEF&quot;]
Output: false
Explanation: The allowed triangular patterns are shown on the right.
Starting from the bottom (level 4), there are multiple ways to build level 3, but trying all the possibilites, you will get always stuck before building level 1.

 
Constraints:

	2 <= bottom.length <= 6
	0 <= allowed.length <= 216
	allowed[i].length == 3
	The letters in all input strings are from the set {&#39;A&#39;, &#39;B&#39;, &#39;C&#39;, &#39;D&#39;, &#39;E&#39;, &#39;F&#39;}.
	All the values of allowed are unique.

```java
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            map.computeIfAbsent(s.substring(0, 2), k -> new java.util.ArrayList<>()).add(s.charAt(2));
        }
        return solve(bottom, map);
    }

    private boolean solve(String bottom, Map<String, List<Character>> map) {
        if (bottom.length() == 1) return true;
        return build(bottom, 0, new StringBuilder(), map);
    }

    private boolean build(String bottom, int idx, StringBuilder next, Map<String, List<Character>> map) {
        if (idx == bottom.length() - 1) {
            return solve(next.toString(), map);
        }
        String key = bottom.substring(idx, idx + 2);
        List<Character> options = map.get(key);
        if (options == null) return false;
        for (char c : options) {
            next.append(c);
            if (build(bottom, idx + 1, next, map)) return true;
            next.deleteCharAt(next.length() - 1);
        }
        return false;
    }
}
```
