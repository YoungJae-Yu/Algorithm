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
            } while (c <= ' ' && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    static int n, q;
    static int[] head, to, next, deg;
    static int edgeIdx = 0;

    static void addEdge(int u, int v) {
        to[edgeIdx] = v;
        next[edgeIdx] = head[u];
        head[u] = edgeIdx++;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        n = fs.nextInt();
        q = fs.nextInt();

        head = new int[n + 1];
        Arrays.fill(head, -1);
        to = new int[2 * n];
        next = new int[2 * n];
        deg = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            addEdge(u, v);
            addEdge(v, u);
            deg[u]++;
            deg[v]++;
        }

        boolean[] removed = new boolean[n + 1];
        int[] queue = new int[n + 5];
        int front = 0, rear = 0;

        for (int i = 1; i <= n; i++) {
            if (deg[i] == 1) queue[rear++] = i;
        }

        while (front < rear) {
            int cur = queue[front++];
            removed[cur] = true;
            for (int e = head[cur]; e != -1; e = next[e]) {
                int nx = to[e];
                if (removed[nx]) continue;
                deg[nx]--;
                if (deg[nx] == 1) queue[rear++] = nx;
            }
        }

        boolean[] isCycle = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!removed[i]) isCycle[i] = true;
        }

        int[] root = new int[n + 1];
        front = 0;
        rear = 0;
        for (int i = 1; i <= n; i++) {
            if (isCycle[i]) {
                root[i] = i;
                queue[rear++] = i;
            }
        }

        while (front < rear) {
            int cur = queue[front++];
            for (int e = head[cur]; e != -1; e = next[e]) {
                int nx = to[e];
                if (isCycle[nx]) continue;
                if (root[nx] == 0) {
                    root[nx] = root[cur];
                    queue[rear++] = nx;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            sb.append(root[u] == root[v] ? 1 : 2).append('\n');
        }

        System.out.print(sb);
    }
}