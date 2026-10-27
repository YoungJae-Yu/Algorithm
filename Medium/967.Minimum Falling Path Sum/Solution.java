class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = matrix[0].clone();
        for (int i = 1; i < n; i++) {
            int[] next = new int[n];
            for (int j = 0; j < n; j++) {
                int best = dp[j];
                if (j > 0) best = Math.min(best, dp[j - 1]);
                if (j < n - 1) best = Math.min(best, dp[j + 1]);
                next[j] = matrix[i][j] + best;
            }
            dp = next;
        }
        int result = dp[0];
        for (int v : dp) result = Math.min(result, v);
        return result;
    }
}