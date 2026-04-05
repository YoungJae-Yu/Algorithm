import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= 32 && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > 32 && c != -1) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    static class Edge {
        int to, w, id;
        Edge(int to, int w, int id) {
            this.to = to;
            this.w = w;
            this.id = id;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        long d;
        Node(int v, long d) {
            this.v = v;
            this.d = d;
        }
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }
    }

    static final long INF = Long.MAX_VALUE / 4;

    static int n, m;
    static ArrayList<Edge>[] graph;
    static int[] eu, ev, ew;

    static long[][] dist;
    static byte[][] type;
    static int[][] split;
    static int[][] prevV;
    static int[][] prevE;

    static boolean[] used;
    static ArrayList<Integer> result;

    static void reconstruct(int mask, int v) {
        if (type[mask][v] == 0) return;

        if (type[mask][v] == 1) {
            int pv = prevV[mask][v];
            int pe = prevE[mask][v];
            reconstruct(mask, pv);
            if (!used[pe]) {
                used[pe] = true;
                result.add(pe);
            }
        } else {
            int s = split[mask][v];
            reconstruct(s, v);
            reconstruct(mask ^ s, v);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        n = fs.nextInt();
        m = fs.nextInt();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        eu = new int[m];
        ev = new int[m];
        ew = new int[m];

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();
            eu[i] = a;
            ev[i] = b;
            ew[i] = c;
            graph[a].add(new Edge(b, c, i));
            graph[b].add(new Edge(a, c, i));
        }

        int[] t = new int[3];
        t[0] = fs.nextInt();
        t[1] = fs.nextInt();
        t[2] = fs.nextInt();

        dist = new long[8][n + 1];
        type = new byte[8][n + 1];
        split = new int[8][n + 1];
        prevV = new int[8][n + 1];
        prevE = new int[8][n + 1];

        for (int mask = 0; mask < 8; mask++) {
            Arrays.fill(dist[mask], INF);
        }

        for (int i = 0; i < 3; i++) {
            dist[1 << i][t[i]] = 0;
        }

        for (int mask = 1; mask < 8; mask++) {
            if ((mask & (mask - 1)) != 0) {
                for (int sub = (mask - 1) & mask; sub > 0; sub = (sub - 1) & mask) {
                    int other = mask ^ sub;
                    if (sub > other) continue;
                    for (int v = 1; v <= n; v++) {
                        long a = dist[sub][v];
                        long b = dist[other][v];
                        if (a == INF || b == INF) continue;
                        long nd = a + b;
                        if (nd < dist[mask][v]) {
                            dist[mask][v] = nd;
                            type[mask][v] = 2;
                            split[mask][v] = sub;
                        }
                    }
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int v = 1; v <= n; v++) {
                if (dist[mask][v] < INF) pq.add(new Node(v, dist[mask][v]));
            }

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (cur.d != dist[mask][cur.v]) continue;

                for (Edge e : graph[cur.v]) {
                    long nd = cur.d + e.w;
                    if (nd < dist[mask][e.to]) {
                        dist[mask][e.to] = nd;
                        type[mask][e.to] = 1;
                        prevV[mask][e.to] = cur.v;
                        prevE[mask][e.to] = e.id;
                        pq.add(new Node(e.to, nd));
                    }
                }
            }
        }

        int full = 7;
        int bestV = 1;
        for (int v = 2; v <= n; v++) {
            if (dist[full][v] < dist[full][bestV]) bestV = v;
        }

        used = new boolean[m];
        result = new ArrayList<>();
        reconstruct(full, bestV);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[full][bestV]).append(' ').append(result.size()).append('\n');
        for (int id : result) {
            sb.append(eu[id]).append(' ').append(ev[id]).append('\n');
        }
        System.out.print(sb.toString());
    }
}