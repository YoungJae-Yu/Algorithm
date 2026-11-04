class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    private int helper(int[] nums, int lo, int hi) {
        int prev = 0, cur = 0;
        for (int i = lo; i <= hi; i++) {
            int next = Math.max(cur, prev + nums[i]);
            prev = cur;
            cur = next;
        }
        return cur;
    }
}