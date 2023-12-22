import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int[][] field = new int[M][N];
            for (int i = 0; i < K; i++) {
                int X = scanner.nextInt();
                int Y = scanner.nextInt();
                field[X][Y] = 1;
            }

            int result = countCabbageWorms(field);
            System.out.println(result);
        }
    }

    private static int countCabbageWorms(int[][] field) {
        int count = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1) {
                    count++;
                    dfs(field, i, j); // 인접한 배추들을 모두 그룹화하기 위해 DFS 호출
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] field, int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        field[x][y] = -1; // 방문 표시

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < field.length && ny < field[0].length) {
                if (field[nx][ny] == 1) {
                    dfs(field, nx, ny); // 인접한 배추가 있다면 계속해서 DFS 호출
                }
            }
        }
    }
}
