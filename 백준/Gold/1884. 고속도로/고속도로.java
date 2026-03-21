import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, len, cost;
        Edge(int to, int len, int cost) {
            this.to = to;
            this.len = len;
            this.cost = cost;
        }
    }

    static class State implements Comparable<State> {
        int node, cost, dist;
        State(int node, int cost, int dist) {
            this.node = node;
            this.cost = cost;
            this.dist = dist;
        }

        public int compareTo(State o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine().trim());
        int N = Integer.parseInt(br.readLine().trim());
        int R = Integer.parseInt(br.readLine().trim());

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(d, l, t));
        }

        int[][] dist = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) Arrays.fill(dist[i], INF);

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[1][0] = 0;
        pq.add(new State(1, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist != dist[cur.node][cur.cost]) continue;

            for (Edge e : graph[cur.node]) {
                int nc = cur.cost + e.cost;
                if (nc > K) continue;

                int nd = cur.dist + e.len;
                if (dist[e.to][nc] > nd) {
                    dist[e.to][nc] = nd;
                    pq.add(new State(e.to, nc, nd));
                }
            }
        }

        int ans = INF;
        for (int c = 0; c <= K; c++) ans = Math.min(ans, dist[N][c]);

        System.out.println(ans == INF ? -1 : ans);
    }
}