import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class Main {
    static int[] parent;

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY)
            parent[rootX] = rootY;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt(); // 정점의 개수
            int m = sc.nextInt(); // 간선의 개수

            if (n == 0 && m == 0)
                break;

            List<Edge> edges = new ArrayList<>();
            parent = new int[n]; // 배열 크기를 정점의 개수로 설정
            int totalWeight = 0;

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int weight = sc.nextInt();
                edges.add(new Edge(u, v, weight));
                totalWeight += weight;
            }

            Collections.sort(edges);

            // 초기화
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            int mstWeight = 0;

            // 크루스칼 알고리즘
            for (Edge edge : edges) {
                if (find(edge.u) != find(edge.v)) {
                    union(edge.u, edge.v);
                    mstWeight += edge.weight;
                }
            }

            // 절약할 수 있는 비용 = 전체 비용 - MST 비용
            int savings = totalWeight - mstWeight;
            System.out.println(savings);
        }

        sc.close();
    }
}