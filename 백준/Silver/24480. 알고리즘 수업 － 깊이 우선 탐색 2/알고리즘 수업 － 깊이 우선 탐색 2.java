import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int counter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        order = new int[n + 1];
        
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
            Collections.sort(graph[i], Collections.reverseOrder());
        }
        
        dfs(r);
        
        for (int i = 1; i <= n; i++) {
            System.out.println(order[i]);
        }
        
        sc.close();
    }
    
    static void dfs(int node) {
        visited[node] = true;
        order[node] = counter++;
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}