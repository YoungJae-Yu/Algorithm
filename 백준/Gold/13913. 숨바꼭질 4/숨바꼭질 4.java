import java.io.*;
import java.util.*;

/**
 * 숨바꼭질 4 문제를 해결하는 프로그램입니다.
 * BFS를 사용하여 가장 빠른 시간과 그 경로를 찾아냅니다.
 */
public class Main {
    static final int MAX = 100001;
    static int[] prev = new int[MAX];  // 이전 위치를 저장하는 배열
    static boolean[] visited = new boolean[MAX];  // 방문 여부를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 수빈이의 위치 N과 동생의 위치 K를 입력받습니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // BFS를 통해 최소 시간을 구하고 경로를 추적합니다.
        int time = bfs(N, K);

        // 결과를 출력합니다.
        StringBuilder sb = new StringBuilder();
        sb.append(time).append('\n');
        Stack<Integer> path = new Stack<>();
        for (int at = K; at != N; at = prev[at]) {
            path.push(at);
        }
        path.push(N);
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(' ');
        }
        System.out.println(sb.toString());
    }

    /**
     * BFS 알고리즘을 사용하여 최소 시간을 찾고 경로를 추적합니다.
     *
     * @param N 수빈이의 초기 위치
     * @param K 동생의 위치
     * @return 최소 시간
     */
    static int bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[MAX];  // 해당 위치까지의 시간을 저장하는 배열

        queue.add(N);
        visited[N] = true;
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                return dist[current];
            }

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next < MAX && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    dist[next] = dist[current] + 1;
                    prev[next] = current;  // 경로 추적을 위해 이전 위치 저장
                }
            }
        }
        return -1;  // 도달할 수 없는 경우 (문제의 제한상 이 경우는 발생하지 않음)
    }
}
