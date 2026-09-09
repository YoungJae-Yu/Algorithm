class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0], curMax = nums[0], idx = 0;
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                idx = i;
            }
        }
        return idx + 1;
    }
}