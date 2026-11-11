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