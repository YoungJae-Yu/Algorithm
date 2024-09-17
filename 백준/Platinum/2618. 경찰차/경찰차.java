import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, W;
    static int[][] incidents;
    static int[][] dp;
    static int[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        incidents = new int[W + 1][2];
        dp = new int[W + 1][W + 1];
        path = new int[W + 1][W + 1];

        for (int i = 1; i <= W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            incidents[i][0] = Integer.parseInt(st.nextToken());
            incidents[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(0, 0));
        printPath(0, 0);
    }

    static int solve(int car1, int car2) {
        int next = Math.max(car1, car2) + 1;
        if (next > W) return 0;

        if (dp[car1][car2] != 0) return dp[car1][car2];

        // 경찰차 1이 다음 사건을 처리하는 경우
        int dist1 = getDistance(car1, next, true) + solve(next, car2);
        // 경찰차 2가 다음 사건을 처리하는 경우
        int dist2 = getDistance(car2, next, false) + solve(car1, next);

        if (dist1 < dist2) {
            dp[car1][car2] = dist1;
            path[car1][car2] = 1;
        } else {
            dp[car1][car2] = dist2;
            path[car1][car2] = 2;
        }

        return dp[car1][car2];
    }

    static int getDistance(int from, int to, boolean isCar1) {
        int x1, y1;
        if (from == 0) {
            if (isCar1) {
                x1 = 1;
                y1 = 1;
            } else {
                x1 = N;
                y1 = N;
            }
        } else {
            x1 = incidents[from][0];
            y1 = incidents[from][1];
        }
        int x2 = incidents[to][0];
        int y2 = incidents[to][1];
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void printPath(int car1, int car2) {
        int next = Math.max(car1, car2) + 1;
        if (next > W) return;

        System.out.println(path[car1][car2]);
        if (path[car1][car2] == 1) {
            printPath(next, car2);
        } else {
            printPath(car1, next);
        }
    }
}