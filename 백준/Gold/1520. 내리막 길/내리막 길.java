import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int M, N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        // 도착지에 도달하면 1 반환
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        // 이미 계산된 값이 있으면 그 값 반환
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        // 경로의 수 초기화
        dp[x][y] = 0;

        // 네 방향으로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도의 범위를 벗어나지 않으며, 내리막길 조건을 만족하는 경우
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}