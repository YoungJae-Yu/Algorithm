class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;
        int[] queue = new int[n * n];
        int head = 0, tail = 0;
        queue[tail++] = 0;
        grid[0][0] = 1;
        int dist = 1;
        while (head < tail) {
            int size = tail - head;
            dist++;
            for (int s = 0; s < size; s++) {
                int cur = queue[head++];
                int r = cur / n, c = cur % n;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nr = r + dr, nc = c + dc;
                        if (nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 1) continue;
                        if (nr == n - 1 && nc == n - 1) return dist;
                        grid[nr][nc] = 1;
                        queue[tail++] = nr * n + nc;
                    }
                }
            }
        }
        return -1;
    }
}