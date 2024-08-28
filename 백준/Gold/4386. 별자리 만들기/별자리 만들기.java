import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v;
    double weight;

    Edge(int u, int v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) parent[rootX] = rootY;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] stars = new double[n][2];
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stars[i][0] = sc.nextDouble();
            stars[i][1] = sc.nextDouble();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                edges.add(new Edge(i, j, distance));
            }
        }

        Collections.sort(edges);
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        double result = 0;
        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                result += edge.weight;
            }
        }

        System.out.printf("%.2f\n", result);
    }
}