import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static Signal[] signal = new Signal[10];
    static int sy, sx, ey, ex;
    static final int INF = 1_000_000_000;
    static final int[] dy = {0, 0, 1, -1};
    static final int[] dx = {1, -1, 0, 0};

    static class Signal {
        int type;
        int a;
        int b;
        Signal(int type, int a, int b) {
            this.type = type;
            this.a = a;
            this.b = b;
        }
    }

    static class Node implements Comparable<Node> {
        int y, x, t;
        Node(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.t, o.t);
        }
    }

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

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            do {
                c = read();
                if (c == -1) return null;
            } while (c <= 32);
            do {
                sb.append((char) c);
                c = read();
            } while (c > 32);
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean canEnter(int id, int dir, int time) {
        Signal s = signal[id];
        int cycle = s.a + s.b;
        int mod = time % cycle;
        boolean horizontalMove = dir < 2;

        if (s.type == 0) {
            if (horizontalMove) return mod < s.a;
            return mod >= s.a;
        } else {
            if (!horizontalMove) return mod < s.b;
            return mod >= s.b;
        }
    }

    static int waitTime(int id, int dir, int time) {
        Signal s = signal[id];
        int cycle = s.a + s.b;
        int mod = time % cycle;
        boolean horizontalMove = dir < 2;

        if (s.type == 0) {
            if (horizontalMove) {
                if (mod < s.a) return time;
                return time + (cycle - mod);
            } else {
                if (mod >= s.a) return time;
                return time + (s.a - mod);
            }
        } else {
            if (!horizontalMove) {
                if (mod < s.b) return time;
                return time + (cycle - mod);
            } else {
                if (mod >= s.b) return time;
                return time + (s.b - mod);
            }
        }
    }

    static int dijkstra() {
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[sy][sx] = 0;
        pq.offer(new Node(sy, sx, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.t != dist[cur.y][cur.x]) continue;
            if (cur.y == ey && cur.x == ex) return cur.t;

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                char ch = map[ny][nx];
                if (ch == '.') continue;

                int nt = cur.t + 1;

                if (isDigit(ch)) {
                    int id = ch - '0';
                    if (!canEnter(id, d, cur.t)) {
                        nt = waitTime(id, d, cur.t) + 1;
                    }
                }

                if (nt < dist[ny][nx]) {
                    dist[ny][nx] = nt;
                    pq.offer(new Node(ny, nx, nt));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        while (true) {
            String a = fs.next();
            String b = fs.next();
            if (a == null || b == null) break;

            n = Integer.parseInt(a);
            m = Integer.parseInt(b);
            if (n == 0 && m == 0) break;

            map = new char[n][m];
            Arrays.fill(signal, null);
            int signalCount = 0;

            for (int i = 0; i < n; i++) {
                String row = fs.next();
                map[i] = row.toCharArray();
                for (int j = 0; j < m; j++) {
                    char c = map[i][j];
                    if (c == 'A') {
                        sy = i;
                        sx = j;
                    } else if (c == 'B') {
                        ey = i;
                        ex = j;
                    } else if (isDigit(c)) {
                        signalCount++;
                    }
                }
            }

            for (int i = 0; i < signalCount; i++) {
                int idx = fs.nextInt();
                String dir = fs.next();
                int aa = fs.nextInt();
                int bb = fs.nextInt();
                signal[idx] = new Signal(dir.charAt(0) == '-' ? 0 : 1, aa, bb);
            }

            int ans = dijkstra();
            if (ans == -1) sb.append("impossible\n");
            else sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}