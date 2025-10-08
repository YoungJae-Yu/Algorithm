import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] adj = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (u <= D && v <= D) adj[u].add(new int[]{v, w});
        }
        final int INF = Integer.MAX_VALUE / 2;
        int[] dist = new int[D + 1];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        for (int i = 0; i <= D; i++) {
            if (i > 0 && dist[i] > dist[i - 1] + 1) dist[i] = dist[i - 1] + 1;
            for (int[] sc : adj[i]) {
                int to = sc[0], cost = sc[1];
                if (dist[to] > dist[i] + cost) dist[to] = dist[i] + cost;
            }
        }
        System.out.println(dist[D]);
    }
}