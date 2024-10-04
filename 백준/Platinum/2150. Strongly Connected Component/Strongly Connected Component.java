import java.util.*;
import java.io.*;

public class Main {
    static int V, E;
    static List<Integer>[] graph, reverseGraph;
    static boolean[] visited;
    static Stack<Integer> stack;
    static List<List<Integer>> sccList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[V + 1];
        reverseGraph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            reverseGraph[v].add(u);
        }

        visited = new boolean[V + 1];
        stack = new Stack<>();
        
        // 1. DFS를 이용해 정방향 그래프에서 탐색 순서를 기록
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // 2. 역방향 그래프에서 SCC를 탐색
        visited = new boolean[V + 1];
        sccList = new ArrayList<>();
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> scc = new ArrayList<>();
                reverseDfs(node, scc);
                Collections.sort(scc);
                sccList.add(scc);
            }
        }

        // 3. SCC 출력
        Collections.sort(sccList, (a, b) -> a.get(0) - b.get(0));
        
        StringBuilder sb = new StringBuilder();
        sb.append(sccList.size()).append("\n");
        for (List<Integer> scc : sccList) {
            for (int node : scc) {
                sb.append(node).append(" ");
            }
            sb.append("-1\n");
        }

        System.out.print(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
        stack.push(node);
    }

    static void reverseDfs(int node, List<Integer> scc) {
        visited[node] = true;
        scc.add(node);
        for (int next : reverseGraph[node]) {
            if (!visited[next]) {
                reverseDfs(next, scc);
            }
        }
    }
}