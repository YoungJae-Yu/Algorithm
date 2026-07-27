# 1003. Minimum Area Rectangle II

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/minimum-area-rectangle-ii/ |

## 문제

You are given an array of points in the X-Y plane points where points[i] = [xi, yi].

Return the minimum area of any rectangle formed from these points, with sides not necessarily parallel to the X and Y axes. If there is not any such rectangle, return 0.

Answers within 10-5 of the actual answer will be accepted.

 
Example 1:

Input: points = [[1,2],[2,1],[1,0],[0,1]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.

Example 2:

Input: points = [[0,1],[2,1],[1,1],[1,0],[2,0]]
Output: 1.00000
Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.

Example 3:

Input: points = [[0,3],[1,2],[3,1],[1,3],[2,1]]
Output: 0
Explanation: There is no possible rectangle to form from these points.

 
Constraints:

	1 <= points.length <= 50
	points[i].length == 2
	0 <= xi, yi <= 4 * 104
	All the given points are unique.

## 풀이

```java
class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Set<String> pointSet = new HashSet<>();
        for (int[] p : points) {
            pointSet.add(p[0] + "," + p[1]);
        }

        double minArea = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] p1 = points[i], p2 = points[j], p3 = points[k];

                    int[][] candidates = {
                        {p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]},
                        {p2[0], p2[1], p1[0], p1[1], p3[0], p3[1]},
                        {p3[0], p3[1], p1[0], p1[1], p2[0], p2[1]}
                    };

                    for (int[] c : candidates) {
                        int ax = c[0], ay = c[1];
                        int bx = c[2], by = c[3];
                        int cx = c[4], cy = c[5];

                        int abx = bx - ax, aby = by - ay;
                        int acx = cx - ax, acy = cy - ay;

                        if (abx * acx + aby * acy != 0) continue;

                        int dx = bx + acx, dy = by + acy;

                        if (pointSet.contains(dx + "," + dy)) {
                            double area = Math.sqrt((double)(abx * abx + aby * aby)) *
                                          Math.sqrt((double)(acx * acx + acy * acy));
                            minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }

        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }
}
```
