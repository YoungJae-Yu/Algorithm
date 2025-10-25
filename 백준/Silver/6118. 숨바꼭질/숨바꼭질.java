import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nx : adj[cur]) {
                if (dist[nx] == -1) {
                    dist[nx] = dist[cur] + 1;
                    q.add(nx);
                }
            }
        }
        int max = 0;
        int idx = 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > max) {
                max = dist[i];
                idx = i;
                count = 1;
            } else if (dist[i] == max) {
                count++;
            }
        }
        System.out.println(idx + " " + max + " " + count);
    }
}