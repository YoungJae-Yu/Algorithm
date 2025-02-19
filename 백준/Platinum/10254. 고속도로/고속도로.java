import java.io.*;
import java.util.*;
public class Main {
    static class Point implements Comparable<Point> {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
        public int compareTo(Point o) {
            if(x == o.x) return Long.compare(y, o.y);
            return Long.compare(x, o.x);
        }
    }
    static long ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }
    static long distSq(Point a, Point b) {
        long dx = a.x - b.x, dy = a.y - b.y;
        return dx * dx + dy * dy;
    }
    static ArrayList<Point> convexHull(ArrayList<Point> pts) {
        Collections.sort(pts);
        ArrayList<Point> lower = new ArrayList<>();
        for (Point p : pts) {
            while (lower.size() >= 2 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p) <= 0)
                lower.remove(lower.size()-1);
            lower.add(p);
        }
        ArrayList<Point> upper = new ArrayList<>();
        for (int i = pts.size()-1; i >= 0; i--) {
            Point p = pts.get(i);
            while (upper.size() >= 2 && ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p) <= 0)
                upper.remove(upper.size()-1);
            upper.add(p);
        }
        lower.remove(lower.size()-1);
        upper.remove(upper.size()-1);
        lower.addAll(upper);
        return lower;
    }
    static Point[] rotatingCalipers(ArrayList<Point> hull) {
        int n = hull.size();
        if (n == 1) return new Point[]{hull.get(0), hull.get(0)};
        if (n == 2) return new Point[]{hull.get(0), hull.get(1)};
        int j = 1;
        long max = 0;
        Point[] ans = new Point[2];
        for (int i = 0; i < n; i++) {
            // 다음 점과의 ccw값(넓이 비교)을 이용하여 j 이동
            while (Math.abs(ccw(hull.get(i), hull.get((i+1) % n), hull.get((j+1) % n)))
                   > Math.abs(ccw(hull.get(i), hull.get((i+1) % n), hull.get(j)))) {
                j = (j + 1) % n;
            }
            long d = distSq(hull.get(i), hull.get(j));
            if (d > max) {
                max = d;
                ans[0] = hull.get(i);
                ans[1] = hull.get(j);
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Point> pts = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                pts.add(new Point(x, y));
            }
            ArrayList<Point> hull = convexHull(pts);
            Point[] farthest = rotatingCalipers(hull);
            if(farthest[0].x > farthest[1].x || (farthest[0].x == farthest[1].x && farthest[0].y > farthest[1].y)) {
                Point tmp = farthest[0];
                farthest[0] = farthest[1];
                farthest[1] = tmp;
            }
            sb.append(farthest[0].x).append(" ").append(farthest[0].y).append(" ")
              .append(farthest[1].x).append(" ").append(farthest[1].y).append("\n");
        }
        System.out.print(sb);
    }
}