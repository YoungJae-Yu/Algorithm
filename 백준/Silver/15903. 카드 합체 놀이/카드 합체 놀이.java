import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) pq.add(Long.parseLong(st.nextToken()));
        for (int i = 0; i < m; i++) {
            long a = pq.poll();
            long b = pq.poll();
            long s = a + b;
            pq.add(s);
            pq.add(s);
        }
        long ans = 0;
        while (!pq.isEmpty()) ans += pq.poll();
        System.out.println(ans);
    }
}