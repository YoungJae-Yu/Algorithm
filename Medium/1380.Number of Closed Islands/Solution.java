class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            fill(grid, i, 0);
            fill(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            fill(grid, 0, j);
            fill(grid, m - 1, j);
        }
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    fill(grid, i, j);
                }
            }
        }
        return count;
    }

    private void fill(int[][] g, int r, int c) {
        if (g[r][c] != 0) return;
        int m = g.length, n = g[0].length;
        int[] stack = new int[m * n];
        int sp = 0;
        g[r][c] = 1;
        stack[sp++] = r * n + c;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        while (sp > 0) {
            int cur = stack[--sp];
            int x = cur / n, y = cur % n;
            for (int d = 0; d < 4; d++) {
                int nx = x + dr[d], ny = y + dc[d];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && g[nx][ny] == 0) {
                    g[nx][ny] = 1;
                    stack[sp++] = nx * n + ny;
                }
            }
        }
    }
}