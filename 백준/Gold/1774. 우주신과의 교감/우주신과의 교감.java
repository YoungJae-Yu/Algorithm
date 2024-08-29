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
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        double[][] pos = new double[n + 1][2];
        for (int i = 1; i <= n; i++) {
            pos[i][0] = sc.nextDouble();
            pos[i][1] = sc.nextDouble();
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            union(u, v);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                double dist = Math.sqrt(Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2));
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);
        double result = 0;

        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                result += e.weight;
            }
        }

        System.out.printf("%.2f", result);
    }
}