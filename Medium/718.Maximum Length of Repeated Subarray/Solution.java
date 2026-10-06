class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] dp = new int[m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = prev + 1;
                    if (dp[j] > max) max = dp[j];
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return max;
    }
}