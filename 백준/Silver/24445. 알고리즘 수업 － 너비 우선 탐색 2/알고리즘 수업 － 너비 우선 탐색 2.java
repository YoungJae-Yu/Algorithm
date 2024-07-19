import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        List<Integer>[] graph = new ArrayList[N + 1];
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
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        int[] visited = new int[N + 1];
        bfs(graph, visited, R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void bfs(List<Integer>[] graph, int[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        int order = 1;
        queue.add(start);
        visited[start] = order++;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph[node]) {
                if (visited[next] == 0) {
                    queue.add(next);
                    visited[next] = order++;
                }
            }
        }
    }
}