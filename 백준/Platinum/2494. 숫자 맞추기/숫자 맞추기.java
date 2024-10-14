import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int[] start, target;
    static int[][] dp;
    static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        start = new int[N];
        target = new int[N];
        dp = new int[N][10];
        move = new int[N];

        String startStr = br.readLine();
        String targetStr = br.readLine();

        for (int i = 0; i < N; i++) {
            start[i] = startStr.charAt(i) - '0';
            target[i] = targetStr.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                dp[i][j] = -1;
            }
        }

        int result = dfs(0, 0);
        System.out.println(result);
        printPath(0, 0);
    }

    static int dfs(int idx, int rotation) {
        if (idx == N) return 0;
        if (dp[idx][rotation] != -1) return dp[idx][rotation];

        int curNum = (start[idx] + rotation) % 10;
        int targetNum = target[idx];

        int clockwise = (targetNum - curNum + 10) % 10;
        int counterClockwise = (curNum - targetNum + 10) % 10;

        // 시계 방향 회전
        int res1 = dfs(idx + 1, (rotation + clockwise) % 10) + clockwise;
        // 반시계 방향 회전
        int res2 = dfs(idx + 1, rotation) + counterClockwise;

        return dp[idx][rotation] = Math.min(res1, res2);
    }

    static void printPath(int idx, int rotation) {
        if (idx == N) return;

        int curNum = (start[idx] + rotation) % 10;
        int targetNum = target[idx];

        int clockwise = (targetNum - curNum + 10) % 10;
        int counterClockwise = (curNum - targetNum + 10) % 10;

        int res1 = dp[idx][rotation] == dfs(idx + 1, (rotation + clockwise) % 10) + clockwise ? 1 : 0;

        if (res1 == 1) {
            System.out.println((idx + 1) + " " + clockwise);
            printPath(idx + 1, (rotation + clockwise) % 10);
        } else {
            System.out.println((idx + 1) + " " + -counterClockwise);
            printPath(idx + 1, rotation);
        }
    }
}