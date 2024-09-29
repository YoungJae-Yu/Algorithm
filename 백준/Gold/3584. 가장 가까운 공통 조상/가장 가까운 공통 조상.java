import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());  // 노드의 개수
            parent = new int[N + 1];
            visited = new boolean[N + 1];

            // 트리의 간선 정보 입력 및 부모 설정
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                parent[B] = A;  // B의 부모는 A
            }

            // 공통 조상을 찾을 두 노드 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 루트 노드를 찾아가며 공통 조상 탐색
            findCommonAncestor(node1, node2);
        }
    }

    // 공통 조상을 찾는 메서드
    static void findCommonAncestor(int node1, int node2) {
        // 첫 번째 노드부터 부모를 따라가며 방문 체크
        while (node1 != 0) {
            visited[node1] = true;
            node1 = parent[node1];
        }

        // 두 번째 노드부터 부모를 따라가며 방문된 노드를 찾으면 공통 조상
        while (!visited[node2]) {
            node2 = parent[node2];
        }

        // 공통 조상 출력
        System.out.println(node2);
    }
}