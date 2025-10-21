import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int perimeter = 2 * (w + h);
        int[] stores = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            stores[i] = convert(dir, dist, w, h);
        }
        st = new StringTokenizer(br.readLine());
        int guardDir = Integer.parseInt(st.nextToken());
        int guardDist = Integer.parseInt(st.nextToken());
        int guardPos = convert(guardDir, guardDist, w, h);
        int sum = 0;
        for (int s : stores) {
            int diff = Math.abs(guardPos - s);
            sum += Math.min(diff, perimeter - diff);
        }
        System.out.println(sum);
    }

    static int convert(int dir, int dist, int w, int h) {
        if (dir == 1) return dist;
        if (dir == 2) return w + h + (w - dist);
        if (dir == 3) return w + h + w + (h - dist);
        return w + dist;
    }
}