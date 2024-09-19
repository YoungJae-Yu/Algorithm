import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to; this.cost = cost;
        }
    }
    
    static int N, M, start, end;
    static List<List<Edge>> adj;
    static int[] dist, prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Edge(v, c));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        dist = new int[N+1];
        prev = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        
        dijkstra();
        
        System.out.println(dist[end]);
        
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println(path.size());
        for (int city : path) {
            System.out.print(city + " ");
        }
    }
    
    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.to;
            int cost = cur.cost;
            
            if (dist[u] < cost) continue;
            
            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int newCost = dist[u] + edge.cost;
                
                if (dist[v] > newCost) {
                    dist[v] = newCost;
                    prev[v] = u;
                    pq.offer(new Edge(v, newCost));
                }
            }
        }
    }
}