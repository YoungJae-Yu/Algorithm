import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.close();

        boolean[][] visited = new boolean[M][N];
        int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
        int[] dy = {1, 0, -1, 0}; // 우, 하, 좌, 상

        int x = 0, y = 0, dir = 0, turnCount = 0, visitedCount = 1;
        visited[x][y] = true;

        while (visitedCount < M * N) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
                x = nx;
                y = ny;
                visited[x][y] = true;
                visitedCount++;
            } else {
                dir = (dir + 1) % 4;
                turnCount++;
            }
        }

        System.out.println(turnCount);
    }
}