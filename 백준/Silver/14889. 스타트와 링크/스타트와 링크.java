import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[N];
        combination(visited, 0, 0);
        System.out.println(minDiff);
    }

    // 백트래킹을 사용한 조합 생성
    public static void combination(boolean[] visited, int start, int depth) {
        if (depth == N / 2) {
            calculateDifference(visited);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(visited, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 팀 간의 능력치 차이 계산
    public static void calculateDifference(boolean[] visited) {
        int startTeamPower = 0;
        int linkTeamPower = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeamPower += S[i][j];
                } else if (!visited[i] && !visited[j]) {
                    linkTeamPower += S[i][j];
                }
            }
        }

        int diff = Math.abs(startTeamPower - linkTeamPower);
        if (diff < minDiff) {
            minDiff = diff;
        }
    }
}