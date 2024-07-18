import java.util.*;

public class Main {
    static void bfs(int start, List<Integer>[] graph, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int order = 1;
        queue.add(start);
        visited[start] = order++;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (visited[neighbor] == 0) {
                    queue.add(neighbor);
                    visited[neighbor] = order++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 수
        int m = sc.nextInt(); // 간선 수
        int r = sc.nextInt(); // 시작 노드
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        
        int[] visited = new int[n + 1];
        bfs(r, graph, visited);
        
        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }
}