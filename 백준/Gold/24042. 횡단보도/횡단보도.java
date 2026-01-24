import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        int idx;
        Edge(int to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }

    static class Node {
        int v;
        long time;
        Node(int v, long time) {
            this.v = v;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, i));
            graph.get(b).add(new Edge(a, i));
        }

        final long INF = Long.MAX_VALUE / 2;
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.time));
        dist[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.time > dist[cur.v]) continue;

            if (cur.v == N) break;

            for (Edge e : graph.get(cur.v)) {
                long curTime = cur.time;
                // 다음 초록불 시간 계산
                long diff = curTime - e.idx;
                long nextGreen;
                if (diff <= 0) {
                    nextGreen = e.idx;
                } else {
                    nextGreen = e.idx + ((diff + M - 1) / M) * M;
                }

                long arrive = nextGreen + 1;
                if (arrive < dist[e.to]) {
                    dist[e.to] = arrive;
                    pq.offer(new Node(e.to, arrive));
                }
            }
        }

        System.out.println(dist[N] == INF ? -1 : dist[N]);
    }
}