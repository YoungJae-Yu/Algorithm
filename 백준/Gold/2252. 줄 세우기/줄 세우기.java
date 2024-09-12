import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        // 위상 정렬을 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        // 진입 차수가 0인 정점을 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 위상 정렬 결과 저장
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            // 현재 정점과 연결된 정점들의 진입 차수를 줄임
            for (int next : graph[current]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}