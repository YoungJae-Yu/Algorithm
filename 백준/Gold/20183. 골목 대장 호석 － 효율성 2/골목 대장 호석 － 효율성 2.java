import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        int w;
        Edge(int t, int w) { this.to = t; this.w = w; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken()) - 1;
        long C = Long.parseLong(st.nextToken());
        List<Edge>[] g = new ArrayList[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        int maxW = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
            if (w > maxW) maxW = w;
        }

        int left = 0;
        int right = maxW;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            long dist = dijkstraLimited(N, g, A, B, mid);
            if (dist <= C) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static long dijkstraLimited(int n, List<Edge>[] g, int s, int t, int limit) {
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        dist[s] = 0;
        pq.add(new long[] {0, s});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cd = cur[0];
            int u = (int) cur[1];
            if (cd > dist[u]) continue;
            if (u == t) break;
            for (Edge e : g[u]) {
                if (e.w > limit) continue;
                long nd = cd + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.add(new long[] {nd, e.to});
                }
            }
        }
        return dist[t];
    }
}