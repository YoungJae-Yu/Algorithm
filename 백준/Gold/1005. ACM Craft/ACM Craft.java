import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] time; // 건물을 짓는데 걸리는 시간
    static int[] inDegree; // 진입 차수
    static int[] result; // 각 건물까지 걸리는 최소 시간
    static ArrayList<ArrayList<Integer>> graph; // 건물간의 연결 정보
    static int N; // 건물의 개수
    static int W; // 승리하기 위해 건설해야 할 건물의 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            time = new int[N + 1];
            inDegree = new int[N + 1];
            result = new int[N + 1];
            graph = new ArrayList<>();

            // 초기화
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            // 그래프 정보 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph.get(X).add(Y);
                inDegree[Y]++;
            }

            W = Integer.parseInt(br.readLine());

            topologicalSort();
            System.out.println(result[W]);
        }
    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수가 0인 노드들을 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                result[i] = time[i]; // 각 건물의 초기 건설 시간 설정
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                // 현재 건물을 짓고 다음 건물로 이동
                result[next] = Math.max(result[next], result[current] + time[next]);
                if (--inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
