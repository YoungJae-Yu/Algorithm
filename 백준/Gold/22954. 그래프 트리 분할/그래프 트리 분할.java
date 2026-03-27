import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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
        int to, idx;
        Edge(int to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }

    static class Component {
        ArrayList<Integer> nodes = new ArrayList<>();
        ArrayList<Integer> treeEdges = new ArrayList<>();
    }

    static int n, m;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int[] eu, ev;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        m = fs.nextInt();

        if (n <= 2) {
            System.out.println(-1);
            return;
        }

        eu = new int[m + 1];
        ev = new int[m + 1];

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] g = new ArrayList[n + 1];
        graph = g;
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            eu[i] = u;
            ev[i] = v;
            graph[u].add(new Edge(v, i));
            graph[v].add(new Edge(u, i));
        }

        visited = new boolean[n + 1];
        ArrayList<Component> comps = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            Component comp = bfs(i);
            comps.add(comp);

            if (comps.size() >= 3) {
                System.out.println(-1);
                return;
            }
        }

        if (comps.size() == 2) {
            Component a = comps.get(0);
            Component b = comps.get(1);

            if (a.nodes.size() == b.nodes.size()) {
                System.out.println(-1);
                return;
            }

            if (a.nodes.size() < b.nodes.size()) {
                Component t = a;
                a = b;
                b = t;
            }

            StringBuilder out = new StringBuilder();
            out.append(a.nodes.size()).append(' ').append(b.nodes.size()).append('\n');
            appendList(out, a.nodes);
            appendList(out, a.treeEdges);
            appendList(out, b.nodes);
            appendList(out, b.treeEdges);
            System.out.print(out);
            return;
        }

        Component comp = comps.get(0);

        int[] deg = new int[n + 1];
        for (int idx : comp.treeEdges) {
            deg[eu[idx]]++;
            deg[ev[idx]]++;
        }

        int leaf = -1;
        for (int node : comp.nodes) {
            if (deg[node] == 1) {
                leaf = node;
                break;
            }
        }

        if (leaf == -1) {
            System.out.println(-1);
            return;
        }

        int cutEdge = -1;
        for (int idx : comp.treeEdges) {
            if (eu[idx] == leaf || ev[idx] == leaf) {
                cutEdge = idx;
                break;
            }
        }

        if (cutEdge == -1) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> bigNodes = new ArrayList<>();
        for (int node : comp.nodes) {
            if (node != leaf) bigNodes.add(node);
        }

        ArrayList<Integer> bigEdges = new ArrayList<>();
        for (int idx : comp.treeEdges) {
            if (idx != cutEdge) bigEdges.add(idx);
        }

        StringBuilder out = new StringBuilder();
        out.append(n - 1).append(' ').append(1).append('\n');
        appendList(out, bigNodes);
        appendList(out, bigEdges);
        out.append(leaf).append('\n');
        out.append('\n');
        System.out.print(out);
    }

    static Component bfs(int start) {
        Component comp = new Component();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);
        comp.nodes.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge e : graph[cur]) {
                if (visited[e.to]) continue;
                visited[e.to] = true;
                q.add(e.to);
                comp.nodes.add(e.to);
                comp.treeEdges.add(e.idx);
            }
        }

        return comp;
    }

    static void appendList(StringBuilder out, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) out.append(' ');
            out.append(list.get(i));
        }
        out.append('\n');
    }
}