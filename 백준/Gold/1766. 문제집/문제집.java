import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 문제의 수
        int m = sc.nextInt(); // 순서 조건의 수

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n + 1]; // 각 문제의 진입 차수를 저장할 배열

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 순서 조건 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            indegree[b]++;
        }

        // 우선순위 큐 사용 (번호가 낮은 문제부터 풀기 위해)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 진입 차수가 0인 문제들을 큐에 추가
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        // 위상 정렬 수행
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int current = pq.poll();
            result.add(current);

            for (int next : graph.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        // 결과 출력
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}