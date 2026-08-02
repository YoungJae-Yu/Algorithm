class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minFromRight = new int[n];
        
        minFromRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minFromRight[i] = Math.min(nums[i], minFromRight[i + 1]);
        }
        
        int maxLeft = nums[0];
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if (maxLeft <= minFromRight[i + 1]) {
                return i + 1;
            }
        }
        
        return n - 1;
    }
}