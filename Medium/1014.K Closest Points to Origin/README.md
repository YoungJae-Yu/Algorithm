# 1014. K Closest Points to Origin

https://leetcode.com/problems/k-closest-points-to-origin/

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., &radic;(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 
Example 1:

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

 
Constraints:

	1 <= k <= points.length <= 104
	-104 <= xi, yi <= 104

```java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int lo = 0, hi = points.length - 1;
        while (lo < hi) {
            int p = partition(points, lo, hi);
            if (p == k) break;
            if (p < k) lo = p + 1;
            else hi = p - 1;
        }
        int[][] res = new int[k][];
        System.arraycopy(points, 0, res, 0, k);
        return res;
    }

    private int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    private int partition(int[][] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int[] t = a[mid];
        a[mid] = a[hi];
        a[hi] = t;
        int pivot = dist(a[hi]);
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (dist(a[j]) < pivot) {
                int[] s = a[i];
                a[i] = a[j];
                a[j] = s;
                i++;
            }
        }
        int[] s = a[i];
        a[i] = a[hi];
        a[hi] = s;
        return i;
    }
}
```
