class Solution {
    public int maximumSum(int[] arr) {
        int noDel = arr[0];
        int oneDel = Integer.MIN_VALUE / 2;
        int best = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            oneDel = Math.max(oneDel + x, noDel);
            noDel = Math.max(noDel + x, x);
            best = Math.max(best, Math.max(noDel, oneDel));
        }
        return best;
    }
}