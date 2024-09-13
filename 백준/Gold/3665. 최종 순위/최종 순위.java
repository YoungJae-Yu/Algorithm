import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        while (T-- > 0) {
            int n = sc.nextInt(); // 팀의 수
            int[] indegree = new int[n + 1]; // 진입 차수
            boolean[][] graph = new boolean[n + 1][n + 1]; // 그래프 정보

            // 작년 순위를 입력받음
            int[] lastYearRank = new int[n];
            for (int i = 0; i < n; i++) {
                lastYearRank[i] = sc.nextInt();
            }

            // 작년 순위에 따라 그래프를 구성
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    graph[lastYearRank[i]][lastYearRank[j]] = true;
                    indegree[lastYearRank[j]]++;
                }
            }

            // 순위가 바뀐 정보 입력
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                // a와 b의 순위를 변경
                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    graph[b][a] = false;
                    graph[a][b] = true;
                    indegree[b]++;
                    indegree[a]--;
                }
            }

            // 위상 정렬
            List<Integer> result = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();

            // 진입 차수가 0인 팀을 큐에 추가
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }

            boolean certain = true; // 순위가 확정된 경우
            boolean cycle = false; // 사이클이 발생한 경우

            for (int i = 0; i < n; i++) {
                if (queue.isEmpty()) {
                    cycle = true;
                    break;
                }

                if (queue.size() > 1) {
                    certain = false;
                }

                int now = queue.poll();
                result.add(now);

                for (int j = 1; j <= n; j++) {
                    if (graph[now][j]) {
                        indegree[j]--;
                        if (indegree[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
            }

            if (cycle) {
                System.out.println("IMPOSSIBLE");
            } else if (!certain) {
                System.out.println("?");
            } else {
                for (int i : result) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}