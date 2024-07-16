import java.util.*;

public class Main {
    static int[] visitOrder;
    static int order = 1;
    static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        visitOrder = new int[N + 1];
        dfs(R);
        
        for (int i = 1; i <= N; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    static void dfs(int node) {
        visitOrder[node] = order++;
        for (int next : graph[node]) {
            if (visitOrder[next] == 0) {
                dfs(next);
            }
        }
    }
}