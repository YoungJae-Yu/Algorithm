class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] row : graph) java.util.Arrays.fill(row, -1);
        for (int[] t : times) graph[t[0]][t[1]] = t[2];

        int[] dist = new int[n + 1];
        java.util.Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int u = -1, best = Integer.MAX_VALUE;
            for (int v = 1; v <= n; v++) {
                if (!visited[v] && dist[v] < best) {
                    best = dist[v];
                    u = v;
                }
            }
            if (u == -1) break;
            visited[u] = true;
            for (int v = 1; v <= n; v++) {
                if (graph[u][v] != -1 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        int max = 0;
        for (int v = 1; v <= n; v++) {
            if (dist[v] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[v]);
        }
        return max;
    }
}