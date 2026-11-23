# 915. Generate Random Point in a Circle

https://leetcode.com/problems/generate-random-point-in-a-circle/

Given the radius and the position of the center of a circle, implement the function randPoint which generates a uniform random point inside the circle.

Implement the Solution class:

	Solution(double radius, double x_center, double y_center) initializes the object with the radius of the circle radius and the position of the center (x_center, y_center).
	randPoint() returns a random point inside the circle. A point on the circumference of the circle is considered to be in the circle. The answer is returned as an array [x, y].

 
Example 1:

Input
[&quot;Solution&quot;, &quot;randPoint&quot;, &quot;randPoint&quot;, &quot;randPoint&quot;]
[[1.0, 0.0, 0.0], [], [], []]
Output
[null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]

Explanation
Solution solution = new Solution(1.0, 0.0, 0.0);
solution.randPoint(); // return [-0.02493, -0.38077]
solution.randPoint(); // return [0.82314, 0.38945]
solution.randPoint(); // return [0.36572, 0.17248]

 
Constraints:

	0 < radius <= 108
	-107 <= x_center, y_center <= 107
	At most 3 * 104 calls will be made to randPoint.

```java
import java.util.Random;

class Solution {
    private final double r, x, y;
    private final Random rnd = new Random();

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double d = r * Math.sqrt(rnd.nextDouble());
        double a = 2 * Math.PI * rnd.nextDouble();
        return new double[]{x + d * Math.cos(a), y + d * Math.sin(a)};
    }
}
```
