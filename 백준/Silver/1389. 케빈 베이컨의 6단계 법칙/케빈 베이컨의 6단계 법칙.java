import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        int answer = 1;
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = bfsSum(i, N, adj);
            if (sum < minSum) {
                minSum = sum;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static int bfsSum(int start, int N, ArrayList<Integer>[] adj) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        q.add(start);
        int sum = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nx : adj[cur]) {
                if (dist[nx] == -1) {
                    dist[nx] = dist[cur] + 1;
                    sum += dist[nx];
                    q.add(nx);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (dist[i] == -1) return Integer.MAX_VALUE / 2;
        }
        return sum;
    }
}