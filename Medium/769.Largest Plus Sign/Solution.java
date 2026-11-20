class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        boolean[][] z = new boolean[n][n];
        for (int[] m : mines) z[m[0]][m[1]] = true;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                c = z[i][j] ? 0 : c + 1;
                d[i][j] = c;
            }
            c = 0;
            for (int j = n - 1; j >= 0; j--) {
                c = z[i][j] ? 0 : c + 1;
                d[i][j] = Math.min(d[i][j], c);
            }
        }
        int best = 0;
        for (int j = 0; j < n; j++) {
            int c = 0;
            for (int i = 0; i < n; i++) {
                c = z[i][j] ? 0 : c + 1;
                d[i][j] = Math.min(d[i][j], c);
            }
            c = 0;
            for (int i = n - 1; i >= 0; i--) {
                c = z[i][j] ? 0 : c + 1;
                d[i][j] = Math.min(d[i][j], c);
                best = Math.max(best, d[i][j]);
            }
        }
        return best;
    }
}