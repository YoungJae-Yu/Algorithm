import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, weight;
    
    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Edge> edges = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int islandNum = 2; // 섬 번호 시작 (1이 아닌 2부터)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, islandNum++);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 1) {
                    findEdges(i, j, map[i][j]);
                }
            }
        }

        Collections.sort(edges);
        parent = new int[islandNum];
        for (int i = 0; i < islandNum; i++) {
            parent[i] = i;
        }

        int result = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (union(edge.u, edge.v)) {
                result += edge.weight;
                count++;
            }
        }

        if (count == islandNum - 3) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(int x, int y, int islandNum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = islandNum;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = islandNum;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void findEdges(int x, int y, int islandNum) {
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            int distance = 0;

            while (true) {
                nx += dx[i];
                ny += dy[i];
                distance++;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                if (map[nx][ny] == islandNum) break;
                if (map[nx][ny] > 0 && map[nx][ny] != islandNum) {
                    if (distance > 2) {
                        edges.add(new Edge(islandNum, map[nx][ny], distance - 1));
                    }
                    break;
                }
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
}