import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 줄바꿈 문자 제거
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startX, int startY) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;
        int[][] distance = new int[N][M];
        distance[startX][startY] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }

        return distance[N - 1][M - 1];
    }
}