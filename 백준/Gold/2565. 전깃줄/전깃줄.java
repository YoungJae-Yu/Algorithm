import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 전깃줄 정보 저장 (A번 전봇대에 연결된 전깃줄의 B번 전봇대 위치)
        int[][] wires = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        // A번 전봇대 기준 오름차순 정렬
        Arrays.sort(wires, Comparator.comparingInt(a -> a[0]));

        // LIS (Longest Increasing Subsequence) 적용
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 현재 전깃줄의 B번 위치가 이전 전깃줄의 B번 위치보다 크다면
                if (wires[i][1] > wires[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 최장 길이 갱신
                }
            }
        }

        // 최장 증가하는 부분 수열 길이 = 연결할 수 있는 최대 전깃줄 개수
        int maxCount = Arrays.stream(dp).max().getAsInt();

        // 제거해야 할 전깃줄 수 = 전체 전깃줄 수 - 연결할 수 있는 최대 전깃줄 개수
        System.out.println(N - maxCount);
    }
}
