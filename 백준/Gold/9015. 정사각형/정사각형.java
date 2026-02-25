import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] x = new int[N];
            int[] y = new int[N];
            HashSet<Long> set = new HashSet<>(N * 2);
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                long key = (((long)x[i]) << 32) ^ (y[i] & 0xffffffffL);
                set.add(key);
            }
            long best = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int dx = x[j] - x[i];
                    int dy = y[j] - y[i];
                    long area = 1L * dx * dx + 1L * dy * dy;
                    int x3 = x[i] - dy;
                    int y3 = y[i] + dx;
                    int x4 = x[j] - dy;
                    int y4 = y[j] + dx;
                    long k3 = (((long)x3) << 32) ^ (y3 & 0xffffffffL);
                    long k4 = (((long)x4) << 32) ^ (y4 & 0xffffffffL);
                    if (set.contains(k3) && set.contains(k4)) {
                        if (area > best) best = area;
                    }
                    x3 = x[i] + dy;
                    y3 = y[i] - dx;
                    x4 = x[j] + dy;
                    y4 = y[j] - dx;
                    k3 = (((long)x3) << 32) ^ (y3 & 0xffffffffL);
                    k4 = (((long)x4) << 32) ^ (y4 & 0xffffffffL);
                    if (set.contains(k3) && set.contains(k4)) {
                        if (area > best) best = area;
                    }
                }
            }
            sb.append(best).append('\n');
        }
        System.out.print(sb.toString());
    }
}