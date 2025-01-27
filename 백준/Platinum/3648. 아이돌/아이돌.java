import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph, reversedGraph;
    static boolean[] visited;
    static int[] component;
    static Stack<Integer> stack;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) { // 모든 테스트 케이스 처리
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) break; // 빈 줄 처리 방지
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int nodes = 2 * n;

            // 그래프 초기화
            graph = new ArrayList[nodes];
            reversedGraph = new ArrayList[nodes];
            for (int i = 0; i < nodes; i++) {
                graph[i] = new ArrayList<>();
                reversedGraph[i] = new ArrayList<>();
            }

            // 절 추가
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int u = parseLiteral(a);
                int v = parseLiteral(b);
                addEdge(u ^ 1, v);
                addEdge(v ^ 1, u);
            }

            // x1이 참이어야 하는 조건 추가 (x1 OR x1)
            int x1 = 1;
            int a = parseLiteral(x1);
            addEdge(a ^ 1, a);

            // 역방향 그래프 생성
            buildReversedGraph();

            // Kosaraju 알고리즘 수행
            stack = new Stack<>();
            visited = new boolean[nodes];
            for (int i = 0; i < nodes; i++) {
                if (!visited[i]) dfs(i);
            }

            Arrays.fill(visited, false);
            component = new int[nodes];
            int compId = 0;
            while (!stack.isEmpty()) {
                int u = stack.pop();
                if (!visited[u]) {
                    dfsRev(u, compId);
                    compId++;
                }
            }

            // 모순 확인
            boolean possible = true;
            for (int i = 0; i < nodes; i += 2) {
                if (component[i] == component[i ^ 1]) {
                    possible = false;
                    break;
                }
            }

            System.out.println(possible ? "yes" : "no");
        }
    }

    static int parseLiteral(int a) {
        if (a > 0) return (a - 1) * 2;
        else return (-a - 1) * 2 + 1;
    }

    static void addEdge(int u, int v) {
        graph[u].add(v);
    }

    static void buildReversedGraph() {
        for (int u = 0; u < graph.length; u++) {
            for (int v : graph[u]) {
                reversedGraph[v].add(u);
            }
        }
    }

    static void dfs(int u) {
        visited[u] = true;
        for (int v : graph[u]) {
            if (!visited[v]) dfs(v);
        }
        stack.push(u);
    }

    static void dfsRev(int u, int compId) {
        visited[u] = true;
        component[u] = compId;
        for (int v : reversedGraph[u]) {
            if (!visited[v]) dfsRev(v, compId);
        }
    }
}