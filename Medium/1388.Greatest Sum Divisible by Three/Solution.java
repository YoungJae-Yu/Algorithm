class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        
        for (int num : nums) {
            int[] next = dp.clone();
            for (int i = 0; i < 3; i++) {
                int remainder = (dp[i] + num) % 3;
                next[remainder] = Math.max(next[remainder], dp[i] + num);
            }
            dp = next;
        }
        
        return dp[0];
    }
}