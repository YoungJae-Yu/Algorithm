import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, size;
    static long[][] seg;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        size = new int[N];
        seg = new long[N][4];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            seg[i][0] = Long.parseLong(st.nextToken());
            seg[i][1] = Long.parseLong(st.nextToken());
            seg[i][2] = Long.parseLong(st.nextToken());
            seg[i][3] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intersect(i, j)) union(i, j);
            }
        }

        boolean[] seen = new boolean[N];
        int groupCount = 0, maxSize = 0;
        for (int i = 0; i < N; i++) {
            int root = find(i);
            if (!seen[root]) {
                seen[root] = true;
                groupCount++;
                maxSize = Math.max(maxSize, size[root]);
            }
        }
        System.out.println(groupCount);
        System.out.println(maxSize);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (size[a] < size[b]) {
            parent[a] = b;
            size[b] += size[a];
        } else {
            parent[b] = a;
            size[a] += size[b];
        }
    }

    static boolean intersect(int i, int j) {
        long x1 = seg[i][0], y1 = seg[i][1], x2 = seg[i][2], y2 = seg[i][3];
        long x3 = seg[j][0], y3 = seg[j][1], x4 = seg[j][2], y4 = seg[j][3];
        long ccw1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        long ccw2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);
        if (ccw1 == 0 && ccw2 == 0) {
            return Math.max(Math.min(x1, x2), Math.min(x3, x4)) <= Math.min(Math.max(x1, x2), Math.max(x3, x4))
                && Math.max(Math.min(y1, y2), Math.min(y3, y4)) <= Math.min(Math.max(y1, y2), Math.max(y3, y4));
        }
        return ccw1 <= 0 && ccw2 <= 0;
    }

    static long ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        return (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
    }
}