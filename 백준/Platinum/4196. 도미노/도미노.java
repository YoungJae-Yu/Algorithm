import java.io.*;
import java.util.*;

public class Main {
    static int[] id, sccId;
    static boolean[] finished;
    static Stack<Integer> stack;
    static ArrayList<Integer>[] graph;
    static int nodeId, sccCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 노드 수
            int M = Integer.parseInt(st.nextToken());  // 간선 수

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
            }

            id = new int[N + 1];
            sccId = new int[N + 1];
            finished = new boolean[N + 1];
            stack = new Stack<>();
            nodeId = 1;
            sccCount = 0;

            for (int i = 1; i <= N; i++) {
                if (id[i] == 0) {
                    dfs(i);
                }
            }

            int[] sccInDegree = new int[sccCount];
            for (int i = 1; i <= N; i++) {
                for (int next : graph[i]) {
                    if (sccId[i] != sccId[next]) {
                        sccInDegree[sccId[next]]++;
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < sccCount; i++) {
                if (sccInDegree[i] == 0) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }

    static int dfs(int x) {
        id[x] = nodeId++;
        int parent = id[x];
        stack.push(x);

        for (int next : graph[x]) {
            if (id[next] == 0) {
                parent = Math.min(parent, dfs(next));
            } else if (!finished[next]) {
                parent = Math.min(parent, id[next]);
            }
        }

        if (parent == id[x]) {
            while (true) {
                int node = stack.pop();
                finished[node] = true;
                sccId[node] = sccCount;
                if (node == x) break;
            }
            sccCount++;
        }

        return parent;
    }
}