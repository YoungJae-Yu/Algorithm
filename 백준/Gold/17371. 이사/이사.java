import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] xs = new int[N];
        int[] ys = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        long bestMaxDist2 = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            long maxDist2 = 0;
            for (int j = 0; j < N; j++) {
                long dx = xs[i] - xs[j];
                long dy = ys[i] - ys[j];
                long d2 = dx * dx + dy * dy;
                if (d2 > maxDist2) maxDist2 = d2;
            }
            if (maxDist2 < bestMaxDist2) {
                bestMaxDist2 = maxDist2;
                ans = i;
            }
        }

        System.out.println(xs[ans] + " " + ys[ans]);
    }
}