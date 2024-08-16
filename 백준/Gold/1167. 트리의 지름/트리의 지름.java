import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int vertex;
    int distance;

    Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}

public class Main {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int maxDistance;
    static int maxNode;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        // 트리 초기화
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리의 간선 정보 입력 받기
        for (int i = 0; i < V; i++) {
            int node = sc.nextInt();
            while (true) {
                int adjacent = sc.nextInt();
                if (adjacent == -1) break;
                int distance = sc.nextInt();
                tree[node].add(new Node(adjacent, distance));
            }
        }

        // 임의의 노드(1번 노드)에서 가장 먼 노드 찾기
        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(1, 0);

        // 찾은 노드(maxNode)에서 가장 먼 노드 찾기
        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(maxNode, 0);

        // 결과 출력
        System.out.println(maxDistance);
    }

    // DFS 함수
    static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            maxNode = node;
        }

        for (Node n : tree[node]) {
            if (!visited[n.vertex]) {
                dfs(n.vertex, distance + n.distance);
            }
        }
    }
}