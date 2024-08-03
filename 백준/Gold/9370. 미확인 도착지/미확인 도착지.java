import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            int s = sc.nextInt();
            int g = sc.nextInt();
            int h = sc.nextInt();

            List<Node>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt();
                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));
            }

            int[] targets = new int[t];
            for (int i = 0; i < t; i++) {
                targets[i] = sc.nextInt();
            }

            int[] distFromS = dijkstra(graph, s, n);
            int[] distFromG = dijkstra(graph, g, n);
            int[] distFromH = dijkstra(graph, h, n);

            List<Integer> result = new ArrayList<>();
            for (int target : targets) {
                int distViaGH = distFromS[g] + distFromG[h] + distFromH[target];
                int distViaHG = distFromS[h] + distFromH[g] + distFromG[target];

                if (distFromS[target] == distViaGH || distFromS[target] == distViaHG) {
                    result.add(target);
                }
            }

            Collections.sort(result);
            for (int r : result) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

    static int[] dijkstra(List<Node>[] graph, int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            int cost = current.cost;

            if (cost > dist[u]) continue;

            for (Node neighbor : graph[u]) {
                int v = neighbor.vertex;
                int newDist = cost + neighbor.cost;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new Node(v, newDist));
                }
            }
        }
        return dist;
    }
}