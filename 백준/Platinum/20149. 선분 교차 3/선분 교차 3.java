import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point)o;
                return x == p.x && y == p.y;
            }
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    static int ccw(Point a, Point b, Point c) {
        long cross = (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
        if (cross > 0) return 1;
        else if (cross < 0) return -1;
        else return 0;
    }
    static boolean onSegment(Point a, Point b, Point c) {
        return Math.min(a.x, b.x) <= c.x && c.x <= Math.max(a.x, b.x) &&
               Math.min(a.y, b.y) <= c.y && c.y <= Math.max(a.y, b.y);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Point A, B, C, D;
        st = new StringTokenizer(br.readLine());
        A = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        B = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        C = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        D = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        int o1 = ccw(A, B, C);
        int o2 = ccw(A, B, D);
        int o3 = ccw(C, D, A);
        int o4 = ccw(C, D, B);

        boolean intersect = false;
        if (o1 * o2 <= 0 && o3 * o4 <= 0) {
            if (o1 == 0 && o2 == 0 && o3 == 0 && o4 == 0) {
                if (Math.max(A.x, B.x) < Math.min(C.x, D.x) || Math.min(A.x, B.x) > Math.max(C.x, D.x) ||
                    Math.max(A.y, B.y) < Math.min(C.y, D.y) || Math.min(A.y, B.y) > Math.max(C.y, D.y)) {
                    intersect = false;
                } else {
                    intersect = true;
                }
            } else {
                intersect = true;
            }
        }

        if (intersect) {
            System.out.println(1);
            Set<Point> points = new HashSet<>();
            if (o1 == 0 && onSegment(A, B, C)) points.add(C);
            if (o2 == 0 && onSegment(A, B, D)) points.add(D);
            if (o3 == 0 && onSegment(C, D, A)) points.add(A);
            if (o4 == 0 && onSegment(C, D, B)) points.add(B);

            if (points.size() == 1) {
                Point p = points.iterator().next();
                System.out.println(p.x + " " + p.y);
            } else if (points.size() == 0) {
                double x, y;
                long a1 = B.y - A.y;
                long b1 = A.x - B.x;
                long c1 = a1 * A.x + b1 * A.y;

                long a2 = D.y - C.y;
                long b2 = C.x - D.x;
                long c2 = a2 * C.x + b2 * C.y;

                long det = a1 * b2 - a2 * b1;

                x = (double)(b2 * c1 - b1 * c2) / det;
                y = (double)(a1 * c2 - a2 * c1) / det;

                System.out.printf("%.10f %.10f\n", x, y);
            }
        } else {
            System.out.println(0);
        }
    }
}