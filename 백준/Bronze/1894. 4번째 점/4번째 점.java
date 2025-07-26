import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double x3 = Double.parseDouble(st.nextToken());
            double y3 = Double.parseDouble(st.nextToken());
            double x4 = Double.parseDouble(st.nextToken());
            double y4 = Double.parseDouble(st.nextToken());

            double bx, by, ax, ay, cx, cy;
            if (x1 == x3 && y1 == y3) {
                bx = x1; by = y1; ax = x2; ay = y2; cx = x4; cy = y4;
            } else if (x1 == x4 && y1 == y4) {
                bx = x1; by = y1; ax = x2; ay = y2; cx = x3; cy = y3;
            } else if (x2 == x3 && y2 == y3) {
                bx = x2; by = y2; ax = x1; ay = y1; cx = x4; cy = y4;
            } else {
                bx = x2; by = y2; ax = x1; ay = y1; cx = x3; cy = y3;
            }

            double dx = ax + cx - bx;
            double dy = ay + cy - by;
            sb.append(String.format(Locale.US, "%.3f %.3f%n", dx, dy));
        }
        System.out.print(sb.toString());
    }
}