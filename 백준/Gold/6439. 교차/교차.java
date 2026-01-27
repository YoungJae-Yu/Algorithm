import java.io.*;
import java.util.*;

public class Main {
    static class P { long x, y; P(long x, long y){this.x=x; this.y=y;} }
    static long ccw(P a, P b, P c) { return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x); }
    static boolean onOverlap(long a1, long a2, long b1, long b2) {
        if (a1 > a2) { long t=a1; a1=a2; a2=t; }
        if (b1 > b2) { long t=b1; b1=b2; b2=t; }
        return !(a2 < b1 || b2 < a1);
    }
    static boolean segIntersect(P a, P b, P c, P d) {
        long ab = ccw(a,b,c);
        long ab2 = ccw(a,b,d);
        long cd = ccw(c,d,a);
        long cd2 = ccw(c,d,b);
        if (ab == 0 && ab2 == 0) {
            return onOverlap(a.x, b.x, c.x, d.x) && onOverlap(a.y, b.y, c.y, d.y);
        }
        return ab * ab2 <= 0 && cd * cd2 <= 0;
    }
    static boolean insideRect(P p, long minx, long maxx, long miny, long maxy) {
        return p.x >= minx && p.x <= maxx && p.y >= miny && p.y <= maxy;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            long rx1 = Long.parseLong(st.nextToken());
            long ry1 = Long.parseLong(st.nextToken());
            long rx2 = Long.parseLong(st.nextToken());
            long ry2 = Long.parseLong(st.nextToken());
            long minx = Math.min(rx1, rx2);
            long maxx = Math.max(rx1, rx2);
            long miny = Math.min(ry1, ry2);
            long maxy = Math.max(ry1, ry2);
            P a = new P(x1, y1);
            P b = new P(x2, y2);
            if (insideRect(a, minx, maxx, miny, maxy) || insideRect(b, minx, maxx, miny, maxy)) {
                sb.append("T\n");
                continue;
            }
            P r1 = new P(minx, miny);
            P r2 = new P(maxx, miny);
            P r3 = new P(maxx, maxy);
            P r4 = new P(minx, maxy);
            boolean ok = false;
            if (segIntersect(a, b, r1, r2)) ok = true;
            if (segIntersect(a, b, r2, r3)) ok = true;
            if (segIntersect(a, b, r3, r4)) ok = true;
            if (segIntersect(a, b, r4, r1)) ok = true;
            sb.append(ok ? "T\n" : "F\n");
        }
        System.out.print(sb.toString());
    }
}