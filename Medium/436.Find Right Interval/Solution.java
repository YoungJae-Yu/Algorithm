class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        java.util.Arrays.sort(starts, (a, b) -> a[0] - b[0]);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            int lo = 0, hi = n - 1, ans = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (starts[mid][0] >= target) {
                    ans = starts[mid][1];
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            result[i] = ans;
        }
        return result;
    }
}