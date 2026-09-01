class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countAtMost(nums, right) - countAtMost(nums, left - 1);
    }

    private int countAtMost(int[] nums, int bound) {
        int count = 0;
        int streak = 0;
        for (int num : nums) {
            streak = num <= bound ? streak + 1 : 0;
            count += streak;
        }
        return count;
    }
}