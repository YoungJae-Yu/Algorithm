import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, dist;
        boolean wallBroken;

        Node(int x, int y, int dist, boolean wallBroken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wallBroken = wallBroken;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == N - 1 && node.y == M - 1) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (!node.wallBroken && !visited[nx][ny][0]) {
                            visited[nx][ny][0] = true;
                            queue.add(new Node(nx, ny, node.dist + 1, false));
                        } else if (node.wallBroken && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, node.dist + 1, true));
                        }
                    } else {
                        if (!node.wallBroken && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, node.dist + 1, true));
                        }
                    }
                }
            }
        }

        return -1;
    }
}