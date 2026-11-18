class Solution {
    public void sortColors(int[] nums) {
        int lo = 0, mid = 0, hi = nums.length - 1;
        while (mid <= hi) {
            int v = nums[mid];
            if (v == 0) {
                nums[mid++] = nums[lo];
                nums[lo++] = 0;
            } else if (v == 2) {
                nums[mid] = nums[hi];
                nums[hi--] = 2;
            } else {
                mid++;
            }
        }
    }
}