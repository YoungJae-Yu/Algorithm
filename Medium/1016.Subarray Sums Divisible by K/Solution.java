class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainderCount = new int[k];
        remainderCount[0] = 1;
        
        int prefixSum = 0;
        int result = 0;
        
        for (int num : nums) {
            prefixSum = ((prefixSum + num) % k + k) % k;
            result += remainderCount[prefixSum];
            remainderCount[prefixSum]++;
        }
        
        return result;
    }
}