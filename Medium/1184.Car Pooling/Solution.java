class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int current = 0;
        for (int d : diff) {
            current += d;
            if (current > capacity) {
                return false;
            }
        }
        return true;
    }
}