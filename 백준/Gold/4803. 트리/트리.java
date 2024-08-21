import java.util.*;

public class Main {
    static boolean[] visited;
    static boolean isTree;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = 0;
        
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;
            
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
            
            visited = new boolean[n + 1];
            int treeCount = 0;
            
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    isTree = true;
                    dfs(graph, i, -1);
                    if (isTree) treeCount++;
                }
            }
            
            caseNum++;
            System.out.printf("Case %d: ", caseNum);
            if (treeCount == 0) {
                System.out.println("No trees.");
            } else if (treeCount == 1) {
                System.out.println("There is one tree.");
            } else {
                System.out.printf("A forest of %d trees.%n", treeCount);
            }
        }
    }
    
    static void dfs(List<Integer>[] graph, int node, int parent) {
        visited[node] = true;
        
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, node);
            } else if (neighbor != parent) {
                isTree = false;
            }
        }
    }
}