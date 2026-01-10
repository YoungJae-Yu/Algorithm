import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost;
        Edge(int t, int c) { to = t; cost = c; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] g = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
        int maxCost = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, c));
            g[b].add(new Edge(a, c));
            if (c > maxCost) maxCost = c;
        }

        int low = 0, high = maxCost, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canReachWithLimit(g, N, K, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean canReachWithLimit(ArrayList<Edge>[] g, int N, int K, int limit) {
        int INF = Integer.MAX_VALUE / 4;
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[1] = 0;
        pq.add(new int[] {0, 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int used = cur[0];
            int node = cur[1];
            if (used > dist[node]) continue;
            if (node == N) break;
            for (Edge e : g[node]) {
                int nxtUsed = used + (e.cost > limit ? 1 : 0);
                if (nxtUsed < dist[e.to] && nxtUsed <= K) {
                    dist[e.to] = nxtUsed;
                    pq.add(new int[] {nxtUsed, e.to});
                }
            }
        }
        return dist[N] <= K;
    }
}