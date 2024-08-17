import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int maxNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }
        
        visited = new boolean[n + 1];
        dfs(1, 0);
        
        visited = new boolean[n + 1];
        dfs(maxNode, 0);
        
        System.out.println(maxDistance);
    }
    
    static void dfs(int node, int distance) {
        visited[node] = true;
        
        if (distance > maxDistance) {
            maxDistance = distance;
            maxNode = node;
        }
        
        for (Node next : tree[node]) {
            if (!visited[next.to]) {
                dfs(next.to, distance + next.weight);
            }
        }
    }
}