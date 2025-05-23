import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        Point p1, p2;

        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    static int[] parent;
    static int[] groupSize;

    static int ccw(Point p1, Point p2, Point p3) {
        long val = (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
        if (val > 0) return 1;
        if (val < 0) return -1;
        return 0;
    }

    static boolean onSegment(Point p, Point q, Point r) {
        return (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y));
    }

    static boolean doIntersect(Line l1, Line l2) {
        Point p1 = l1.p1, p2 = l1.p2;
        Point p3 = l2.p1, p4 = l2.p2;

        int o1 = ccw(p1, p2, p3);
        int o2 = ccw(p1, p2, p4);
        int o3 = ccw(p3, p4, p1);
        int o4 = ccw(p3, p4, p2);

        if ((long)o1 * o2 < 0 && (long)o3 * o4 < 0) {
            return true;
        }

        if (o1 == 0 && onSegment(p1, p3, p2)) return true;
        if (o2 == 0 && onSegment(p1, p4, p2)) return true;
        if (o3 == 0 && onSegment(p3, p1, p4)) return true;
        if (o4 == 0 && onSegment(p3, p2, p4)) return true;

        return false;
    }

    static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (rootI < rootJ) { // Convention to merge smaller index to larger or vice versa
                parent[rootJ] = rootI;
                groupSize[rootI] += groupSize[rootJ];
                groupSize[rootJ] = 0; 
            } else {
                parent[rootI] = rootJ;
                groupSize[rootJ] += groupSize[rootI];
                groupSize[rootI] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        Line[] lines = new Line[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            lines[i] = new Line(new Point(x1, y1), new Point(x2, y2));
        }

        parent = new int[N];
        groupSize = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            groupSize[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (doIntersect(lines[i], lines[j])) {
                    union(i, j);
                }
            }
        }

        int numberOfGroups = 0;
        int maxSizeOfGroup = 0;

        for (int i = 0; i < N; i++) {
            if (parent[i] == i) { 
                numberOfGroups++;
                maxSizeOfGroup = Math.max(maxSizeOfGroup, groupSize[i]);
            }
        }
        
        System.out.println(numberOfGroups);
        System.out.println(maxSizeOfGroup);
    }
}

