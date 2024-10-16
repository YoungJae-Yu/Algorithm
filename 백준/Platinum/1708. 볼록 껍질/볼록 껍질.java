import java.util.*;

public class Main {
    static Point[] points;
    static Point base;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        points = new Point[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        // 기준점 찾기 (y좌표가 가장 작은 점, 같다면 x좌표가 작은 점)
        base = points[0];
        for (int i = 1; i < n; i++) {
            if (points[i].y < base.y || (points[i].y == base.y && points[i].x < base.x)) {
                base = points[i];
            }
        }

        // 기준점을 제외한 점들을 정렬하기 위해 기준점과의 각도를 계산
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1 == base) return -1;
                if (p2 == base) return 1;

                int ccwResult = ccw(base, p1, p2);
                if (ccwResult > 0) {
                    return -1;
                } else if (ccwResult < 0) {
                    return 1;
                } else {
                    long dist1 = distanceSquare(base, p1);
                    long dist2 = distanceSquare(base, p2);
                    return Long.compare(dist1, dist2);
                }
            }
        });

        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);

        for (int i = 2; i < n; i++) {
            while (stack.size() >= 2) {
                Point second = stack.pop();
                Point first = stack.peek();
                if (ccw(first, second, points[i]) > 0) {
                    stack.push(second);
                    break;
                }
            }
            stack.push(points[i]);
        }

        System.out.println(stack.size());
    }

    public static int ccw(Point a, Point b, Point c) {
        long result = (long) (b.x - a.x) * (c.y - a.y) - (long) (b.y - a.y) * (c.x - a.x);
        if (result > 0) return 1;   // 반시계 방향
        if (result < 0) return -1;  // 시계 방향
        return 0;                   // 일직선
    }

    public static long distanceSquare(Point a, Point b) {
        return (long) (a.x - b.x) * (a.x - b.x) + (long) (a.y - b.y) * (a.y - b.y);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}