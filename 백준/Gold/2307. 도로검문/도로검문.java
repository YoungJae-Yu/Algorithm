import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, w, id;
        Edge(int to, int w, int id) { this.to = to; this.w = w; this.id = id; }
    }
    static class Node implements Comparable<Node> {
        int v; long d;
        Node(int v, long d) { this.v = v; this.d = d; }
        public int compareTo(Node o) { return Long.compare(this.d, o.d); }
    }

    static final long INF = Long.MAX_VALUE / 4;
    static int N, M;
    static List<Edge>[] adj;

    static long dijkstra(int disabledEdge, int[] parent, int[] parentEdge) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.d != dist[cur.v]) continue;
            if (cur.v == N) break;
            for (Edge e : adj[cur.v]) {
                if (e.id == disabledEdge) continue;
                if (dist[e.to] > dist[cur.v] + e.w) {
                    dist[e.to] = dist[cur.v] + e.w;
                    pq.add(new Node(e.to, dist[e.to]));
                    if (parent != null) parent[e.to] = cur.v;
                    if (parentEdge != null) parentEdge[e.to] = e.id;
                }
            }
        }
        return dist[N] >= INF ? INF : dist[N];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c, i));
            adj[b].add(new Edge(a, c, i));
        }

        int[] parent = new int[N + 1];
        int[] parentEdge = new int[N + 1];
        long original = dijkstra(-1, parent, parentEdge);
        if (original >= INF) {
            System.out.println(-1);
            return;
        }

        List<Integer> pathEdges = new ArrayList<>();
        int cur = N;
        while (cur != 1) {
            int eid = parentEdge[cur];
            pathEdges.add(eid);
            cur = parent[cur];
        }

        long maxDiff = 0;
        for (int eid : pathEdges) {
            long nd = dijkstra(eid, null, null);
            if (nd >= INF) {
                System.out.println(-1);
                return;
            }
            maxDiff = Math.max(maxDiff, nd - original);
        }
        System.out.println(maxDiff);
    }
}