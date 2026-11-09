# 1501. Circle and Rectangle Overlapping

https://leetcode.com/problems/circle-and-rectangle-overlapping/

You are given a circle represented by its radius radius and center coordinates (xCenter, yCenter). You are also given an axis-aligned rectangle represented by (x1, y1, x2, y2), where (x1, y1) is the bottom-left corner and (x2, y2) is the top-right corner of the rectangle.

Return true if the circle and rectangle overlap; otherwise, return false.

Two shapes overlap if they share at least one point. Points on the boundaries are included, so touching at a single point also counts as overlapping.

 
Example 1:

Input: radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1

Output: true

Explanation:

	The circle is centered at (0, 0) with radius 1, and the rectangle extends from (1, -1) to (3, 1).
	The circle and rectangle touch at the point (1, 0), which lies on the circle&#39;s boundary and the rectangle&#39;s left edge.
	Since they share at least one point, they overlap. Therefore, return true.

Example 2:

Input: radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1

Output: false

Explanation:

	The circle is centered at (1, 1) with radius 1, while the rectangle extends from (1, -3) to (2, -1).
	The closest point on the rectangle to the circle&#39;s center is (1, -1). The distance between these points is 2, which is greater than the circle&#39;s radius of 1.
	Since the circle cannot reach the rectangle, they do not overlap. Therefore, return false.

Example 3:

Input: radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1

Output: true

Explanation:

	The circle is centered at (0, 0) with radius 1, and the rectangle extends from (-1, 0) to (0, 1).
	The point (0, 0) is both the center of the circle and the bottom-right corner of the rectangle.
	Since this point belongs to both shapes, they overlap. Therefore, return true.

 
Constraints:

	1 <= radius <= 2000
	-104 <= xCenter, yCenter <= 104
	-104 <= x1 < x2 <= 104
	-104 <= y1 < y2 <= 104

```java
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        long dx = xCenter - Math.max(x1, Math.min(xCenter, x2));
        long dy = yCenter - Math.max(y1, Math.min(yCenter, y2));
        return dx * dx + dy * dy <= (long) radius * radius;
    }
}
```
