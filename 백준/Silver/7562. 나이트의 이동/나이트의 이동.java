import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int l = sc.nextInt();
            int[][] board = new int[l][l];

            Point start = new Point(sc.nextInt(), sc.nextInt());
            Point end = new Point(sc.nextInt(), sc.nextInt());

            System.out.println(bfs(l, board, start, end));
        }

        sc.close();
    }

    static int bfs(int l, int[][] board, Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        board[start.x][start.y] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == end.x && p.y == end.y) {
                return board[p.x][p.y] - 1;
            }

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < l && ny < l && board[nx][ny] == 0) {
                    board[nx][ny] = board[p.x][p.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return 0;
    }
}