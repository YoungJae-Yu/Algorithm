class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int maxSoFar = 0;
        
        for (int i = 0; i < n - 2; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if (maxSoFar > nums[i + 2]) {
                return false;
            }
        }
        
        return true;
    }
}