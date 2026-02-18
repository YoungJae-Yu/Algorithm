import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    static class Line {
        long x1, y1;
        long x2, y2;
        long w;
    }

    static long ccw(long ax, long ay, long bx, long by, long cx, long cy) {
        long v = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
        if (v > 0) return 1;
        if (v < 0) return -1;
        return 0;
    }

    static boolean intersect(Line a, Line b) {
        long abc = ccw(a.x1, a.y1, a.x2, a.y2, b.x1, b.y1) * 
                   ccw(a.x1, a.y1, a.x2, a.y2, b.x2, b.y2);
        long cda = ccw(b.x1, b.y1, b.x2, b.y2, a.x1, a.y1) * 
                   ccw(b.x1, b.y1, b.x2, b.y2, a.x2, a.y2);
        return abc < 0 && cda < 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Line[] lines = new Line[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line();
            lines[i].x1 = Long.parseLong(st.nextToken());
            lines[i].y1 = Long.parseLong(st.nextToken());
            lines[i].x2 = Long.parseLong(st.nextToken());
            lines[i].y2 = Long.parseLong(st.nextToken());
            lines[i].w  = Long.parseLong(st.nextToken());
        }

        Arrays.sort(lines, Comparator.comparingLong(o -> o.w));

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long count = 0;
            for (int j = i + 1; j < n; j++) {
                if (intersect(lines[i], lines[j])) count++;
            }
            ans += lines[i].w * (count + 1);
        }

        System.out.print(ans);
    }
}