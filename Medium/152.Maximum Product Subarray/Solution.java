class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = maxEndingHere;
            
            maxEndingHere = Math.max(num, Math.max(num * maxEndingHere, num * minEndingHere));
            minEndingHere = Math.min(num, Math.min(num * tempMax, num * minEndingHere));
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}