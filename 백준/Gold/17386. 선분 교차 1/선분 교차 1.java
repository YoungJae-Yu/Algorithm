import java.util.Scanner;

public class Main {

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int ccw(Point a, Point b, Point c) {
        long result = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (result > 0) return 1;
        else if (result < 0) return -1;
        else return 0;
    }

    public static boolean isIntersect(Point p1, Point p2, Point p3, Point p4) {
        int ccw1 = ccw(p1, p2, p3);
        int ccw2 = ccw(p1, p2, p4);
        int ccw3 = ccw(p3, p4, p1);
        int ccw4 = ccw(p3, p4, p2);

        return ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Point p1 = new Point(sc.nextLong(), sc.nextLong());
        Point p2 = new Point(sc.nextLong(), sc.nextLong());
        Point p3 = new Point(sc.nextLong(), sc.nextLong());
        Point p4 = new Point(sc.nextLong(), sc.nextLong());

        if (isIntersect(p1, p2, p3, p4)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}