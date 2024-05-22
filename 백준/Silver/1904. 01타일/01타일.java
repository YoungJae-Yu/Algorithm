import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N+1];

        // 초기 조건 설정
        DP[1] = 1;
        if (N > 1) DP[2] = 2;

        // DP를 이용한 점화식 계산
        for (int i = 3; i <= N; i++) {
            DP[i] = (DP[i-1] + DP[i-2]) % 15746;
        }

        // 결과 출력
        System.out.println(DP[N]);
    }
}
