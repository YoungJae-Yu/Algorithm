class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int oddCount = 0;
        int result = 0;
        for (int num : nums) {
            if ((num & 1) == 1) {
                oddCount++;
            }
            if (oddCount >= k) {
                result += count[oddCount - k];
            }
            count[oddCount]++;
        }
        return result;
    }
}