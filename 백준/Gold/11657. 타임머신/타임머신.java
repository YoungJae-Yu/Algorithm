import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static List<Edge> edges;
    static long[] dist;

    static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        dist = new long[N + 1];

        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        if (bellmanFord()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    static boolean bellmanFord() {
        boolean updated;

        for (int i = 0; i < N - 1; i++) {
            updated = false;
            for (Edge edge : edges) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        for (Edge edge : edges) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                return true; // 음수 사이클 존재
            }
        }

        return false; // 음수 사이클 없음
    }
}