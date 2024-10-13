import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] current;
    static int[] target;
    static int[][] memo;

    public static int dfs(int idx, int rotation) {
        if (idx == N) return 0;
        if (memo[idx][rotation] != -1) return memo[idx][rotation];

        // 현재 자리의 실제 숫자 (이전 회전량을 적용)
        int curDigit = (current[idx] + rotation) % 10;
        // 목표 숫자와의 차이
        int diff = (target[idx] - curDigit + 10) % 10;

        // 시계 방향으로 diff만큼 회전하는 경우
        int moveClockwise = diff + dfs(idx + 1, (rotation + diff) % 10);
        // 반시계 방향으로 (10 - diff)만큼 회전하는 경우
        int moveCounterClockwise = (10 - diff) + dfs(idx + 1, rotation);

        // 최소값 선택
        int res = Math.min(moveClockwise, moveCounterClockwise);
        memo[idx][rotation] = res;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        String currentStr = sc.next();
        String targetStr = sc.next();

        current = new int[N];
        target = new int[N];
        memo = new int[N][10];

        for (int[] row : memo) Arrays.fill(row, -1);

        for (int i = 0; i < N; i++) {
            current[i] = currentStr.charAt(i) - '0';
            target[i] = targetStr.charAt(i) - '0';
        }

        int result = dfs(0, 0);
        System.out.println(result);
    }
}