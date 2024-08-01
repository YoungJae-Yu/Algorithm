import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int index;
        int distance;
        
        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }
    
    static int N, E;
    static List<Node>[] graph;
    static int[] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        long path1 = 0;
        path1 += dijkstra(1, v1);
        path1 += dijkstra(v1, v2);
        path1 += dijkstra(v2, N);
        
        long path2 = 0;
        path2 += dijkstra(1, v2);
        path2 += dijkstra(v2, v1);
        path2 += dijkstra(v1, N);
        
        long result = Math.min(path1, path2);
        
        if (result >= Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }
    
    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (current.index == end) {
                return dist[end];
            }
            
            for (Node next : graph[current.index]) {
                if (dist[next.index] > dist[current.index] + next.distance) {
                    dist[next.index] = dist[current.index] + next.distance;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }
        return dist[end];
    }
}