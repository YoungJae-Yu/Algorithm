# 976. Minimum Area Rectangle

https://leetcode.com/problems/minimum-area-rectangle/

You are given an array of points in the X-Y plane points where points[i] = [xi, yi].

Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes. If there is not any such rectangle, return 0.

 
Example 1:

Input: points = [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4

Example 2:

Input: points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2

 
Constraints:

	1 <= points.length <= 500
	points[i].length == 2
	0 <= xi, yi <= 4 * 104
	All the given points are unique.

```java
import java.util.*;

class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            map.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
        }
        int minArea = Integer.MAX_VALUE;
        Integer[] xs = map.keySet().toArray(new Integer[0]);
        Arrays.sort(xs);
        for (int i = 0; i < xs.length; i++) {
            Set<Integer> ys1 = map.get(xs[i]);
            for (int j = i + 1; j < xs.length; j++) {
                Set<Integer> ys2 = map.get(xs[j]);
                Set<Integer> common = new ArrayList<>(ys1).stream()
                        .filter(ys2::contains)
                        .collect(java.util.stream.Collectors.toSet())
                        .isEmpty() ? null : null;
                List<Integer> commonYs = new ArrayList<>();
                for (int y : ys1) {
                    if (ys2.contains(y)) commonYs.add(y);
                }
                if (commonYs.size() < 2) continue;
                Collections.sort(commonYs);
                int width = xs[j] - xs[i];
                for (int k = 1; k < commonYs.size(); k++) {
                    int height = commonYs.get(k) - commonYs.get(k - 1);
                    int area = width * height;
                    if (area < minArea) minArea = area;
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
```
