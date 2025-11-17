import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N == M) {
            System.out.println(0);
            return;
        }
        int MAX = 100000;
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[N] = 0;
        q.add(N);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int d = dist[cur] + 1;
            int[] nexts = new int[] {
                cur - 1,
                cur + 1,
                cur - A,
                cur + A,
                cur - B,
                cur + B,
                cur * A,
                cur * B
            };
            for (int nx : nexts) {
                if (nx < 0 || nx > MAX) continue;
                if (dist[nx] != -1) continue;
                dist[nx] = d;
                if (nx == M) {
                    System.out.println(dist[nx]);
                    return;
                }
                q.add(nx);
            }
        }
        System.out.println(dist[M]);
    }
}