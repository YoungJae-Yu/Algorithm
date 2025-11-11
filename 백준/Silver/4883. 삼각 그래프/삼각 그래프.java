import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final long INF = Long.MAX_VALUE / 4;
        int tc = 1;
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();
            if (line.length() == 0) continue;
            int n = Integer.parseInt(line);
            if (n == 0) break;
            st = new StringTokenizer(br.readLine());
            long a0 = Long.parseLong(st.nextToken());
            long a1 = Long.parseLong(st.nextToken());
            long a2 = Long.parseLong(st.nextToken());
            long[] prev = new long[3];
            prev[0] = INF;
            prev[1] = a1;
            prev[2] = a1 + a2;
            st = new StringTokenizer(br.readLine());
            long b0 = Long.parseLong(st.nextToken());
            long b1 = Long.parseLong(st.nextToken());
            long b2 = Long.parseLong(st.nextToken());
            long[] cur = new long[3];
            cur[0] = prev[1] + b0;
            cur[1] = Math.min(Math.min(prev[1], prev[2]), cur[0]) + b1;
            cur[2] = Math.min(Math.min(prev[1], prev[2]), cur[1]) + b2;
            for (int i = 2; i < n; i++) {
                prev = cur;
                st = new StringTokenizer(br.readLine());
                long c0 = Long.parseLong(st.nextToken());
                long c1 = Long.parseLong(st.nextToken());
                long c2 = Long.parseLong(st.nextToken());
                cur = new long[3];
                cur[0] = Math.min(prev[0], prev[1]) + c0;
                cur[1] = Math.min(Math.min(Math.min(prev[0], prev[1]), prev[2]), cur[0]) + c1;
                cur[2] = Math.min(Math.min(prev[1], prev[2]), cur[1]) + c2;
            }
            System.out.println(tc + ". " + cur[1]);
            tc++;
        }
    }
}